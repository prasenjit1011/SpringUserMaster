FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# Copy pom.xml and pre-download dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Expose Spring Boot default port
EXPOSE 8080

# Run the built JAR
ENTRYPOINT ["java", "-jar", "target/m_paridarshan-0.0.1-SNAPSHOT.jar"]


# FROM eclipse-temurin:17-jdk
# WORKDIR /app
# COPY . /app
# RUN mvn clean package -DskipTests
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "target/m_paridarshan-0.0.1-SNAPSHOT.jar"]
