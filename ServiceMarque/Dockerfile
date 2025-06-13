# Dockerfile for service-marque
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/ServiceMarque-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
