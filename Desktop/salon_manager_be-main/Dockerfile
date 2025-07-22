# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

# Copy source code
COPY src ./src

# Make mvnw executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Create runtime image
FROM eclipse-temurin:17-jre-jammy

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY --from=0 /app/target/salon-manager-be-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 9090

# Set environment variables
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"] 