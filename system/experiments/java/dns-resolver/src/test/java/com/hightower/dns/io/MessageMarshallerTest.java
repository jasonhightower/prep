package com.hightower.dns.io;

import com.hightower.dns.Header;
import com.hightower.dns.Message;
import com.hightower.dns.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageMarshallerTest {

    private MessageMarshaller classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MessageMarshaller();
    }

    @Test
    public void testMarshalQuestion() throws IOException {
        char id = (char)22;
        Message message = new Message.Builder()
                // TODO these should be part of the message
                // and not a distinct header
                .setHeader(new Header.Builder(id)
                    .flags(Header.RECURSIVE_DESIRED)
                    .questionCount((char)1)
                    .build())
                .addQuestion(new Question.Builder()
                    .setName("dns.google.com")
                    .build())
                .build();

        byte[] messageBytes = this.classUnderTest.marshal(message);
        final String hex = HexFormat.of().formatHex(messageBytes);
        final String expected = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        assertEquals(expected, hex);
    }

}
