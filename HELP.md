# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/#build-image)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#features.nosql.mongodb.connecting)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#production-ready)
* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
### Guides
The following guides illustrate how to use some features concretely:
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Provide infrastructure
To execute mongodb local and follow the build steps, just run docker with :
> sudo docker-compose --verbose up -d

After that, it's important build a project and then, run it:

>./gradlew build

>./gradlew bootRun

## Business Logic - implementation

A small cinema, which only plays movies from the Fast & Furious franchise, is looking to develop a mobile/web app for their users. Specifically, they wish to support the following functions:

    MovieController. -> 
        An internal endpoint in which they (i.e. the cinema owners) can update show times and prices for their movie catalog

    MovieController.findSessions -> 
        An endpoint in which their customers (i.e. moviegoers) can fetch movie times

    functions httpRequest ->
        An endpoint in which their customers (i.e. moviegoers) can fetch details about one of their movies (e.g. name, description, release date, rating, IMDb rating, and runtime). Even though there's a limited offering, please use the OMDb APIs (detailed below) to demonstrate how to communicate across APIs.

    MovieController. -> 
        An endpoint in which their customers (i.e. moviegoers) can leave a review rating (from 1-5 stars) about a particular movie
    
    And adding anything else that you think will be useful for the user...

    MovieRepository: MongoRepository -> 
        Creating a persistence layer to save results for certain actions (e.g. via SQL/NoSQL/etc)
    
    MovieController @Operation
    Present API documentation leveraging OpenAPI/Swagger 2.0 standard
