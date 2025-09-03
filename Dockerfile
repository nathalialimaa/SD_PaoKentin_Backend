# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: runtime
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/paokentin-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
