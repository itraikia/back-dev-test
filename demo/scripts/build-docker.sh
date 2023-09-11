#!/bin/bash

# Exit immediately if any command fails
set -e

# Build application
mvn clean package

# Retrieve the version from pom.xml
APP_VERSION_ARG=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
ARTIFACT_NAME_ARG="demo-${APP_VERSION_ARG}.jar"

# Execute the Docker build command with arguments
docker build \
  --build-arg MOCKS_API_URL_ARG=http://172.19.0.3:80 \
  --build-arg ARTIFACT_NAME_ARG="${ARTIFACT_NAME_ARG}" \
  -t api-test-image:"${APP_VERSION_ARG}" .
