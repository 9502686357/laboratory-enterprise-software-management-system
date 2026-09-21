# Use Java 17 runtime
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .

# Copy source code
COPY src ./src

# Install Maven and build the application
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package -DskipTests

# Expose Experiment Service port
EXPOSE 8082

# Start the Spring Boot application
CMD ["java", "-jar", "target/experiment-service-1.0.0.jar"]
