# 🛒 E-Commerce Backend

A RESTful backend system for an e-commerce platform built using **Spring Boot**.
It provides APIs for managing products, users, shopping carts, and orders.

---

## 🚀 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL
* Maven
* Swagger (API Documentation)

---

## 📦 Features

* User authentication (JWT)
* Product management
* Shopping cart management
* Order processing
* Secure REST APIs
* API documentation with Swagger

---

## 🏗️ Architecture

The project follows a layered architecture:

```
Controller → Service → Repository → Database
```

* **Controller** → Handles HTTP requests
* **Service** → Contains business logic
* **Repository** → Handles database operations

---

## 📂 Project Structure

```
src/main/java/com/ecommerce

controller/
service/
repository/
model/
dto/
security/
config/
```

---

## 🔌 API Endpoints

### Authentication

```
POST /api/auth/register
POST /api/auth/login
```

### Products

```
GET /api/products
POST /api/products
PUT /api/products/{id}
DELETE /api/products/{id}
```

### Cart

```
POST /api/cart/add
GET /api/cart
DELETE /api/cart/remove
```

### Orders

```
POST /api/orders
GET /api/orders
GET /api/orders/{id}
```

---

## 📖 API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Running the Project

Clone the repository:

```
git clone <repository-url>
```

Run the application:

```
mvn spring-boot:run
```

Server runs at:

```
http://localhost:8080
```

---

## 🔮 Future Improvements

* Payment gateway integration
* Docker containerization
* Redis caching
* Microservices architecture

---

## 👨‍💻 Author

Backend Developer
