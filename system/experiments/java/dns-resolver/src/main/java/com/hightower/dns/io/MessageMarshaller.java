package com.hightower.dns.io;

import com.hightower.dns.Answer;
import com.hightower.dns.Header;
import com.hightower.dns.Message;
import com.hightower.dns.Question;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MessageMarshaller {

    public byte[] marshal(final Message message) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        marshal(message.header(), out);
        for (Question question: message.questions()) {
            marshal(question, out);
        }
        for (Answer answer: message.answers()) {
            marshal(answer, out);
        }
        return out.toByteArray();
    }

    private void marshal(final Header header, final OutputStream out) throws IOException {
        marshal(header.id(), out);
        // handle flags
        char flags = header.flags();
        if (header.answerCount() > 0) {
            flags |= 0x8000;
        }
        marshal(flags, out);
        marshal(header.questionCount(), out);
        marshal(header.answerCount(), out);
        marshal(header.nsCount(), out);
        marshal(header.arCount(), out);
    }

    private void marshal(final Question question, final OutputStream out) throws IOException {
        marshalName(question.name(), out);
        marshal(question.queryType(), out);
        marshal(question.queryClass(), out);
    }

    private void marshalName(final String name, final OutputStream out) throws IOException {
        String[] labels = name.split("\\.");
        for (String label: labels) {
            out.write((byte)label.length());
            out.write(label.getBytes());
        }
        out.write((byte)0);
    }

    private void marshal(final Answer answer, final OutputStream out) throws IOException {
        // TODO JH implement me
    }

    private void marshal(final char c, final OutputStream out) throws IOException {
        out.write((byte)(c>>8));
        out.write((byte)c);
    }

}
