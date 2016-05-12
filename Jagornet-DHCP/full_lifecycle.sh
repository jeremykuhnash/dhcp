#!/bin/bash 
# Author: Jeremy Kuhnash https://github.com/jeremykuhnash 
# 
# This script assumes java, maven and docker are working in the local env and things are building. 

IMAGE_NAME="jdhcp"
# The below is from the pom... could probably be parameterized centrally. One day...
CONTAINER_NAME="jagornet/jdhcp"   
HOST_PORT="48080"
CONTAINER_PORT="48080"

# 1 and 1b) Build
mvn clean 
mvn install 

echo "Finding Docker information ..."
# 2) Find the existing container and image
RUNNING_CONTAINER_ID=`docker ps -f name=${IMAGE_NAME}  |cut -d ' ' -f 1 |grep -v "CONTAINER"`
if [ ! -z "${RUNNING_CONTAINER_ID}" ]; then
	echo "*********** Found ${RUNNING_CONTAINER_ID} - stopping."
	docker stop ${RUNNING_CONTAINER_ID}
fi

CONTAINER_ID=`docker ps -a -f name=${IMAGE_NAME} |cut -d ' ' -f 1 |grep -v "CONTAINER" `
if [ ! -z "$CONTAINER_ID" ]; then
	echo "****** Found ${CONTAINER_ID} - removing."
	docker rm $CONTAINER_ID
fi

echo "maven package.."
mvn package
echo "Docker build.."
mvn docker\:build

# 3) Start new container from image, this just matches the settings in
#    application.properties for convenience
docker run -p ${HOST_PORT}:${CONTAINER_PORT} --name ${IMAGE_NAME} ${CONTAINER_NAME}

