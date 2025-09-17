# RetailEasy Spring Boot API - AI Coding Assistant Instructions

## Project Overview

RetailEasy is a Spring Boot 3.5.5 REST API for retail management built with Java 21, JPA/Hibernate, and PostgreSQL. The project follows a classic 3-layer architecture: Controller → Service → Repository.

## Key Architecture Patterns

### Package Structure

- `dev.thesujan.retaileasy.model.*` - JPA entities with Lombok annotations
- `dev.thesujan.retaileasy.repository.*` - Spring Data JPA repositories
- `dev.thesujan.retaileasy.service.*` - Business logic with `@Transactional` methods
- `dev.thesujan.retaileasy.controller.*` - REST endpoints with `/api/*` prefix

### Database Conventions

- **Case sensitivity**: Use lowercase table names (`@Table(name = "users")`) for PostgreSQL compatibility
- **Column mapping**: Snake_case columns (`first_name`) mapped to camelCase fields (`firstName`)
- **DDL strategy**: `spring.jpa.hibernate.ddl-auto=update` auto-creates tables in development

### Lombok Usage Pattern

Individual `@Getter/@Setter` per field instead of class-level annotations:

```java
@Column(name = "first_name")
@Getter
@Setter
private String firstName;
```

### Repository Anti-Patterns

- **NEVER** add custom save methods to repositories (e.g., `saveUser()`)
- Use inherited `JpaRepository.save()` method - custom save methods cause Spring Data query parsing errors
- Follow Spring Data naming conventions for query methods (`findByUserName`, `existsByEmail`)

### Service Layer Patterns

- Constructor injection for dependencies
- `@Transactional` on write operations
- Validation logic before persistence (check `existsByEmail()` before creating users)
- Email normalization: `user.getEmail().toLowerCase()` for consistency

### Controller Patterns

- Use `/api/` prefix for all endpoints (`/api/users`, `/api/signup`)
- Constructor injection over field injection
- Generic exception handling with `RuntimeException` wrapper
- No explicit `@RequestMapping` at class level - individual method mappings

## Development Workflow

### Running the Application

- **Maven**: `./mvnw spring-boot:run` (macOS/Linux) or use VS Code Spring Boot Dashboard
- **Port**: Application runs on `8080`
- **Database**: Requires PostgreSQL on `localhost:5432` with database `skundu879`

### Database Setup

Database connection configured in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/skundu879
spring.datasource.username=skundu879
spring.datasource.password=root
```

### Testing

- Basic smoke test in `RetaileasyApplicationTests.java`
- Run tests: `./mvnw test`

## Common Issues & Solutions

### Table Creation Issues

If you see "relation does not exist" errors:

1. Ensure table names are lowercase in `@Table(name = "tablename")`
2. Verify `spring.jpa.hibernate.ddl-auto=update` is set
3. Check PostgreSQL connection and database exists

### Repository Method Errors

If you see "No property 'methodName' found" errors:

- Remove custom save/update methods from repository interfaces
- Use inherited JPA methods (`save()`, `findById()`, etc.)
- Follow Spring Data query method naming conventions

## Key Dependencies

- **Spring Boot 3.5.5** with Java 21
- **PostgreSQL 42.6.0** driver
- **Lombok** for boilerplate reduction
- **Spring Boot DevTools** for development hot-reload
- **Spring Boot Actuator** for monitoring endpoints

When adding new features, maintain the established layered architecture and naming conventions.
