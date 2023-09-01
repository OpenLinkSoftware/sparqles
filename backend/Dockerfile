FROM maven:3.9.4-eclipse-temurin-8-alpine

COPY . /build
WORKDIR /build

RUN mvn -B clean package appassembler:assemble && chmod +x bin/*

CMD ["./run.sh"]