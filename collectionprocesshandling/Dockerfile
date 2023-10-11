FROM openjdk:17

LABEL maintainers="saisri"

ADD target/collectionprocesshandling-0.0.1-SNAPSHOT.jar capstone.jar

ENTRYPOINT ["java","-jar","capstone.jar"]