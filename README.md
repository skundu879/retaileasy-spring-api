# RetailEasy API

A modern Spring Boot REST API for retail management, built with Java 21 and PostgreSQL.

## 🚀 Features

- **User Management**: Complete user registration and authentication system
- **RESTful API**: Clean REST endpoints with `/api/*` prefix
- **Database Integration**: PostgreSQL with JPA/Hibernate ORM
- **Modern Java**: Built on Java 21 with Spring Boot 3.5.5
- **Development Tools**: Hot reload with Spring Boot DevTools
- **Monitoring**: Spring Boot Actuator for health checks and metrics

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.5.5
- **Language**: Java 21
- **Database**: PostgreSQL 42.6.0
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Code Generation**: Lombok
- **Development**: Spring Boot DevTools

## 📋 Prerequisites

Before running this application, make sure you have:

- **Java 21** or higher installed
- **PostgreSQL** server running on `localhost:5432`
- **Maven** (or use the included wrapper `./mvnw`)
- A PostgreSQL database named `skundu879`

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd retaileasy-springboot-api/retaileasy
```

### 2. Database Setup

1. Install and start PostgreSQL
2. Create a database named `skundu879`:
   ```sql
   CREATE DATABASE skundu879;
   ```
3. Update database credentials in `src/main/resources/application.properties` if needed:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/skundu879
   spring.datasource.username=skundu879
   spring.datasource.password=root
   ```

### 3. Run the Application

#### Using Maven Wrapper (Recommended)

```bash
./mvnw spring-boot:run
```

#### Using VS Code

- Open the project in VS Code
- Use the Spring Boot Dashboard to run the application

#### Using IDE

- Import as Maven project
- Run `RetaileasyApplication.java` main method

The application will start on `http://localhost:8080`

### 4. Verify Installation

Check if the application is running:

```bash
curl http://localhost:8080/actuator/health
```

## 📚 API Documentation

### User Endpoints

#### Get All Users

```http
GET /api/users
```

#### User Registration

```http
POST /api/signup
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "userName": "johndoe",
  "email": "john@example.com",
  "password": "password123"
}
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/dev/thesujan/retaileasy/
│   │   ├── controller/          # REST Controllers
│   │   ├── service/             # Business Logic
│   │   ├── repository/          # Data Access Layer
│   │   ├── model/               # JPA Entities
│   │   └── RetaileasyApplication.java
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
└── test/
    └── java/dev/thesujan/retaileasy/
        └── RetaileasyApplicationTests.java
```

## 🔧 Configuration

### Database Configuration

The application uses PostgreSQL with the following default settings:

- **URL**: `jdbc:postgresql://localhost:5432/skundu879`
- **Username**: `skundu879`
- **Password**: `root`
- **DDL**: Auto-update tables in development

### JPA/Hibernate Settings

- **Dialect**: PostgreSQL
- **Show SQL**: Enabled in development
- **Format SQL**: Pretty printing enabled

## 🧪 Testing

Run the test suite:

```bash
./mvnw test
```

## 🛠️ Development

### Code Style

- Uses Lombok for reducing boilerplate code
- Individual `@Getter/@Setter` annotations per field
- Constructor injection for dependencies
- Snake_case database columns mapped to camelCase Java fields

### Common Patterns

- **Entities**: JPA entities in `model` package with lowercase table names
- **Repositories**: Extend `JpaRepository` with standard Spring Data methods
- **Services**: Business logic with `@Transactional` annotations
- **Controllers**: REST endpoints with constructor injection

## 🚨 Troubleshooting

### Database Connection Issues

1. Ensure PostgreSQL is running: `brew services start postgresql` (macOS)
2. Verify database exists: `psql -d skundu879 -c "SELECT version();"`
3. Check credentials in `application.properties`

### Table Creation Issues

If you see "relation does not exist" errors:

1. Ensure `spring.jpa.hibernate.ddl-auto=update` is set
2. Verify table names are lowercase in `@Table` annotations
3. Check PostgreSQL permissions for the user

### Repository Method Errors

Avoid custom save methods in repositories. Use inherited `JpaRepository.save()` method instead.

## 📝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/new-feature`
3. Commit changes: `git commit -am 'Add new feature'`
4. Push to branch: `git push origin feature/new-feature`
5. Submit a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Sujan Kundu**

- Email: skundu879@gmail.com
- GitHub: [@thesujan](https://github.com/thesujan)

## 🔗 Links

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Spring Data JPA Reference](https://spring.io/projects/spring-data-jpa)
