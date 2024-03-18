# Don't have docker installed on dev box, so following config haven't been tested.
FROM openjdk:17-oracle
EXPOSE 8080
ADD target/photographer-0.0.1-SNAPSHOT.jar photographer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/photographer-0.0.1-SNAPSHOT.jar"]

