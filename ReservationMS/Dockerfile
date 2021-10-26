FROM adoptopenjdk/openjdk11:latest
EXPOSE 8780
#param1 nom src /  parm2 nom dans docker
ADD /target/ReservationMS-0.0.1-SNAPSHOT.jar ReservationMS-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ReservationMS-0.0.1-SNAPSHOT.jar"] 