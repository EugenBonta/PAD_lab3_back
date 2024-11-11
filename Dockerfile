# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar

# Copy the JAR file into the Docker container
COPY ./target/hrmanager-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]