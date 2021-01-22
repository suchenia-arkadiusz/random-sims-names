FROM openjdk:11-jre-slim
EXPOSE 8080
RUN mkdir /app
COPY build/libs/random-sims-name-0.0.1.jar /app/random-sims-name.jar
ENTRYPOINT ["java", "-jar", "/app/random-sims-name.jar"]