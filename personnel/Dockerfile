FROM openjdk:8
EXPOSE 8081
ADD /target/personnels-0.0.1-SNAPSHOT.jar docker-service-personnel.jar
ENTRYPOINT ["java", "-jar", "docker-service-personnel.jar"]