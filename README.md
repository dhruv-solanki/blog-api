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

```bash id="c6o7h1"
git clone <your-repo-url>
cd blog
```

### 2. Build the project

```bash id="j9e2d4"
mvn clean install
```

### 3. Run the application

```bash id="v8k3lm"
mvn spring-boot:run
```

---

## 🗄️ Database Configuration

### PostgreSQL (Primary)

Update your `application.properties`:

```properties id="m5x2zq"
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

```bash id="3e0g7n"
mvn test
```

---

## 📁 Project Structure

* `controller` → REST controllers
* `service` → business logic
* `repository` → database layer
* `domain` → to store entity, dto, and service layer objects`

---

## ⚡ Notes

* Ensure Java 21 is installed
* Configure PostgreSQL before running the app
* H2 is only used for testing purposes
* Use proper password encoding for security
