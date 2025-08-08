package com.hightower.dns;

public record Answer(String name,
                     char type,
                     char aclass,
                     long ttl,
                     String data

) {

    public static final class Builder {

        private String name;
        private char type;
        private char aclass;
        private long ttl;
        private String data;

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setType(final char type) {
            this.type = type;
            return this;
        }

        public Builder setAclass(final char aclass) {
            this.aclass = aclass;
            return this;
        }

        public Builder setTtl(final long ttl) {
            this.ttl = ttl;
            return this;
        }

        public Builder setData(final String data) {
            this.data = data;
            return this;
        }

        public Answer build() {
            return new Answer(
                    this.name,
                    this.type,
                    this.aclass,
                    this.ttl,
                    this.data);
        }

    }
}
