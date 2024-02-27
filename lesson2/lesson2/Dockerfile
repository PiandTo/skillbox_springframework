FROM --platform=linux/amd64 openjdk:17-jdk-alpine
WORKDIR /app
COPY target/*.jar shell.jar
ENTRYPOINT ["java", "-jar", "shell.jar"]
