# Laboratory & Enterprise Software Management System

A cloud-ready laboratory management application built using Java,
Spring Boot microservices, REST APIs, Docker, automated testing,
and a JavaScript frontend.

## Project Overview

This project demonstrates a microservices-based laboratory software
system for managing laboratory instruments and experiments.

The system contains:

- Instrument Management Microservice
- Experiment Management Microservice
- Laboratory Data Processing Service
- JavaScript Frontend
- Docker containerization
- Docker Compose orchestration
- RESTful APIs
- Automated testing

## Technology Stack

### Backend

- Java 17
- Spring Boot
- Spring Data JPA
- REST APIs
- Maven
- H2 Database

### Testing

- JUnit 5
- Mockito
- Spring MockMvc

### Frontend

- HTML5
- CSS3
- JavaScript

### DevOps

- Docker
- Docker Compose
- Nginx

## Project Structure

```text
laboratory-enterprise-software-management-system/
│
├── instrument-service/
│   ├── Dockerfile
│   ├── .dockerignore
│   ├── pom.xml
│   └── src/
│
├── experiment-service/
│   ├── Dockerfile
│   ├── .dockerignore
│   ├── pom.xml
│   └── src/
│
├── frontend/
│   ├── Dockerfile
│   ├── .dockerignore
│   ├── index.html
│   ├── app.js
│   └── style.css
│
├── docker-compose.yml
└── README.md
