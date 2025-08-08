package com.hightower.dns;

public record Header(char id,
                     char flags,
                     char questionCount,
                     char answerCount,
                     char nsCount,
                     char arCount) {

    public static final byte STANDARD_QUERY = 0x00;
    public static final byte INVERSE_QUERY = 0x01;
    public static final byte SERVER_STATUS = 0x02;

    public static final byte SUCCESS = 0;
    public static final byte FORMAT_ERROR = 1;
    public static final byte SERVER_FAILURE = 2;
    public static final byte NAME_ERROR = 3;
    public static final byte NOT_IMPLEMENTED = 4;
    public static final byte REFUSED = 5;

    private static final char OPCODE_MASK = 0x7800;
    private static final char AA_MASK = 0x0400;
    private static final char TC_MASK = 0x0200;
    private static final char RD_MASK = 0x0100;
    private static final char RA_MASK = 0x0080;
    private static final char RCODE_MASK = 0x000F;

    public static final char RECURSIVE_DESIRED = RD_MASK;

    public boolean isQueryType(byte type) {
        return (this.flags & OPCODE_MASK) >> 11 == type;
    }

    public boolean isQuestion() {
        return (this.flags & 0xF000) != 0;
    }

    public boolean isAuthoritative() {
        return (this.flags & AA_MASK) != 0;
    }

    public boolean isTruncation() {
        return (this.flags & TC_MASK) != 0;
    }

    public boolean isRecursionDesired() {
        return (this.flags & RD_MASK) != 0;
    }

    public boolean isRecursionAvailable() {
        return (this.flags & RA_MASK) != 0;
    }

    public byte getStatus() {
        return (byte)(this.flags & RCODE_MASK);
    }

    // TODO JH this should be more for humans to construct
    // a header from
    public static final class Builder {
        private char id;
        private char flags;
        private char queryCount;
        private char answerCount;
        private char nsCount;
        private char arCount;
        private boolean recursiveDesired;

        public Builder(char id) {
            this.id = id;
        }

        public Builder recursiveDesired(boolean desired) {
            this.recursiveDesired = desired;
            return this;
        }

        public Builder flags(char flags) {
            this.flags = flags;
            return this;
        }

        public Builder questionCount(char queryCount) {
            this.queryCount = queryCount;
            return this;
        }

        public Builder answerCount(char answerCount) {
            this.answerCount = answerCount;
            return this;
        }

        public Builder nsCount(char nsCount) {
            this.nsCount = nsCount;
            return this;
        }

        public Builder arCount(char arCount) {
            this.arCount = arCount;
            return this;
        }

        public Header build() {
            return new Header(this.id, this.flags, this.queryCount, this.answerCount, this.nsCount, this.arCount);
        }

    }

}
