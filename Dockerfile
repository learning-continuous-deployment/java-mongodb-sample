#Image
FROM maven:3.2-jdk-7-onbuild
CMD ["mvn compile"]


#For Java project only use: 
#FROM java:7
#COPY . /usr/java-mongodb-sample/src/csm
#WORKDIR /usr/java-mongodb-sample/src/csm
#RUN javac Main.java
#CMD ["java", "Main"] 