# Use a Maven image to build the application
FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /target

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean install

FROM openjdk:17-jdk-slim

WORKDIR /target

COPY ./target/hrmanager-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
