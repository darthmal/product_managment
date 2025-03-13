# Product Management System

A Spring Boot application that provides RESTful APIs for managing product inventory.

## Features

### Product Management
- Complete CRUD operations for product inventory
- Automatic low stock detection
- Validation for product data integrity

### Product Management Endpoints
1. Product Endpoints
   - `GET /api/products` - List all products
   - `GET /api/products/{id}` - Get product by ID
   - `POST /api/products` - Create a new product
   - `PUT /api/products/{id}` - Update an existing product
   - `DELETE /api/products/{id}` - Delete a product
   - `GET /api/products/low-stock` - Get products with low stock

### Data Validation
- Mandatory fields validation for product name, price, and stock quantity
- Price and stock quantity must be non-negative values
- Automatic low stock threshold (default: 5 units)

## Technical Stack

- Java (Spring Boot)
- Spring Data JPA for database operations
- Jakarta Validation for request validation
- Lombok for reducing boilerplate code
- PostgreSQL Database (assumed)
- Swagger/OpenAPI for API documentation

## Prerequisites

1. Java 17 or higher
2. PostgreSQL 12 or higher (or your preferred database)
3. IntelliJ IDEA (recommended)
4. Maven 3.6 or higher

## Setup Instructions

### 1. Database Setup

1. Install PostgreSQL if not already installed
2. Create a new database for the application
3. Configure the `.env` file in the project root:
   ```properties
   PORT=8080
   DB_URL=jdbc:postgresql://localhost:5432/your_database_name
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   ```

### 2. Project Setup in IntelliJ IDEA

1. Clone the repository
2. Open IntelliJ IDEA
3. Go to File -> Open and select the project directory
4. Wait for Maven to download dependencies
5. Copy .env.example to .env and update the values
6. Enable annotation processing for Lombok:
   - Go to Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors
   - Check Enable annotation processing
7. Make sure PostgreSQL is running (Docker container recommended)
8. Run the application:
   - Find the main application class (likely ending with `Application.java`)
   - Right-click and select Run
   - Or use Maven: `mvn spring-boot:run`
9. The application will start on http://localhost:8080 (or the port specified in your .env file)
10. Access Swagger UI: http://localhost:8080/swagger-ui.html

## API Testing with Swagger UI

Access Swagger UI at http://localhost:8080/product-management-app/swagger-ui.html
- Test all product endpoints
- View schema documentation for request and response models

## Database Schema

### The product table includes:
- id (Primary Key)
- name (String, mandatory)
- price (BigDecimal, mandatory)
- stock_quantity (Integer, mandatory)
- low_stock_threshold (Integer, default: 5)
- created_at (from BaseEntity)
- updated_at (from BaseEntity)

## Error Handling

#### The application provides detailed error messages for:
- Invalid product data
- Product not found
- Validation errors

## Additional Notes

- The system automatically detects products with low stock (below threshold)
- The API is documented using Swagger/OpenAPI annotations
- A mapper is used to convert between DTOs and entity objects