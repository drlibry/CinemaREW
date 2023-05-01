FROM adoptopenjdk/maven-openjdk8
ARG JAR_FILE=target/spring-docker-simple-0.0.1-SNAPSHOT.jar
ARG DATABASE_URL
ARG PGDATABASE
ARG PGHOST
ARG PGPASSWORD
ARG PGUSER
ARG PROJECT_PATH
ADD . /CinemaREW
WORKDIR . /CinemaREW
RUN maven build -x test
ENTRYPOINT ["java","-jar","CinemaREW.jar"]