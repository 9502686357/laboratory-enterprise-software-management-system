# System Architecture Diagram

## High-Level Architecture

```mermaid
flowchart TB

    USER[Laboratory User]

    FRONTEND[Laboratory Frontend<br/>HTML / CSS / JavaScript<br/>Port 8080]

    INSTRUMENT[Instrument Service<br/>Spring Boot / Java 17<br/>Port 8081]

    EXPERIMENT[Experiment Service<br/>Spring Boot / Java 17<br/>Port 8082]

    DATABASE[(H2 Database)]

    PROCESSING[Instrument Data Processing<br/>Average / Minimum / Maximum]

    DOCKER[Docker Compose<br/>laboratory-network]

    USER --> FRONTEND

    FRONTEND -->|REST API| INSTRUMENT
    FRONTEND -->|REST API| EXPERIMENT

    INSTRUMENT --> DATABASE

    EXPERIMENT --> PROCESSING

    DOCKER -. Containerizes .-> FRONTEND
    DOCKER -. Containerizes .-> INSTRUMENT
    DOCKER -. Containerizes .-> EXPERIMENT
