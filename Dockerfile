# Build stage
FROM maven:3.8.7-openjdk-17 AS build  # Updated to a valid Maven version

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .

# Download dependencies to improve caching
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application using Maven
RUN mvn clean install -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim

# Set the working directory inside the runtime container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (default Spring Boot port is 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
