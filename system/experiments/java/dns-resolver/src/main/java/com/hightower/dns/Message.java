package com.hightower.dns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Message(Header header,
                      List<Question> questions,
                      List<Answer> answers,
                      List<Answer> authorities,
                      List<Answer> additionals) {

    public static final char CLASS_INTERNET = 1;
    public static final char CLASS_CSNET = 2;
    public static final char CLASS_CHAOS = 3;
    public static final char CLASS_HESIOD = 4;
    public static final char QCLASS_ANY = 255;

    public static final char TYPE_A = 1;
    public static final char TYPE_NS = 2;
    @Deprecated // Use MX instead
    public static final char TYPE_MD = 3;
    @Deprecated
    public static final char TYPE_MF = 4;
    public static final char TYPE_CNAME = 5;
    public static final char TYPE_SOA = 6;
    public static final char TYPE_MB = 7;
    public static final char TYPE_MG = 8;
    public static final char TYPE_MR = 9;
    public static final char TYPE_NULL = 10;
    public static final char TYPE_WKS = 11;
    public static final char TYPE_PTR = 12;
    public static final char TYPE_HINFO = 13;
    public static final char TYPE_MINFO = 14;
    public static final char TYPE_MX = 15;
    public static final char TYPE_TXT = 16;

    public static final char TYPE_AAAA = 28;

    public static final char QTYPE_AXFR = 252;
    public static final char QTYPE_MAILB = 253;
    public static final char QTYPE_MAILA = 254;
    public static final char QTYPE_ALL = 255;

    public static class Builder {

        private Header header;
        private List<Question> questions;
        private List<Answer> answers;
        private List<Answer> authorities;
        private List<Answer> additionals;

        public Builder setHeader(Header header) {
            this.header = header;
            return this;
        }

        public Header getHeader() {
            return this.header;
        }

        public Builder addQuestion(Question question) {
            if (this.questions == null) {
                this.questions = new ArrayList<>();
            }
            this.questions.add(question);
            return this;
        }

        public Builder addAnswer(Answer answer) {
            if (this.answers == null) {
                this.answers = new ArrayList<>();
            }
            this.answers.add(answer);
            return this;
        }

        public Builder addAuthority(Answer answer) {
            if (this.authorities == null) {
                this.authorities = new ArrayList<>();
            }
            this.authorities.add(answer);
            return this;
        }

        public Builder addAdditional(Answer answer) {
            if (this.additionals == null) {
                this.additionals = new ArrayList<>();
            }
            this.additionals.add(answer);
            return this;
        }

        public Message build() {
            if (this.answers == null) {
                this.answers = Collections.emptyList();
            }
            return new Message(header, questions, answers, authorities, additionals);
        }

    }

}
