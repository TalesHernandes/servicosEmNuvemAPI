FROM openjdk:22
ARG JAR_FILE=target/*.jar
COPY ./target/backEnd-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]