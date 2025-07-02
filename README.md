# Spring Security Example Project

This is a demo project for Spring Boot that demonstrates how to use Spring Security for authentication and authorization.

## Technologies Used

* Java 21
* Spring Boot 3.5.3
* Spring Security
* JWT (JSON Web Token)
* Maven
* MySQL

## Endpoints

The following endpoints are available:

* `GET /`: A welcome message.
* `POST /register`: Register a new user.
* `POST /login`: Login as an existing user.
* `GET /students`: Get a list of all students.
* `POST /students`: Add a new student.
* `GET /csrf-token`: Get a CSRF token.

## How to Run

1. Clone the repository.
2. Make sure you have Java 21 and Maven installed.
3. Run the application using the following command:

```bash
./mvnw spring-boot:run
```

## How to Use

1. Register a new user by sending a POST request to `/register` with the following body:

```json
{
    "username": "your_username",
    "password": "your_password"
}
```

2. Login by sending a POST request to `/login` with the same body as above. You will receive a JWT token in the response.

3. To access the protected endpoints, you need to include the JWT token in the `Authorization` header of your request. The header should be in the following format:

```
Authorization: Bearer <your_jwt_token>
```

For example, to get a list of all students, you would send a GET request to `/students` with the `Authorization` header set to the JWT token you received in the previous step.
