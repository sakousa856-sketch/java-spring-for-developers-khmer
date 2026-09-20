# មេរៀនទី ៦: ការគ្រប់គ្រងទិន្នន័យ Input ជាមួយ @PathVariable និង @RequestParam

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../05-put-and-delete-mapping/README.kh.md) | [មេរៀនបន្ទាប់ →](../07-requestbody/README.kh.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore REST API (@PathVariable)](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java)


## មាតិកា (Table of Contents)

- [1. សេចក្តីផ្តើមអំពីការទទួលទិន្នន័យពី Client](#1-សេចក្តីផ្តើមអំពីការទទួលទិន្នន័យពី-client)
- [2. ការប្រើប្រាស់ `@PathVariable` (Path Variables)](#2-ការប្រើប្រាស់-pathvariable-path-variables)
- [3. ការប្រើប្រាស់ `@RequestParam` (Query Parameters)](#3-ការប្រើប្រាស់-requestparam-query-parameters)
- [4. ការប្រើប្រាស់ `@RequestBody` (Payload Extraction)](#4-ការប្រើប្រាស់-requestbody-payload-extraction)
- [5. ការទាញយក HTTP Headers ជាមួយ `@RequestHeader`](#5-ការទាញយក-http-headers-ជាមួយ-requestheader)
- [6. តារាងប្រៀបធៀបពេលណាត្រូវប្រើមួយណា](#6-តារាងប្រៀបធៀបពេលណាត្រូវប្រើមួយណា)
- [7. កូដគំរូរួមបញ្ចូលគ្នា (Comprehensive Example)](#7-កូដគំរូរួមបញ្ចូលគ្នា-comprehensive-example)

---

## 1. សេចក្តីផ្តើមអំពីការទទួលទិន្នន័យពី Client

នៅក្នុងស្ថាបត្យកម្ម RESTful API ភាគី Client (ដូចជា Web Frontend, React, Flutter) អាចផ្ញើទិន្នន័យមកកាន់ Spring Boot Backend តាមរយៈ ៤ ផ្លូវផ្សេងគ្នា៖

1. តាមរយៈ **URL Path Segment** (ឧទាហរណ៍ `/users/100`)
2. តាមរយៈ **Query String** (ឧទាហរណ៍ `/products?category=electronics&sort=asc`)
3. តាមរយៈ **HTTP Request Body** ជាទម្រង់ JSON/XML
4. តាមរយៈ **HTTP Request Headers** (ដូចជា Authorization Header, API Keys)

---

## 2. ការប្រើប្រាស់ `@PathVariable` (Path Variables)

`@PathVariable` ត្រូវបានប្រើប្រាស់ដើម្បីទាញយកតម្លៃដែលមានស្រាប់នៅក្នុង URL Path ដោយផ្ទាល់។ វាស័ក្តិសមបំផុតសម្រាប់សម្គាល់អត្តសញ្ញាណតែមួយគត់របស់ Resource (Unique Resource Identifier) ដូចជា ID ឬ UUID។

```java
// URL: GET /api/v1/orders/ORD-99281
@GetMapping("/orders/{orderId}")
public ResponseEntity<Order> getOrder(@PathVariable("orderId") String orderId) {
    return ResponseEntity.ok(orderService.findById(orderId));
}
```

- ប្រសិនបើឈ្មោះ Variable ដូចឈ្មោះក្នុង Path `{id}` យើងអាចសរសេរកាត់ `@PathVariable Long id` ដោយមិនបាច់ដាក់ `("id")` ឡើយ។
- យើងក៏អាចកំណត់ `required = false` ប្រសិនបើ Path Variable នោះជា Optional។

---

## 3. ការប្រើប្រាស់ `@RequestParam` (Query Parameters)

`@RequestParam` ត្រូវបានប្រើដើម្បីទាញយក Query Parameters ដែលនៅខាងក្រោយសញ្ញាសួរ `?` ក្នុង URL។ វាត្រូវបានប្រើប្រាស់យ៉ាងទូលំទូលាយសម្រាប់៖
- ការត្រងទិន្នន័យ (Filtering)
- ការតម្រៀបទិន្នន័យ (Sorting)
- ការបែងចែកទំព័រ (Pagination)

```java
// URL: GET /api/v1/products?category=laptop&page=0&size=20
@GetMapping("/products")
public ResponseEntity<List<Product>> getProducts(
        @RequestParam(name = "category", required = false) String category,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "10") int size
) {
    return ResponseEntity.ok(productService.find(category, page, size));
}
```

---

## 4. ការប្រើប្រាស់ `@RequestBody` (Payload Extraction)

`@RequestBody` ប្រាប់ Spring Boot ឱ្យយកទិន្នន័យនៅក្នុង HTTP Request Body (ជាទូទៅជា JSON Payload) ហើយបម្លែង (Deserialize) ទៅជា Java Object (POJO ឬ Record) ដោយស្វ័យប្រវត្តិតាមរយៈបណ្ណាល័យ Jackson `HttpMessageConverter`។

```java
// Model DTO
public record CreateUserRequest(String name, String email, int age) {}

// Controller
// URL: POST /api/v1/users (Body: {"name": "Sophea", "email": "sophea@example.com", "age": 25})
@PostMapping("/users")
public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
    UserResponse created = userService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
}
```

---

## 5. ការទាញយក HTTP Headers ជាមួយ `@RequestHeader`

ពេលខ្លះយើងត្រូវការចាប់តម្លៃពី HTTP Header ដូចជា Authorization Token, Client Type, ឬ Correlation ID សម្រាប់ Tracing៖

```java
@GetMapping("/secure-data")
public ResponseEntity<String> getSecureData(
        @RequestHeader(name = "Authorization") String authHeader,
        @RequestHeader(name = "X-Device-Id", required = false) String deviceId
) {
    // ត្រួតពិនិត្យ Auth token...
    return ResponseEntity.ok("ទិន្នន័យសម្ងាត់");
}
```

---

## 6. តារាងប្រៀបធៀបពេលណាត្រូវប្រើមួយណា

| Annotation | ទីតាំងទិន្នន័យ | ឧទាហរណ៍ប្រើប្រាស់ | កាលៈទេសៈស័ក្តិសម (Use Case) |
| :--- | :--- | :--- | :--- |
| **`@PathVariable`** | ក្នុង URL Path | `/users/{id}` | សម្គាល់ Resource ID ជាក់លាក់ |
| **`@RequestParam`** | ក្រោយ `?` ក្នុង URL | `?status=ACTIVE&page=1` | Filter, Sort, Search, Pagination |
| **`@RequestBody`** | ក្នុង Request Body | Raw JSON Payload `{...}` | បង្កើត ឬកែប្រែទិន្នន័យស្មុគស្មាញ (POST/PUT) |
| **`@RequestHeader`** | ក្នុង HTTP Headers | `Authorization: Bearer ...` | Tokens, API Keys, Metadata |

---

## 7. កូដគំរូរួមបញ្ចូលគ្នា (Comprehensive Example)

```java
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    // ឧទាហរណ៍រួមបញ្ចូលគ្នារវាង PathVariable, RequestParam, និង RequestHeader
    @GetMapping("/{category}/{id}")
    public ResponseEntity<String> getArticle(
            @PathVariable String category,
            @PathVariable Long id,
            @RequestParam(defaultValue = "en") String lang,
            @RequestHeader("User-Agent") String clientAgent
    ) {
        String message = String.format("ទាញយកអត្ថបទ ID=%d ក្នុង Category=%s ភាសា=%s (Client: %s)",
                id, category, lang, clientAgent);
        return ResponseEntity.ok(message);
    }
}
```

---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ @PutMapping និង @DeleteMapping (Working with @PutMapping & @DeleteMapping)](../05-put-and-delete-mapping/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការប្រើប្រាស់ @RequestBody (Handling Request Body in Spring Boot) →](../07-requestbody/README.kh.md) |
