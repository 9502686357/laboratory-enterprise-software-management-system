# Technical Specifications

## 1. Project Overview

The Laboratory & Enterprise Software Management System is a Java-based microservices application designed to manage laboratory instruments, experiments, and instrument measurement data.

The system follows a modular microservice architecture where individual services are responsible for specific laboratory management functions.

---

## 2. Technology Stack

| Layer | Technology |
|---|---|
| Backend | Java 17 |
| Framework | Spring Boot |
| Architecture | Microservices |
| API | RESTful APIs |
| Database | H2 Database |
| Persistence | Spring Data JPA |
| Frontend | HTML, CSS, JavaScript |
| Web Server | Nginx |
| Testing | JUnit, Mockito, MockMvc |
| Containerization | Docker |
| Orchestration | Docker Compose |
| Cloud Readiness | AWS-compatible architecture |

---

## 3. Instrument Service

### Purpose

The Instrument Service manages laboratory instrument information.

### Port

```text
8081
