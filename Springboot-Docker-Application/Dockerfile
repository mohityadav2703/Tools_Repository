FROM openjdk:17

MAINTAINER Mohit Kumar

COPY target/Springboot-Docker-Application-0.0.1-SNAPSHOT.jar  /usr/app/

WORKDIR /usr/app/

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "Springboot-Docker-Application-0.0.1-SNAPSHOT.jar"]