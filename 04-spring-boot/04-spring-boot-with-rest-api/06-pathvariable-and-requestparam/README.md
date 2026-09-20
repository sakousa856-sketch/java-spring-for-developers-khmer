# Lesson 6: Handling Input with @PathVariable and @RequestParam

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../05-put-and-delete-mapping/README.md) | [Next Lesson →](../07-requestbody/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore REST API (@PathVariable)](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java)


## Table of Contents

- [1. Introduction to Client Input Mechanisms](#1-introduction-to-client-input-mechanisms)
- [2. Using `@PathVariable` (Path Variables)](#2-using-pathvariable-path-variables)
- [3. Using `@RequestParam` (Query Parameters)](#3-using-requestparam-query-parameters)
- [4. Using `@RequestBody` (Payload Extraction)](#4-using-requestbody-payload-extraction)
- [5. Extracting HTTP Headers with `@RequestHeader`](#5-extracting-http-headers-with-requestheader)
- [6. Comparative Reference Table](#6-comparative-reference-table)
- [7. Comprehensive Combined Example](#7-comprehensive-combined-example)

---

## 1. Introduction to Client Input Mechanisms

In modern RESTful API architectures, client applications (React, Angular, iOS/Android mobile clients) transmit data to the Spring Boot backend across 4 distinct communication channels:

1. Embedded within **URL Path Segments** (e.g., `/users/100`)
2. Appended via **Query Parameter Strings** (e.g., `/products?category=electronics&sort=asc`)
3. Encapsulated within the **HTTP Request Body** as JSON/XML payloads
4. Transmitted as **HTTP Request Headers** (e.g., Authorization tokens, API keys)

---

## 2. Using `@PathVariable` (Path Variables)

`@PathVariable` extracts values directly embedded in URI path templates. It is best suited for addressing unique, immutable resource identifiers (IDs, UUIDs, slugs).

```java
// Target URL: GET /api/v1/orders/ORD-99281
@GetMapping("/orders/{orderId}")
public ResponseEntity<Order> getOrder(@PathVariable("orderId") String orderId) {
    return ResponseEntity.ok(orderService.findById(orderId));
}
```

- When the parameter name matches the URI path segment variable `{id}`, `@PathVariable Long id` can be specified without redundant variable mapping strings.
- Path variables can be declared optional via `required = false`.

---

## 3. Using `@RequestParam` (Query Parameters)

`@RequestParam` binds HTTP query parameters appended after the `?` query string indicator. It is standard industry practice for:
- Filtering collections
- Sorting query results
- Paginating large datasets

```java
// Target URL: GET /api/v1/products?category=laptop&page=0&size=20
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

## 4. Using `@RequestBody` (Payload Extraction)

`@RequestBody` instructs Spring Boot to capture the raw HTTP request payload (typically formatted in JSON) and deserialize it into a structured Java Object (POJO or Java Record) via Jackson `HttpMessageConverter`.

```java
// DTO Definition
public record CreateUserRequest(String name, String email, int age) {}

// Controller Endpoint
// URL: POST /api/v1/users (Payload: {"name": "Sophea", "email": "sophea@example.com", "age": 25})
@PostMapping("/users")
public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
    UserResponse created = userService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
}
```

---

## 5. Extracting HTTP Headers with `@RequestHeader`

Certain scenarios mandate reading metadata directly from HTTP headers, such as authorization bearer tokens, custom tenant identifiers, or distributed tracing IDs:

```java
@GetMapping("/secure-data")
public ResponseEntity<String> getSecureData(
        @RequestHeader(name = "Authorization") String authHeader,
        @RequestHeader(name = "X-Device-Id", required = false) String deviceId
) {
    // Perform authentication header verification...
    return ResponseEntity.ok("Protected payload retrieved");
}
```

---

## 6. Comparative Reference Table

| Annotation | Input Location | Typical Syntax | Primary Use Case |
| :--- | :--- | :--- | :--- |
| **`@PathVariable`** | URI Path Segments | `/users/{id}` | Unique resource identity addressing |
| **`@RequestParam`** | Query String (`?...`) | `?status=ACTIVE&page=1` | Filtering, sorting, searching, pagination |
| **`@RequestBody`** | HTTP Request Body | Raw JSON `{...}` | Complex creation and mutation payloads (`POST`, `PUT`) |
| **`@RequestHeader`** | HTTP Headers | `Authorization: Bearer ...` | Security tokens, device telemetry, metadata |

---

## 7. Comprehensive Combined Example

```java
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    // Demonstrates seamless coexistence of PathVariable, RequestParam, and RequestHeader
    @GetMapping("/{category}/{id}")
    public ResponseEntity<String> getArticle(
            @PathVariable String category,
            @PathVariable Long id,
            @RequestParam(defaultValue = "en") String lang,
            @RequestHeader("User-Agent") String clientAgent
    ) {
        String message = String.format("Retrieved article ID=%d in Category=%s, language=%s (Client: %s)",
                id, category, lang, clientAgent);
        return ResponseEntity.ok(message);
    }
}
```

---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Working with @PutMapping & @DeleteMapping](../05-put-and-delete-mapping/README.md) | [📚 Module Index](../README.md) | [Handling Request Body with @RequestBody →](../07-requestbody/README.md) |
