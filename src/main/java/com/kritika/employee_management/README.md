# Employee Management REST API

A production-ready RESTful API built with Spring Boot for managing employee records.

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- Lombok
- Swagger UI (OpenAPI 3)
- Maven

## 🏗️ Architecture
Follows a clean layered architecture:
- **Controller Layer** — Handles HTTP requests/responses
- **Service Layer** — Business logic
- **Repository Layer** — Database operations

## ✨ Features
- CRUD operations for Employee management
- Input validation (`@Email`, `@NotBlank`, `@Min`)
- Global Exception Handling with proper error responses
- Audit fields (`createdAt`, `updatedAt`) auto-managed
- API documentation via Swagger UI

## 📋 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get employee by ID |
| POST | /api/employees | Create new employee |
| PUT | /api/employees/{id} | Update employee |
| DELETE | /api/employees/{id} | Delete employee |

## 🚀 Running Locally

```bash
# Clone the repo
git clone https://github.com/shankar-kritika/Employee-Management.git

# Configure MySQL in application.properties

# Run the app
./mvnw spring-boot:run
```

## 📖 API Documentation
Once running, visit: `http://localhost:8080/swagger-ui/index.html`