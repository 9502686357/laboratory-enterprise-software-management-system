# System Architecture

## 1. Architecture Overview

The Laboratory & Enterprise Software Management System follows a
modular microservices architecture.

The system consists of:

- Laboratory Frontend
- Instrument Management Microservice
- Experiment Management Microservice
- Laboratory Instrument Data Processing
- H2 Database
- Docker containers
- Docker Compose networking

The architecture separates laboratory instrument management from
experiment management so that each service can be developed and
maintained independently.

## 2. High-Level Architecture

```text
                         Laboratory User
                                |
                                v
                     +---------------------+
                     |   Web Frontend      |
                     | HTML / CSS / JS     |
                     |     Port 8080       |
                     +----------+----------+
                                |
                  +-------------+-------------+
                  |                           |
                  v                           v
       +---------------------+     +---------------------+
       | Instrument Service  |     | Experiment Service  |
       |   Spring Boot       |     |   Spring Boot       |
       |     Port 8081       |     |     Port 8082       |
       +----------+----------+     +----------+----------+
                  |                           |
                  v                           v
       +---------------------+     +---------------------+
       |    H2 Database      |     | Experiment Processing|
       | Instrument Records  |     |   Service Logic      |
       +---------------------+     +---------------------+
