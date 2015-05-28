# FROM ubuntu:latest
FROM library/java:openjdk-8-jre

# File Author / Maintainer
MAINTAINER Maintaner Name

ADD ./target/JavaMongoDbApp-0.0.1-SNAPSHOT-jar-with-dependencies.jar /home/code/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/code/JavaMongoDbApp-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]


