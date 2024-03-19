# Spring Recipes

This repository contains the code for the Spring Recipes live training on the O'Reilly platform.

## Getting Started

- Spring Initializr
- Code Structure
  - Avoid default package
  - Main application class should live in the same package as the rest of your code
  - Use packages to organize your code
    - package by layer 
    - package by feature
  - Dependency Injection
  - Logging
  - DevTools

## Web Applications

- Building a REST API
- Validating Data
- HTTP Clients

## Databases

- Connecting to an H2 database
- What about a real database? 
  - Docker Compose Module
  - How to view the database?
- Database Abstractions 
  - `JdbcTemplate`
  - `JdbcClient`
  - Spring Data

## Spring Cloud

- Actuator
- Observability
- Gateway

### Actuator

- Create a new project at start.spring.io using Actuator and Web as dependencies.
  - Explore the pom.xml
- Add Actuator to an existing project
  - Start the application
    - What endpoints are available (not many)
    - Add properties
    - https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator
  - Show Info Endpoint
    - Add custom info
    - Enable custom info endpoints
  - Add REST controller show mappings and beans endpoints
  - Tour of Endpoints
  - Create your own endpoint
    - Random Endpoint
  - Security
    - https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints.security
  - Kubernetes Probes
    - https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints.kubernetes-probes

### Observability

Observability was one of the major themes in Spring Framework 6 + Spring Boot 3

- Java 17
- Jakarta EE
- Observability
- Spring Native (AOT)

What is observability? In our understanding, it is "how well you can understand the internals of your system by examining its outputs". We believe that the interconnection between metrics, logging, and distributed tracing gives you the ability to reason about the state of your system in order to debug exceptions and latency in your applications.

Spring Boot 3 adds numerous autoconfigurations for improved metrics with Micrometer and new distributed tracing support with Micrometer Tracing (formerly Spring Cloud Sleuth). We have been changing the Micrometer API a lot over the course of this year. The most important change is that we have introduced a new API: the Observation API.
The idea of its founding was that we want the users to instrument their code once using a single API and have multiple benefits out of it (e.g. metrics, tracing, logging).

Distributed Architecture comes with its challenges:
A single user request can travel through hundreds or thousands of microservices. So to quickly identify where things are going wrong, you need a central overview of how requests are performing across services.

Documentation
- [Micrometer](https://micrometer.io/)
- [Spring Boot Observability](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.observability)
- [Observability with Spring Boot 3](https://spring.io/blog/2022/10/12/observability-with-spring-boot-3)
- [Docker Compose Example](https://github.com/marcingrzejszczak/observability-boot-blog-post )

Observability
- Log Aggregation (Loki / Logstash)
- Distributed Tracing (Zipkin / Jaeger)
- Time Series Metrics (Prometheus)
- Data Query, Visualization, Alerting (Grafana)

Demo Steps

- Revisit the Actuator endpoints
  - /metrics endpoint
  - What is being collected by default (http requests, jvm, etc.)
- Observation API
  - EventController (Observation.createNotStarted)
  - findAll
  - findAllWithDelay
  - findById - add tag
- `@Observed` Annotation
  - Add AOP spring boot starter dependency
  - ObservationConfig
  - EventController
    - Replace findAll with annotation to demonstrate different ways to use the API
  - Prometheus
    - Add Prometheus dependency (micrometer-registry-prometheus)
    - Docker Compose
      - service
      - (prometheus.yml)
    - View Prometheus actuator endpoint
    - localhost:9090
  - Grafana
    - Docker Compose
    - Login to Grafana and create a dashboard
  - Zipkin

### Gateway

The Gateway service is in its own [repository](https://github.com/spring-recipes/gateway-service) to simplify the demo.

## Security

The Security example is in its own [repository](https://github.com/spring-recipes/secure) to simplify the demo.

## Production

- Configuration
  - Property Sources
  - @Value annotation
  - @ConfigurationProperties
  - Profiles
- Packaging Options
  - Building an Executable JAR
  - Building a Container Image
  - Building a Native Image
    - Use Cases for Native Images (show off CLI if we have time)
- Spring Boot 3.2 (Virtual Threads)
- Deploying your application to...

### Hosts

Here are a few services that you can deploy your Spring Boot Applications on:

- [Amazon Web Services (AWS)](https://aws.amazon.com/)
- [Azure Spring Apps](https://azure.microsoft.com/en-us/products/spring-apps)
- [Google Cloud](https://cloud.google.com/)
- [OpenShift](https://www.redhat.com/en/technologies/cloud-computing/openshift)
- [Cloud Foundry](https://www.cloudfoundry.org/)
- [Digital Ocean](https://www.digitalocean.com/)
- [Railway](https://railway.app/)
- [Heroku](https://www.heroku.com/)
- [Render](https://render.com/)
- [Fly.io](https://fly.io/)
- [Porter](https://porter.run/)

## Getting to Production with Spring Boot

Here are a few videos from Spring Office Hours and Dan's YouTube channel on moving your Spring Boot applications into production.

- [Spring Office Hours: Spring to Production Part 1](https://tanzu.vmware.com/developer/tv/spring-office-hours/0015/)
- [Spring Office Hours: Spring to Production Part 2](https://tanzu.vmware.com/developer/tv/spring-office-hours/0016/)
- [Spring Boot Azure](https://youtu.be/53T_R3xAPTg)
- [Spring Boot Heroku](https://youtu.be/lGtTOLKuvqs)
- [Spring BOot Railway](https://youtu.be/5sVxvF47dcU)

## Resources

- [Spring Office Hours](https://springofficehours.io)
- [Resources for Learning Spring](https://github.com/spring-office-hours/resources-learning-spring)
- [Fundamentals of Software Engineering](https://learning.oreilly.com/library/view/fundamentals-of-software/9781098143220/)

### Nate Schutta

- [Website](http://ntschutta.io/)
- [Twitter](https://twitter.com/ntschutta)

### Dan Vega

- [Website](https://www.danvega.dev/)
- [YouTube](https://www.youtube.com/@danvega)
- [Twitter](https://twitter.com/therealdanvega)
