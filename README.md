
# Spring Boot JWT Authentification

This is a simple Spring Boot project that demonstrates how to implement JWT-based authentication using Spring Security. Features

## Features

- JWT-based stateless authentication
- Spring Security configuration
- Login endpoint to generate JWT token
- Role-based access control (e.g. `USER`, `ADMIN`)
- Custom user authentication logic
- Secure REST APIs with token-based authorization
- DTOs and Entity mapping

## project Structure

src/main/java/com/example/securityjwt/
├── config/
│   ├── AppConfig.java
│   ├── JwtAuthFilter.java
│   ├── JwtUtil.java
│   └── SecurityConfig.java
│
├── controller/
│   └── AuthController.java
│
├── dto/
│   └── UserDto.java
│
├── entity/
│   ├── Role.java
│   └── User.java
│
├── repository/
│   └── UserRepository.java
│
├── service/
│   └── CustomUserDetailsService.java
│
└── SecurityJwtApplication.java

## Prerequisites

Java 17+

Maven

Spring Boot 3.x

A REST client: Postman

## configuration

# JWT secret key
jwt.secret=your_jwt_secret_key
jwt.expiration=86400000  # 1 day in milliseconds

# MySQL database
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

## Authentification Flow

User sends login credentials to /api/auth/login

If valid, a JWT token is returned

User includes this token in the Authorization: Bearer <token> header

Backend verifies JWT in JwtAuthFilter.java

If verified, user is authenticated, and their role is checked

## Endpoint

| Method | Endpoint          | Access      | Description                     |
| ------ | ----------------- | ----------- | ------------------------------- |
| POST   | `/api/auth/login` | Public      | Login and get JWT token         |
| GET    | `/api/user/home`  | USER, ADMIN | Secured for authenticated users |
| GET    | `/api/admin/home` | ADMIN       | Only accessible by admin        |

## Testing the APIs
1. Login and Get Token
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}

2. Access Secured Endpoint
GET /api/user/home
Authorization: Bearer <your_token_here>

## Useful Links

Spring Security Docs

JWT Introduction

JJWT GitHub

## License

This project is licensed under the MIT License.

## Author

@mkaef
