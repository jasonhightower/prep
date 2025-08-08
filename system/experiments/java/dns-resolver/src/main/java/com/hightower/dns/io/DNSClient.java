package com.hightower.dns.io;

import com.hightower.dns.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DNSClient {

    private final DatagramSocket socket;
    private final MessageMarshaller marshaller;
    private final MessageUnmarshaller unmarshaller;

    public DNSClient(final DatagramSocket socket) {
        this.socket = socket;
        this.marshaller = new MessageMarshaller();
        this.unmarshaller = new MessageUnmarshaller();
    }

    public Message send(final InetAddress serverAddress, final Message message) throws IOException {
        // TODO support marshalling to a byte array so that the same byte array can be used for send and receive
        // send
        byte[] msg = this.marshaller.marshal(message);
        DatagramPacket packet = new DatagramPacket(msg, msg.length, serverAddress, 53);
        this.socket.send(packet);

        // receive
        msg = new byte[512];
        packet.setData(msg, 0, msg.length);
        this.socket.receive(packet);
        return this.unmarshaller.unmarshal(msg);
    }

}
