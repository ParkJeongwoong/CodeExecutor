FROM openjdk:17

VOLUME /logs
VOLUME /tmp

ARG JAR_FILE=./build/libs/*.jar
ENV IDLE_PROFILE dev

COPY ${JAR_FILE} spring.jar
COPY ./src/main/resources/application.properties /application.properties
COPY ./src/main/resources/application-db.properties /application-db.properties
COPY ./src/main/resources/application-dev.properties /application-dev.properties

# 실행 명령

ENTRYPOINT ["nohup", "java","-jar",\
"-Dspring.config.location=/application.properties,/application-db.properties,/application-${IDLE_PROFILE}.properties",\
"-Dspring.profiles.active=${IDLE_PROFILE}",\
"spring.jar", "2>&1", "&"]