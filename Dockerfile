# File: Dockerfile
FROM openjdk:19


COPY target/Assignment-Optimize-HTTP-Server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "Assignment-Optimize-HTTP-Server-0.0.1-SNAPSHOT.jar"]