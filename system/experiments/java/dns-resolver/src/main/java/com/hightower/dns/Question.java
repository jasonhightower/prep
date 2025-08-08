package com.hightower.dns;

public record Question (String name, char queryType, char queryClass) {

    public static class Builder  {

        private String name;
        private char queryType = Message.TYPE_A;
        private char queryClass = Message.CLASS_INTERNET;

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }
        public Builder setQueryType(final char queryType) {
            this.queryType = queryType;
            return this;
        }
        public Builder setQueryClass(final char queryClass) {
            this.queryClass = queryClass;
            return this;
        }

        public Question build() {
            return new Question(this.name, this.queryType, this.queryClass);
        }

    }

}
