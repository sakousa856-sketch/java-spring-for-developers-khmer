# Example Project: Bookstore RESTful API CRUD (Spring Boot 3)

[Khmer Version](./README.kh.md)

This project demonstrates a production-grade RESTful API built with Spring Boot 3.3, Java 17 Records, Jakarta Validation, and Global Exception Handling.

## How to Run

```bash
cd 03-spring-boot/examples/01-rest-api-crud
mvn spring-boot:run
```

## Test with cURL

```bash
# Create Book
curl -X POST http://localhost:8080/api/v1/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Spring Boot in Action","author":"Craig Walls","isbn":"978-1617292545","price":39.99}'

# Get all books
curl -X GET http://localhost:8080/api/v1/books

# Get by ID
curl -X GET http://localhost:8080/api/v1/books/1

# Delete by ID
curl -X DELETE http://localhost:8080/api/v1/books/1
```
