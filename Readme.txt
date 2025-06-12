# CRUD Application - Spring Boot

This is a simple **Spring Boot-based CRUD application** that demonstrates the creation, retrieval, update, and deletion of student records using RESTful APIs.

## ✅ Features Implemented:

1. **CRUD Operations**
   - Create, Read, Update, Delete student entities.
   - API endpoints exposed under `/api/students`.

2. **DTO + Validation API**
   - Used `@Valid` annotations with DTOs to validate inputs such as:
     - Email format
     - Age constraints
     - Phone number format
     - Required fields

3. **Logging**
   - Integrated Log4j2 for logging API requests and internal processing.
   - Logs request status and debugging information.

4. **ResponseEntity**
   - All responses wrapped using `ResponseEntity` for better HTTP status control and response handling.

5. **Actuator**
   - Enabled Spring Boot Actuator to monitor application health and metrics.
   - Accessible at:
     - `/actuator/health`
     - `/actuator/info`
     - `/actuator/metrics`

6. **Lombok**
   - Used Lombok annotations such as `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` to reduce boilerplate code for entity and DTO classes.

7. **DevTools**
   - Spring Boot DevTools added for automatic reload and better development experience.

8. **Swagger (SpringDoc OpenAPI)**
   - Integrated Swagger UI for API documentation and testing.
   - Accessible at: `http://localhost:8080/swagger-ui.html` or `/swagger-ui/index.html`

## 🔧 Tools & Technologies:

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- MySQL Database
- Maven
- Swagger UI (springdoc-openapi)
- Lombok
- Spring Boot Actuator
- Log4j2
- Spring Boot DevTools

## 📁 Directory Structure (Major)