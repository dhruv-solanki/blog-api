# Blog Application

A simple blog backend built using Spring Boot.

## 🚀 Tech Stack

* Java 21
* Spring Boot 4
* Spring Data JPA
* Spring Web MVC
* Spring Security
* PostgreSQL (Primary Database)
* H2 Database (Testing only)
* JWT Authentication
* MapStruct
* Lombok

---

## 📦 Features

* REST APIs for blog management
* Database integration using JPA
* Input validation
* Authentication using JWT
* Object mapping using MapStruct

---

## 🛠️ Setup & Run

### 1. Clone the project

```bash
git clone <your-repo-url>
cd blog
```

### 2. Build the project

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn spring-boot:run
```

---

## 🗄️ Database Configuration

### PostgreSQL (Primary)

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blog
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

### H2 (Testing Only)

* Used for unit/integration testing
* Not intended for production use

---

## 🔐 Authentication

* Uses JWT (JSON Web Token)
* Secured endpoints using Spring Security

---

## 📡 API Testing

Use tools like Postman to test APIs.

---

## 🧪 Testing

Run tests using:

```bash
mvn test
```

---

## 📁 Project Structure

* `controller` → Handles HTTP requests and responses
* `service` → Contains business logic
* `repository` → Database access layer (JPA)
* `domain.entity` → Database models
* `domain.dto` → Request/Response objects
* `mapper` → Converts Entity ↔ DTO
* `security` → JWT authentication & Spring Security config
* `config` → Application configuration

---

## ⚡ Notes

* Ensure Java 21 is installed
* Configure PostgreSQL before running the app
* H2 is only used for testing purposes
* Use proper password encoding for security
