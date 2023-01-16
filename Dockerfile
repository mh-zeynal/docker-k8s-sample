FROM openjdk:17-alpine

WORKDIR /app
COPY target/sample-0.0.1-SNAPSHOT.jar /app/sample-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/sample-0.0.1-SNAPSHOT.jar"]