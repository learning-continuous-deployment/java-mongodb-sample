# Image
# FROM ubuntu:latest
FROM maven:3.2-jdk-7-onbuild
CMD ["mvn compile"]

# File Author / Maintainer
MAINTAINER Maintaner Name

# Installation:
# Import MongoDB public GPG key AND create a MongoDB list file
RUN apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv 7F0CEB10
RUN echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' | tee /etc/apt/sources.list.d/10gen.list

# Update apt-get sources AND install MongoDB
RUN apt-get update && apt-get install -y mongodb-org

# Create the MongoDB data directory
RUN mkdir -p /data/db

# Expose port 27017 from the container to the host
EXPOSE 27017

# Set usr/bin/mongod as the dockerized entry-point application
ENTRYPOINT usr/bin/mongod



#For Java project only use: 
#FROM java:7
#COPY . /usr/java-mongodb-sample/src/csm
#WORKDIR /usr/java-mongodb-sample/src/csm
#RUN javac Main.java
#CMD ["java", "Main"] 