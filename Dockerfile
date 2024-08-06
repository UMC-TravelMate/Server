FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} travelmate.jar
ENTRYPOINT ["java","-jar","/travelmate.jar"]
