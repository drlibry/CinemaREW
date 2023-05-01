FROM adoptopenjdk/maven-openjdk8
ARG DATABASE_URL
ARG PGDATABASE
ARG PGHOST
ARG PGPASSWORD
ARG PGUSER
ARG PROJECT_PATH
ADD . /CinemaREW
WORKDIR . /CinemaREW
ENTRYPOINT ["java","-jar"]