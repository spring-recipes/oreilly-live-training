# Spring Recipes

This repository contains the code for the Spring Recipes live training on the O'Reilly platform. 

## Getting Started 

## Web Applications 

## Databases 

## Spring Cloud

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
- jakarta ee
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

The Gateway example will be a separate service that will proxy requests to a public API.

## Security 

## Testing

## Production 


## Resources

### Repositories

- [Spring Recipes](https://github.com/spring-recipes/oreilly-live-training/tree/main)
- [Gateway]()

### Nate Schutta

- [Website](http://ntschutta.io/)
- [Twitter](https://twitter.com/ntschutta)

### Dan Vega

- [Website](https://www.danvega.dev/)
- [Twitter](https://twitter.com/therealdanvega)