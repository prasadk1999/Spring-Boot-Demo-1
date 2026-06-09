# Spring Boot Demo Application

A simple Spring Boot REST API showcasing database integration with PostgreSQL, Spring Data JPA, and Lombok.

## Tech Stack
* **Java:** version 25 (Amazon Corretto)
* **Framework:** Spring Boot 4.0.6
* **ORM / Database Access:** Spring Data JPA / Hibernate
* **Database:** PostgreSQL (Docker containerized)
* **Boilerplate Reduction:** Project Lombok (version 1.18.44)

---

## Configuration & Setup

### 1. Run the PostgreSQL Database (Docker)
Ensure you have a PostgreSQL container running on port `5433` (as configured in `application.yml`):
```bash
docker run --name postgres-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -p 5433:5432 -d postgres
```

#### Timezone Workaround for Docker Containers
Because Windows hosts may pass the legacy timezone `Asia/Calcutta` to the PostgreSQL driver, modern Linux container distributions (like Debian/Alpine) might reject the connection. 

If you encounter `FATAL: invalid value for parameter "TimeZone": "Asia/Calcutta"`, run the following command to link `Asia/Calcutta` to the supported `Asia/Kolkata` timezone configuration inside your running Docker container:
```bash
docker exec -u root postgres-db ln -s Kolkata /usr/share/zoneinfo/Asia/Calcutta
```

### 2. Properties Configuration
The database connection settings are located in [src/main/resources/application.yml](src/main/resources/application.yml):
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/postgres
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
  application:
    name: demo
```

---

## Build & Run Instructions

To compile the application and resolve dependency annotations:
```bash
mvn clean compile
```

To run the application:
```bash
mvn spring-boot:run
```

---

## Endpoints

* **`GET /`** - Health check returning a simple greeting.
* **`GET /users`** - Fetches the list of all registered users in JSON format.
