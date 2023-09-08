# Use the official gradle image as the base image
FROM gradle:jdk17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the build.gradle and settings.gradle files to the container
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Copy the source code to the container
COPY app src

# Build the project using Gradle
RUN gradle build --no-daemon

# Use the official OpenJDK 17 image as the base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the builder stage to the container
COPY --from=builder /app/build/libs/app.jar .

# Specify the command to run your Java application
CMD ["java", "-jar", "app.jar"]