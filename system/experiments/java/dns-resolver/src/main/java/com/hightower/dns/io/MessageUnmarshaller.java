package com.hightower.dns.io;

import com.hightower.dns.Answer;
import com.hightower.dns.Header;
import com.hightower.dns.Message;
import com.hightower.dns.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.HexFormat;

public class MessageUnmarshaller {

    private static class Cursor {
        private int pos;
        public Cursor(int pos) {
            this.pos = pos;
        }
        public int inc(int num) {
            this.pos += num;
            return this.pos;
        }
    }

    public Message read(final InputStream in) throws IOException {
        byte[] bytes = new byte[512];
        int read = in.read(bytes);
        if (read != -1) {
            return unmarshal(bytes);
        } else {
            throw new IOException("Unexpected end of message");
        }
    }

    public Message unmarshal(byte[] bytes) {
        Message.Builder builder = new Message.Builder();
        Cursor cursor = new Cursor(0);
        Header header = this.readHeader(bytes, cursor);
        builder.setHeader(header);
        for (int i = 0; i < header.questionCount(); i++) {
            builder.addQuestion(readQuestion(bytes, cursor));
        }
        for (int i = 0; i < header.answerCount(); i++) {
            builder.addAnswer(readAnswer(bytes, cursor));
        }
        for (int i = 0; i < header.nsCount(); i++) {
            builder.addAuthority(readAnswer(bytes, cursor));
        }
        for (int i = 0; i < header.arCount(); i++) {
            builder.addAdditional(readAnswer(bytes, cursor));
        }
        return builder.build();
    }

    Header readHeader(byte[] bytes, Cursor cursor) {
        return new Header(
                readChar(bytes, cursor),
                readChar(bytes, cursor),
                readChar(bytes, cursor),
                readChar(bytes, cursor),
                readChar(bytes, cursor),
                readChar(bytes, cursor));
    }

    Question readQuestion(final byte[] bytes, final Cursor cursor) {
        Question.Builder builder = new Question.Builder();
        builder.setName(readLabel(bytes, cursor, "", "."));
        builder.setQueryClass(readChar(bytes, cursor));
        builder.setQueryType(readChar(bytes, cursor));
        return builder.build();
    }

    Answer readAnswer(final byte[] bytes, Cursor cursor) {
        Answer.Builder builder = new Answer.Builder();
        builder.setName(readLabel(bytes, cursor, "", "."));
        char type = readChar(bytes, cursor);
        builder.setType(type);
        char aClass = readChar(bytes, cursor);
        builder.setAclass(aClass);
        builder.setTtl(readU32(bytes, cursor));
        char dataLength = readChar(bytes, cursor);
        builder.setData(readRData(type, aClass, bytes, cursor, dataLength));
        return builder.build();
    }

    String readRData(char type, char aclass, byte[] data, Cursor cursor, int length) {
        if (aclass != Message.CLASS_INTERNET) {
            throw new RuntimeException(String.format("Unsupported resource record class %d", (int)aclass));
        }
        switch (type) {
            case Message.TYPE_A:
                // ipv4
                StringBuilder builder = new StringBuilder();
                builder.append(((int)data[cursor.pos] & 0xFF));
                for (int i = 1; i < length; i++) {
                    builder.append('.');
                    builder.append(((int)data[cursor.inc(1)] & 0xFF));
                }
                cursor.inc(1);
                return builder.toString();
            case Message.TYPE_NS:
                String val = readLabel(data, cursor, "", ".");
                return val;
            case Message.TYPE_AAAA:
                // ipv6
                return HexFormat.of().formatHex(data, cursor.pos, cursor.inc(length));
            default:
                throw new RuntimeException(String.format("Unsupported resource record type %d", (int)type));
        }
    }

    String readLabel(final byte[] data, final Cursor cursor, final String prefix, final String join) {
        byte length = data[cursor.pos];
        cursor.inc(1);
        StringBuilder b = new StringBuilder();
        b.append(prefix);
        while (length != 0) {
            if (length == (byte)0xc0) {
                // is pointer
                String val = readLabel(data, new Cursor(((int)data[cursor.pos] & 0xFF)), b.toString(), join);
                cursor.inc(1);
                return val;
            } else {
                if (!b.isEmpty()) {
                    b.append(join);
                }
                b.append(new String(data), cursor.pos, cursor.inc(length));
                length = data[cursor.pos];
                cursor.inc(1);
            }
        }
        return b.toString();
    }

    private char readChar(byte[] data, Cursor cursor) {
        char result = (char) (((data[cursor.pos] & 0xFF) << 8) | (data[cursor.inc(1)] & 0xFF));
        cursor.inc(1);
        return result;
    }

    private long readU32(byte[] data, Cursor cursor) {
        long val = (((long) (data[cursor.pos] & 0xFF) << 24) |
                ((long) (data[cursor.inc(1)] & 0xFF) << 16) |
                ((long) (data[cursor.inc(1)] & 0xFF) << 8) |
                ((long) (data[cursor.inc(1)] & 0xFF)));
        cursor.inc(1);
        return val;
    }


}
