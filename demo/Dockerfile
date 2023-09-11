# Fetching latest version of Java
FROM openjdk:17

ARG MOCKS_API_URL_ARG
ENV MOCKS_API_URL $MOCKS_API_URL_ARG

ARG ARTIFACT_NAME_ARG
ENV ARTIFACT_NAME $ARTIFACT_NAME_ARG

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/*.jar /app

# Exposing port 8080
EXPOSE 5000

CMD echo "Printing the value of the VARIABLE : $ARTIFACT_NAME"

# Starting the application
CMD java -jar $ARTIFACT_NAME
