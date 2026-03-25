# Service Template (Spring Boot)

## Overview

This project is a production-ready backend service template built using Spring Boot. It demonstrates clean architecture, request tracing, validation, centralized exception handling, and API documentation using Swagger.

---

## Tech Stack

* Java 17
* Spring Boot 3
* Maven
* SpringDoc OpenAPI (Swagger)

---

## How to Run

```bash
mvn clean install
mvn spring-boot:run
```

Application will start at:
[http://localhost:8080](http://localhost:8080/)

---

## Swagger UI

API documentation is available at:

```
http://localhost:8080/swagger-ui.html
```

OpenAPI JSON:

```
http://localhost:8080/v3/api-docs
```

---

## API Endpoints

### 1. Health Check

**GET /api/v1/health**

Response:

```json
{
  "status": "SUCCESS",
  "requestId": "uuid"
}
```

---

### 2. Example API

**POST /api/v1/example**

Request:

```json
{
  "userId": "123",
  "value": 42
}
```

Success Response:

```json
{
  "status": "SUCCESS",
  "requestId": "uuid"
}
```

Validation Error Response:

```json
{
  "status": "ERROR",
  "requestId": "uuid",
  "errors": {
    "userId": "userId is required"
  }
}
```

Invalid Request Response:

```json
{
  "status": "ERROR",
  "requestId": "uuid",
  "errors": {
    "message": "Invalid request body"
  }
}
```

---

## Key Features

* Layered architecture (Controller → Service → DTO)
* DTO validation using Jakarta Validation
* Centralized exception handling (`@RestControllerAdvice`)
* Structured and consistent API responses
* Request tracing using `requestId` (MDC)
* Detailed request/response logging with execution time
* Swagger API documentation

---

## Design Decisions

* Stateless service (no database dependency)
* Clean separation of concerns
* Consistent response structure across all APIs
* Defensive coding for edge cases (null-safe handling)

---

## Observability

* Unique `requestId` generated per request
* End-to-end request tracing using MDC
* Structured logs for debugging and monitoring

---

## Assumptions

* No database required for current scope
* Service is synchronous and stateless

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
