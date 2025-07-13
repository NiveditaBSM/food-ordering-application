# Food Ordering Application

A Spring Boot-based RESTful backend system for managing food ordering operations including restaurants, menus, customers, and orders.

## 📌 Features

- Full-featured REST APIs for:
  - Restaurant and Menu Management
  - Customer Management
  - Order Placement
- Layered architecture (Controller → Service → Repository)
- DTO-based request/response models for clean API design
- Global exception handling using `@ControllerAdvice`
- MySQL integration using Spring Data JPA
- Basic AOP (Aspect-Oriented Programming) for logging request processing time
- Modular and extensible codebase

## 🛠️ Tech Stack

- **Language:** Java 21
- **Frameworks:** Spring Boot, Spring Web, Spring Data JPA
- **Database:** MySQL
- **Build Tool:** Maven
- **Others:** AOP, Postman (for API testing), Swagger

## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL (with a database named as per your config)

### Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/NiveditaBSM/food-ordering-application.git
   cd food-ordering-application

   ```

2. **Configure the application**

Create a application.properties file in src/main/resources based on the provided application-example.properties.

3. **Run the application**

Create a application.properties file in src/main/resources based on the provided application-example.properties.

```bash
    mvn spring-boot:run
```

### Project Structure

```css
src/
├── main/
│   ├── java/
│   │   └── com/sunbeam/
│   │       ├── controller/
│   │       ├── dto/
│   │       └── dao/
│   │       ├── entities/
│   │       ├── custom_exceptions/
│   │       ├── exception_handler/
│   │       ├── repository/
│   │       ├── service/
│   │       └── aspects/
│   └── resources/
│       ├── application.properties (excluded via .gitignore)
│       └── application-example.properties
```
