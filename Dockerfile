FROM node:15.6-alpine AS ui-builder
WORKDIR /ui
COPY ui/ .
RUN npm install
RUN npm run build --prod

FROM gradle:jdk11 AS builder
WORKDIR /app
COPY server/ .
COPY --from=ui-builder /ui/dist/random-sims-names/. /app/src/main/resources/static/.
RUN gradle build

FROM openjdk:11-jre-slim
ARG version=0.0.1
EXPOSE 8080
COPY --from=builder /app/build/libs/random-sims-name-${version}.jar /app/random-sims-name.jar
ENTRYPOINT ["java", "-jar", "/app/random-sims-name.jar"]