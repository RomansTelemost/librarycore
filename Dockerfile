FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar librarycore-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/app/librarycore-0.0.1.jar"]