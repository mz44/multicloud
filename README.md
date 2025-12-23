# Multicloud (Java)

This repository contains a starter Java 17 (Spring Boot + Maven) project for a multicloud account management service.

Highlights:
- JWT-based authentication (simple implementation)
- Cloud provider skeletons (AWS, Azure, Aliyun, Tencent, Huawei)
- Dockerfile and docker-compose for local development

Quick start:
- Build and run locally: mvn spring-boot:run
- Build Docker image: docker build -t multicloud .
- Start with Docker Compose: cp .env.example .env && docker-compose up --build

Endpoints:
- POST /auth/register {username, password, provider}
- POST /auth/login {username, password}
- GET /accounts (requires Bearer token)
- GET /accounts/me (requires Bearer token)

Notes:
- The project uses H2 in-memory DB by default for quick development. You can configure Postgres via docker-compose and SPRING_DATASOURCE_* env vars.
- The JWT secret in application.yml should be changed for production.

License: MIT
