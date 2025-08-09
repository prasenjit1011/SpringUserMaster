# # Use Maven with JDK 17 for build stage
# FROM maven:3.9-eclipse-temurin-17 AS builder

# WORKDIR /app

# # 1️⃣ Copy only pom.xml first to cache dependencies
# COPY pom.xml .
# RUN mvn -B dependency:resolve dependency:resolve-plugins

# # 2️⃣ Copy source files
# COPY src ./src

# # 3️⃣ Build without running tests
# RUN mvn clean package -DskipTests

# # --------------------
# # Runtime image
# # --------------------
# FROM eclipse-temurin:17-jdk

# WORKDIR /app

# # 4️⃣ Copy JAR from build stage
# COPY --from=builder /app/target/m_paridarshan-0.0.1-SNAPSHOT.jar app.jar

# # 5️⃣ Expose application port
# EXPOSE 8080

# # 6️⃣ Run the app
# ENTRYPOINT ["java", "-jar", "app.jar"]


###################################################################################





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


###################################################################################




# FROM eclipse-temurin:17-jdk
# WORKDIR /app
# COPY . /app
# RUN mvn clean package -DskipTests
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "target/m_paridarshan-0.0.1-SNAPSHOT.jar"]
