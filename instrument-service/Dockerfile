# Use Java 17 runtime
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .

# Copy source code
COPY src ./src

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package -DskipTests

# Expose Instrument Service port
EXPOSE 8081

# Start the Spring Boot application
CMD ["java", "-jar", "target/instrument-service-1.0.0.jar"]
