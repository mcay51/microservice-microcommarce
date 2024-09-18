# Dockerfile for Config Server

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar /app/config-server.jar

# Expose the port the app runs on
EXPOSE 8888

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/config-server.jar"]
