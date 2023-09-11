#!/bin/bash

# Exit immediately if any command fails
set -e

APP_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
CONTAINER_NAME=api-test-${APP_VERSION}
CONTAINER_IMAGE=api-test-image:"${APP_VERSION}"

docker run --name "${CONTAINER_NAME}" --network=backenddevtest_default -p 5000:5000 -d "${CONTAINER_IMAGE}"