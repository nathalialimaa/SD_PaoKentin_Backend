FROM openjdk:17-jdk-alpine
COPY target/paokentin-1.0.0.jar paokentin-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/paokentin-1.0.0.jar"]