# Dockerfile for Eureka Server

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar /app/eureka-server.jar

# Expose the port the app runs on
EXPOSE 8761

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]
