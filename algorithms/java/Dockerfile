FROM maven:3.8.4-openjdk-11-slim

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

CMD ["mvn", "clean", "package"]
