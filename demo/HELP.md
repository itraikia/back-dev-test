# Getting Started

### API Architecture Overview
The API exposed in this repository is a kind of gateway which connect to other API to get data.
The packaging organization you provided aligns well with a common architectural style known as "N-Layer Architecture" 
or "Multi-Layer Architecture." In this style, the application is divided into different horizontal layers, 
each responsible for specific aspects of the application's functionality :

- Configuration Layer:
  - config: This package contains configuration classes for Spring Boot application.

- Presentation Layer:
  - controllers: Controllers handle incoming HTTP requests and define the API endpoints.

- DTOs (Data Transfer Objects):
  - DTOs: Data Transfer Objects (DTOs) are used for transferring data between controllers and services.

- Exception Handling:
  - exceptions: Custom exception classes can be placed in this package.

- Business Logic Layer:
  - services: Business logic and service classes are placed in this package.

### API Feign communication
The choice go directly to Feign rather than restTemplate to communicate with external API for following reasons : 
- Feign allows to create a declarative API client by defining (best organisation and clean code). an interface with annotated methods that correspond to the HTTP endpoints we want to consume
- Possible future integration with service discovery (Eureka), load balancer (spring cloud) and circuit breaker (Hystrix).
- Feign integrates with libraries like Jackson to automatically serialize request objects to JSON and deserialize JSON responses to Java objects 


### API security
We can use an internal auth using simple jwt token provider provider or we can use an auth server for better scalability and decoupled auth 

### Access to API SWAGGER Documentation
The API documentation is accessible on {API_URL}/swagger-ui.html (http://localhost:5000/swagger-ui/index.html)

### API Cache Management
Caching mechanism used here is caffeine, the advantages of using cache are 
- Faster Data Retrieval.
- Reduced Load on Resources (Database).
- Low Latency.

### API Unit and Integration Tests
In the build process the first step is to execute test, if the test fail the build doesn't process

### API Docker flow
- Build application and docker image :
  bash scripts/build-docker.sh

- Run container :
  bash scripts/run-docker.sh


