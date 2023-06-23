FROM maven:3.8.4-jdk-11 AS build
COPY . /app
WORKDIR /app

RUN mvn clean install wildfly:deploy

FROM docker/compose:1.29.2
COPY docker-compose.yml /app
WORKDIR /app

CMD ["docker-compose", "up"]

