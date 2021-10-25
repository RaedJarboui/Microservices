FROM openjdk:8
EXPOSE 8761
ADD /target/eureka-discovery-server-0.0.1-SNAPSHOT.jar docker-service-eureka.jar
ENTRYPOINT ["java", "-jar", "docker-service-eureka.jar"]