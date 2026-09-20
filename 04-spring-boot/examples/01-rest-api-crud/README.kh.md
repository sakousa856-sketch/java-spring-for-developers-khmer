# គម្រោងគំរូ: Bookstore RESTful API CRUD (Spring Boot 3)

[English Version](./README.md)

គម្រោងនេះអនុវត្តតាមស្តង់ដារ Clean Layered Architecture ជាមួយ Spring Boot 3.3, Java 17 Records, Jakarta Bean Validation, និង Global Exception Handling។

## របៀបដំណើរការ (How to Run)

```bash
# 1. ចូលទៅកាន់ folder គម្រោង
cd 03-spring-boot/examples/01-rest-api-crud

# 2. Run កម្មវិធី
mvn spring-boot:run
```

## ធ្វើតេស្តជាមួយ cURL

```bash
# បង្កើតសៀវភៅថ្មី (POST)
curl -X POST http://localhost:8080/api/v1/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Spring Boot in Action","author":"Craig Walls","isbn":"978-1617292545","price":39.99}'

# ទាញយកសៀវភៅទាំងអស់ (GET)
curl -X GET http://localhost:8080/api/v1/books

# ទាញយកសៀវភៅតាម ID (GET)
curl -X GET http://localhost:8080/api/v1/books/1

# លុបសៀវភៅ (DELETE)
curl -X DELETE http://localhost:8080/api/v1/books/1
```
