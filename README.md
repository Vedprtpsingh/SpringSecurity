# Spring Security Example Projects

This repository contains two example Spring Boot projects demonstrating different approaches to implementing security in web applications using Spring Security.

---

## Projects Overview

### 1. springsecurityexample

This project demonstrates a Spring Boot application secured using JWT (JSON Web Token) based authentication. It features stateless session management and custom JWT filters to secure REST endpoints.

**Key Features:**
- JWT-based authentication and authorization
- Stateless session management
- BCrypt password encoding for user credentials
- Endpoints:
  - `/` : Returns a welcome message with the session ID
  - `/register` and `/login` : Publicly accessible endpoints for user registration and login (configured in security)
- Security configuration includes disabling CSRF, permitting `/register` and `/login` without authentication, and adding a JWT filter.

---

### 2. websecurityexample

This project demonstrates another Spring Boot application with basic employee management functionality secured using HTTP Basic and form login authentication.

**Key Features:**
- Employee management endpoints:
  - `/home` : Returns a welcome string
  - `/employee` : Returns a list of employees
  - `/add` : Adds a new employee (POST)
  - `/csrf` : Returns the CSRF token
- Security configuration includes permitting `/home` and `/signup` without authentication, HTTP Basic and form login enabled, and CSRF protection disabled.
- Uses a custom `UserDetailsService` implementation for user authentication.
- BCrypt password encoding for user credentials.

---

## Running the Projects

Both projects are standard Spring Boot applications and can be run using Maven or your preferred IDE.

### Running springsecurityexample

```bash
cd springsecurityexample
./mvnw spring-boot:run
```

The application will start on the default port (usually 8080). You can access the endpoints such as `http://localhost:8080/`.

### Running websecurityexample

```bash
cd websecurityexample
./mvnw spring-boot:run
```

The application will start on the default port (usually 8080). You can access the endpoints such as `http://localhost:8080/home`.

---

## Notes

- Both projects use BCrypt password encoding for secure password storage.
- The JWT-based project uses stateless session management, while the other uses HTTP Basic and form login.
- CSRF protection is disabled in both projects for simplicity.
- Customize and extend these projects as needed for your own security requirements.

---

## References

- [Spring Security Documentation](https://spring.io/projects/spring-security)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
