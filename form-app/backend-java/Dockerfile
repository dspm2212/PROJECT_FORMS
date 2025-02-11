FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/backend-java.jar backend-java.jar

EXPOSE 8080

CMD ["java", "-jar", "backend-java.jar"]