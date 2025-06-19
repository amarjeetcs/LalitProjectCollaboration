# 📚 CRUD Application - Spring Boot

This is a simple **Spring Boot-based CRUD application** that demonstrates creating, retrieving, updating, and deleting student records using RESTful APIs.

---

## 📫 API Endpoints Overview

| Method | Endpoint                    | Description             |
|--------|-----------------------------|-------------------------|
| POST   | `/api/students`             | Create new student      |
| GET    | `/api/students`             | Get all students        |
| GET    | `/api/students/pagination`  | Get paginated students  |
| GET    | `/api/students/{id}`        | Get student by ID       |
| PUT    | `/api/students/{id}`        | Update student          |
| DELETE | `/api/students/{id}`        | Delete student          |

---

## ✅ Features Implemented

1. **CRUD Operations**
   - REST endpoints for Create, Read, Update, Delete operations
   - Base URL: `/api/students`

2. **Pagination Support** 🔄
   - Fetch students with pagination using:
     - `GET /api/students/pagination?page=0&size=5`
   - Returns structured response with page number, size, total records, etc.
   - Clean custom DTO used (`PageResponseDTO`) to avoid PageImpl warning

3. **DTO + Validation**
   - Validates inputs using `@Valid` annotations on DTOs
   - Email format, age range, phone number, and required fields are checked

4. **Logging (Log4j2)**
   - Integrated logging to track API calls and responses

5. **ResponseEntity Wrapper**
   - All API responses are properly wrapped with `ResponseEntity` for better status handling

6. **Actuator Monitoring**
   - Monitor application health and metrics
   - Key endpoints:
     - `/actuator/health`
     - `/actuator/info`
     - `/actuator/metrics`

7. **Swagger Integration**
   - API documentation with Swagger UI via SpringDoc
   - Visit: `http://localhost:8080/swagger-ui/index.html`

8. **Lombok**
   - Reduces boilerplate code using annotations like `@Data`, `@Builder`, etc.

9. **DevTools**
   - Auto-restart and hot-reloading during development

10. **SonarQube Integration**
    - Analyzes code quality, bugs, vulnerabilities, code smells

11. **JaCoCo Integration**
    - Measures test coverage and integrates with SonarQube

12. **JUnit 5 Testing**
    - Unit tests using modern JUnit 5 framework

---

## 🔧 Tech Stack & Tools

| Tool/Tech              | Description                           |
|------------------------|---------------------------------------|
| Java 17                | Programming Language                  |
| Spring Boot 3.5.0      | Application Framework                 |
| Spring Data JPA        | ORM & Persistence                     |
| MySQL                  | Relational Database                   |
| Swagger (SpringDoc)    | API Documentation                    |
| Lombok                 | Boilerplate Reduction                 |
| Log4j2                 | Logging Framework                     |
| DevTools               | Auto-reload support                   |
| Actuator               | Application Monitoring                |
| **JUnit 5**            | Testing Framework                     |
| **JaCoCo**             | Code Coverage Tool                    |
| **SonarQube**          | Code Quality Analysis Tool            |

---

## 🔗 Key URLs

- ✅ **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- 🧪 **JaCoCo HTML Report (Local)**: `target/site/jacoco/index.html`
- 📊 **SonarQube Dashboard**: [http://localhost:9000](http://localhost:9000)
  - Project Key: `crud-app`
  - Login Token: `sqp_609b3ed59e63b164ac76a48e013e91235071f2a3` (configure in your Maven command)

---

## 🛠 Author

**Amarjeet Kumar Singh**
