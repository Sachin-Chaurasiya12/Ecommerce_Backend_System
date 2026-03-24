# 🛒 E-Commerce Backend

A full-featured RESTful backend for an e-commerce platform built using **Spring Boot**.  
This project supports user management, product catalog, cart system, order processing, and **secure online payments via Stripe**.

---

## 🚀 Tech Stack

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security (JWT)**
- **MySQL**
- **Maven**
- **Swagger (API Documentation)**
- **Stripe (Payment Gateway)**

---

## 📦 Features

- 🔐 JWT-based authentication & authorization  
- 📦 Product & category management  
- 🛒 Shopping cart system  
- 📄 Order creation & tracking  
- 💳 Stripe payment integration  
- 🔔 Webhook-based payment confirmation  
- 🔒 Secure REST APIs  
- 📘 Swagger API documentation  

---

## 💳 Stripe Payment Integration

This project uses **Stripe** to handle secure online payments.

### ✔️ Key Functionalities

- Create **PaymentIntent**
- Attach `orderId` as metadata
- Handle **Stripe Webhooks**
- Automatically update order status after successful payment

---

### 🔄 Payment Flow

```text
1. User places order → status = PENDING
2. Backend creates PaymentIntent
3. Frontend completes payment using client_secret
4. Stripe sends webhook event
5. Backend updates order → PAID
🏗️ Architecture
Controller → Service → Repository → Database
Controller → Handles HTTP requests

Service → Contains business logic (orders, payments)

Repository → Manages database operations

📂 Project Structure
src/main/java/com/ecommerce
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── security/
└── config/
🔌 API Endpoints
🔐 Authentication
POST /api/auth/register
POST /api/auth/login
📦 Products
GET    /api/products
POST   /api/products
PUT    /api/products/{id}
DELETE /api/products/{id}
🗂️ Categories
GET    /api/category
POST   /api/category
PUT    /api/category/{id}
DELETE /api/category/{id}
🛒 Cart
POST   /api/cart/add
GET    /api/cart/{id}
DELETE /api/cart/remove/{id}
📦 Orders
POST /api/orders
GET  /api/orders
GET  /api/orders/{id}
💳 Payment
POST /api/payment/create-payment
Request Body
{
  "amount": 5000,
  "orderId": 4
}
Response
{
  "clientSecret": "pi_XXXX_secret_XXXX"
}
🔔 Webhook
POST /api/webhook
Handles:

payment_intent.succeeded

Action:

Extracts orderId from metadata

Updates order status → PAID

📖 API Documentation
Access Swagger UI at:

http://localhost:8080/swagger-ui/index.html
⚙️ Running the Project
1. Clone Repository
git clone <repository-url>
2. Navigate to Project
cd <project-folder>
3. Configure Database
Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
4. Add Stripe Keys
stripe.secret.key=your_secret_key
5. Run Application
mvn spring-boot:run
🧪 Testing Payments
✔️ Option 1: Postman (Basic Testing)
Call /api/payment/create-payment

Use returned clientSecret in frontend

✔️ Option 2: Stripe CLI (Recommended)
stripe listen --forward-to localhost:8080/api/webhook
stripe trigger payment_intent.succeeded
🔮 Future Improvements
🐳 Docker containerization

⚡ Redis caching

🧩 Microservices architecture

❌ Payment failure handling

🧑‍💼 Admin dashboard

📊 Order analytics

👨‍💻 Author
Sachin Chaurasiya


---

If you want, I can also create a **GitHub-ready version with badges, a cover image, and clickable links** so it looks professional on your repo homepage.  

Do you want me to do that next?
