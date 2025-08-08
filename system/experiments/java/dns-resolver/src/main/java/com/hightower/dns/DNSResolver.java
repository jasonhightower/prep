package com.hightower.dns;

import com.hightower.dns.io.DNSClient;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DNSResolver {

    private DNSClient client;

    public DNSResolver(final DatagramSocket socket) {
        this.client = new DNSClient(socket);
    }

    public List<String> resolve(final String domain, final InetAddress hostIp, final String hostType) throws IOException {
        System.out.printf("[%s] %s%n", hostType, hostIp);
        Message message = new Message.Builder()
                .setHeader(new Header.Builder((char)22)
                        .questionCount((char)1)
                        .build())
                .addQuestion(new Question.Builder()
                        .setName(domain)
                        .setQueryType(Message.TYPE_A)
                        .setQueryClass(Message.CLASS_INTERNET)
                        .build())
                .build();
        Message response = this.client.send(hostIp, message);
        if (response.header().getStatus() != Header.SUCCESS) {
            System.err.printf("Failure: %d\n", response.header().getStatus());
            System.exit(1);
        }

        // this needs to happen in a loop
        if (response.header().answerCount() <= 0 &&
            response.header().nsCount() > 0) {
            Answer authority = response.authorities().get(0);
            Optional<String> additional = findAdditional(authority.data(), Message.TYPE_A, response.additionals());
            if (additional.isPresent()) {
//                System.out.println(additional.get());
                return resolve(domain, InetAddress.getByName(additional.get()), " NS ");
            }
            // TODO JH some sort of error
            return List.of("");
        }
        List<String> results = new ArrayList<>();
        for (Answer answer: response.answers()) {
            if (answer.type() == Message.TYPE_A &&
                    answer.aclass() == Message.CLASS_INTERNET) {
                results.add(answer.data());
            }
            // TODO JH handle TYPE_AAAA and other types
        }
        return results;
    }

    public Optional<String> findAdditional(final String host, final char type, List<Answer> additionals) {
        for (Answer additional: additionals) {
            if (host.equals(additional.name()) && additional.type() == type) {
                return Optional.of(additional.data());
            }
        }
        return Optional.empty();
    }


    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
           System.err.println("Not enough args");
           return;
        }
        final String domain = args[0];
        try (DatagramSocket socket = new DatagramSocket(4343)) {
            DNSResolver resolver = new DNSResolver(socket);
            List<String> ips = resolver.resolve(domain, InetAddress.getByName("198.41.0.4"), "ROOT");
            System.out.println();
            System.out.println(domain);
            for (String ip: ips) {
                System.out.printf("    %s%n", ip);
            }

        }
    }

}
