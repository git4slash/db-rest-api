FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ARG BUILD_VERSION
COPY ${JAR_FILE} db-api.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/db-api.jar"]