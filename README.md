# Introduction to Reactive Microservices using WebFlux

The application code is for a comprehensive introduction to Spring WebFlux, a framework for building highly scalable,
resilient and responsive web applications using reactive programming principles.

## Reactive Web Applications

Spring WebFlux is the new reactive web framework introduced in Spring Framework 5.0. Unlike Spring MVC, it does not
require the servlet API, is fully asynchronous and non-blocking, and implements the Reactive Streams specification
through the Reactor project.

### Learning Achievement

1. Traditional vs Reactive APIs
2. Reactive Data Access R2DBC
3. Building CRUD Operations
4. Error Handling Strategies
5. WebFilter/Interceptor Chaining
6. Functional Programming with WebFlux
7. Building Reactive clients
8. Streaming
9. Optimizing for Performance

### Prerequisite

We will be using external-services.jar to demonstrate other service dependencies in our Microservices architecture.

#### How to run

```bash
cd webflux-playground/external
```

```bash
java -jar external-services.jar
```

- It uses port `7070` by default.
### How different between Traditional Rest Controller and WebFlux Rest Controller

1. **Traditional** : Response arrived all at once, **WebFlux** : Response is gradually arrived one object at a time
![Screenshot 2025-02-19 142018](https://github.com/user-attachments/assets/6a27b0b9-a4c6-40ba-8d77-849e24ede0e3)
2. To be continued

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.2/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.2/maven-plugin/build-image.html)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.4.2/reference/web/reactive.html)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/3.4.2/reference/data/sql.html#data.sql.r2dbc)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Accessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)


