# Dockerfile for config-server
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/Discovery-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
