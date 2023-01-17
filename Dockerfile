FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/rpg-character-0.0.1-SNAPSHOT.jar /app/rpg-character.jar
ENTRYPOINT ["java","-jar","/app/rpg-character.jar"]
EXPOSE 8080