#!/bin/sh

# export SPRING_DATASOURCE_URL='jdbc:postgresql://localhost:5432/postgres'
# export SPRING_DATASOURCE_PASSWORD='postgres'
# export SPRING_DATASOURCE_USERNAME='postgres'
# echo $SPRING_DATASOURCE_USERNAME
# echo $SPRING_DATASOURCE_URL

# docker compose up
# docker build -t ooleon/vivo-test-backend:1 .
# docker container create --name vivo-test-backend --net mireddocker -it -p 8080:8080 ooleon/vivo-test-backend:1
# docker rm vivo-test-backend
# docker image rm ooleon/vivo-test-backend:1
docker build -t ooleon/vivo-test-backend:1 .
docker container create --name vivo-test-backend --net mireddocker -it -p 8080:8080 ooleon/vivo-test-backend:1
docker compose -f docker-compose.dev.yml up

#./gradlew nativeCompile

