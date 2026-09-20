# Lesson 4: Mastering @GetMapping & @PostMapping

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../03-request-mapping/README.md) | [Next Lesson →](../05-put-and-delete-mapping/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore REST API (@GetMapping & @PostMapping)](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`CreateBookRequest.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/dto/CreateBookRequest.java)


---

## Table of Contents
1. [Introduction to Composed Request Mappings](#introduction-to-composed-request-mappings)
2. [Fetching Data with @GetMapping](#fetching-data-with-getmapping)
3. [Creating Resources with @PostMapping](#creating-resources-with-postmapping)
4. [Using ResponseEntity with HTTP Status Codes (200 vs 201)](#using-responseentity-with-http-status-codes-200-vs-201)
5. [End-to-End Example with DTOs](#end-to-end-example-with-dtos)
6. [Summary](#summary)

---

## Introduction to Composed Request Mappings
In Spring 4.3+, `@GetMapping` and `@PostMapping` act as expressive shorthand annotations for `@RequestMapping(method = RequestMethod.GET)` and `@RequestMapping(method = RequestMethod.POST)`. They enhance readability and eliminate boilerplate mapping declarations.

---

## Fetching Data with @GetMapping

`@GetMapping` handles read-only retrieval of resources. It is both **safe** (produces no side effects on the database) and **idempotent**:

```java
@GetMapping
public ResponseEntity<List<ProductResponse>> getAllProducts() {
    return ResponseEntity.ok(productService.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.findById(id));
}
```

---

## Creating Resources with @PostMapping

`@PostMapping` processes client-submitted payloads to create new resources on the server:

```java
@PostMapping
public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
    ProductResponse created = productService.create(request);
    
    // Construct the canonical URI for the newly created resource
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(created.id())
            .toUri();

    // Return 201 Created with Location header and response body
    return ResponseEntity.created(location).body(created);
}
```

---

## Using ResponseEntity with HTTP Status Codes (200 vs 201)

| HTTP Verb | Operation | Standard Status | ResponseEntity Factory Method |
| :--- | :--- | :--- | :--- |
| `GET` | Successful resource retrieval | `200 OK` | `ResponseEntity.ok(...)` |
| `POST` | Successful resource creation | `201 Created` | `ResponseEntity.created(uri).body(...)` |
| `GET / POST` | Empty response | `204 No Content` | `ResponseEntity.noContent().build()` |

---

## End-to-End Example with DTOs

### Product Request & Response DTOs:
```java
public record CreateProductRequest(
    @NotBlank(message = "Product name is required")
    String name,
    
    @Positive(message = "Price must be greater than zero")
    BigDecimal price
) {}

public record ProductResponse(
    Long id,
    String name,
    BigDecimal price,
    LocalDateTime createdAt
) {}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Deep Dive into @RequestMapping](../03-request-mapping/README.md) | [📚 Module Index](../README.md) | [Working with @PutMapping & @DeleteMapping →](../05-put-and-delete-mapping/README.md) |
