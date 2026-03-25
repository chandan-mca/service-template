# Service Template (Spring Boot)

## Overview

This project is a production-ready starter template for building backend services using Spring Boot. It demonstrates clean architecture, validation, logging, and centralized exception handling.

---

## Tech Stack

* Java 17
* Spring Boot 3
* Maven

---

## How to Run

```bash
mvn clean install
mvn spring-boot:run
```

Application will start at:
[http://localhost:8080](http://localhost:8080/)

---

## API Endpoints

### 1. Health Check

GET /health

Response:

```json
{
  "status": "UP"
}
```

---

### 2. Example API

POST /example

Request:

```json
{
  "userId": "123",
  "value": 42
}
```

Response:

```json
{
  "status": "SUCCESS",
  "requestId": "uuid"
}
```

---

## Design Decisions

* Layered architecture (Controller → Service → DTO)
* DTO-based validation using annotations
* Centralized exception handling using `@RestControllerAdvice`
* Logging added for request tracing
* Stateless design (no database used)

---

## Assumptions

* No database required for current scope
* Service is stateless
* Simple synchronous processing

---

## Future Improvements

* Add database (MySQL/PostgreSQL)
* Add authentication (JWT)
* Add caching (Redis)
* Add rate limiting
* Add Docker support
* Add monitoring (Prometheus, Grafana)

---

## Project Structure

```
controller/
service/
dto/
exception/
config/
```
