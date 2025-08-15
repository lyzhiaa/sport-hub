FROM openjdk:21-jdk
WORKDIR /app
COPY build/libs/istad_sport-0.0.1-SNAPSHOT.jar /app/istad_sport-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/istad_sport-0.0.1-SNAPSHOT.jar"]