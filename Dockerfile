FROM openjdk:11


COPY build/libs/onlinestore-0.0.1-SNAPSHOT.jar onlinestore-0.0.1-SNAPSHOT.jar

EXPOSE 5558

ENTRYPOINT ["java","-jar","onlinestore-0.0.1-SNAPSHOT.jar"]

