FROM adoptopenjdk/openjdk11:latest
EXPOSE 8761
#param1 nom src /  parm2 nom dans docker
ADD /target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","EurekaServer-0.0.1-SNAPSHOT.jar"] 