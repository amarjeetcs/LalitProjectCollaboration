# 📚 CRUD Application - Spring Boot

This is a simple **Spring Boot-based CRUD application** that demonstrates creating, retrieving, updating, and deleting student records using RESTful APIs.

---

## 📫 API Endpoints Overview

### 🔹 Non-Versioned API (`/api/students`)

| Method | Endpoint                             | Description                      |
|--------|--------------------------------------|----------------------------------|
| POST   | `/api/students/addData`              | Add a single student             |
| POST   | `/api/students/addAll`               | Add multiple students            |
| GET    | `/api/students`                      | Get all students                 |
| GET    | `/api/students/pagination`           | Get paginated students           |
| GET    | `/api/students/{id}`                 | Get student by ID                |
| PUT    | `/api/students/{id}`                 | Update student                   |
| DELETE | `/api/students/{id}`                 | Delete student                   |
| GET    | `/api/students/external/{id}`        | Fetch student from external API  |

### 🔹 Versioned API - V1 (`/api/v1/students`)

| Method | Endpoint                 | Description               |
|--------|--------------------------|---------------------------|
| GET    | `/api/v1/students`       | Get all students (v1)     |
| GET    | `/api/v1/students/{id}`  | Get student by ID (v1)    |
| POST   | `/api/v1/students`       | Add student (v1)          |

### 🔹 Versioned API - V2 (`/api/v2/students`)

| Method | Endpoint                               | Description                        |
|--------|----------------------------------------|------------------------------------|
| GET    | `/api/v2/students`                    | Get all students (v2)              |
| GET    | `/api/v2/students/pagination`         | Get paginated students (v2)        |
| GET    | `/api/v2/students/{id}`               | Get student by ID (v2)             |
| POST   | `/api/v2/students`                    | Add student (v2)                   |
| POST   | `/api/v2/students/batch`              | Add multiple students (v2)         |
| PUT    | `/api/v2/students/{id}`               | Update student (v2)                |
| DELETE | `/api/v2/students/{id}`               | Delete student (v2)                |

---

## ✅ Features Implemented

1. **CRUD Operations**
   - Full Create, Read, Update, Delete functionality

2. **Pagination Support** 🔄
   - Example: `GET /api/students/pagination?page=0&size=5`

3. **DTO + Validation**
   - Validates email, age, phone number, etc. using `@Valid`

4. **Logging (Log4j2)**
   - Logs input/output, errors, flow

5. **ResponseEntity Wrapper**
   - All APIs use proper HTTP status codes

6. **Actuator Monitoring**
   - Health and metrics endpoints exposed

7. **Swagger Integration**
   - API documentation via Swagger UI

8. **Lombok**
   - Annotations like `@Data`, `@Builder`, etc.

9. **DevTools**
   - For hot reload during development

10. **SonarQube Integration**
    - Static code analysis and maintainability

11. **JaCoCo Integration**
    - Code coverage reports

12. **JUnit 5 Testing**
    - Unit and integration testing

13. **Global Exception Handling** ⚠️
    - Centralized error messages using `@ControllerAdvice`
    - Handles:
      - `DuplicateFieldException`
      - `EntityNotFoundException`
      - Validation errors

14. **API Versioning** 🗂️
    - Separate controllers for `/v1` and `/v2`
    - Ensures backward compatibility

15. **RestTemplate Integration** 🌐
    - Consumes internal/external REST APIs

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
| JUnit 5                | Testing Framework                     |
| JaCoCo                 | Code Coverage Tool                    |
| SonarQube              | Code Quality Analysis Tool            |
| RestTemplate           | Internal REST API Communication       |

---

## 🔗 Key URLs

- ✅ **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- 🧪 **JaCoCo Report**: `target/site/jacoco/index.html`
- 📊 **SonarQube Dashboard**: [http://localhost:9000](http://localhost:9000)
  - Project Key: `crud-app`
  - Token: `sqp_609b3ed59e63b164ac76a48e013e91235071f2a3`

---

## 🛠 Author

**Amarjeet Kumar Singh**
