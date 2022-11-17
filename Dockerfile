FROM openjdk:8-jdk-alpine
ADD target/tpAchatProject-1.0.0-SNAPSHOT.jar tpAchatProject-1.0.0-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.0-SNAPSHOT.jar"]