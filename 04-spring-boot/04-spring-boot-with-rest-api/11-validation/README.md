# Lesson 11: Input Validation with Jakarta Bean Validation

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../10-exception-handling/README.md) | [Next Lesson →](../../05-spring-boot-database-and-data-jpa/01-integration-with-mysql/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore Jakarta Bean Validation](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`CreateBookRequest.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/dto/CreateBookRequest.java) | [`GlobalExceptionHandler.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/exception/GlobalExceptionHandler.java)


## Table of Contents

- [1. Importance of Input Validation](#1-importance-of-input-validation)
- [2. Adding the `spring-boot-starter-validation` Starter](#2-adding-the-spring-boot-starter-validation-starter)
- [3. Core Validation Constraints](#3-core-validation-constraints)
- [4. Comparison: `@NotNull` vs `@NotEmpty` vs `@NotBlank`](#4-comparison-notnull-vs-notempty-vs-notblank)
- [5. Applying Validation to DTOs and Controller `@Valid`](#5-applying-validation-to-dtos-and-controller-valid)
- [6. Customizing Error Messages](#6-customizing-error-messages)
- [7. Summary](#7-summary)

---

## 1. Importance of Input Validation

In enterprise software engineering, never trust input originating from external clients ("Never trust client input"). Proper server-side input validation guarantees:
- Protection of database integrity against corrupt and incomplete records
- Shielding against common injection attack surfaces
- Clear, actionable feedback to API consumers when payloads fail business constraints

---

## 2. Adding the `spring-boot-starter-validation` Starter

Since Spring Boot 2.3+ and continuing in 3.x, Bean Validation is decoupled from the web starter. Include it explicitly in `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

---

## 3. Core Validation Constraints

| Annotation | Description | Example |
| :--- | :--- | :--- |
| **`@NotNull`** | Target property must not be `null` (allows empty strings `""`) | `@NotNull Long categoryId` |
| **`@NotEmpty`** | Target property must not be `null` and length/size > 0 | `@NotEmpty List<String> tags` |
| **`@NotBlank`** | Target string must not be `null`, empty, or pure whitespace (`"   "`) | `@NotBlank String username` |
| **`@Size`** | Constrains character string length or collection cardinality | `@Size(min = 3, max = 50)` |
| **`@Min` / `@Max`** | Constrains numeric boundaries | `@Min(18) int age` |
| **`@Email`** | Enforces valid RFC email formatting syntax | `@Email String email` |
| **`@Pattern`** | Validates text against strict Regular Expressions | `@Pattern(regexp = "^0[0-9]{8,9}$")` |

---

## 4. Comparison: `@NotNull` vs `@NotEmpty` vs `@NotBlank`

This distinction is frequently asked in technical interviews:

| Input Value | `@NotNull` | `@NotEmpty` | `@NotBlank` |
| :--- | :---: | :---: | :---: |
| `null` | ❌ Invalid | ❌ Invalid | ❌ Invalid |
| `""` (Empty String) | ✅ Valid | ❌ Invalid | ❌ Invalid |
| `"   "` (Whitespace) | ✅ Valid | ✅ Valid | ❌ Invalid |
| `"Sophea"` | ✅ Valid | ✅ Valid | ✅ Valid |

> 💡 **Best Practice:** For character strings (names, emails, passwords), consistently prefer **`@NotBlank`** over `@NotNull`!

---

## 5. Applying Validation to DTOs and Controller `@Valid`

### DTO Definition with Validation Annotations:

```java
package com.example.demo.dto;

import jakarta.validation.constraints.*;

public record CreateProductRequest(
        @NotBlank(message = "Product name cannot be blank")
        @Size(min = 2, max = 100, message = "Name length must be between 2 and 100 characters")
        String name,

        @NotNull(message = "Price is mandatory")
        @Positive(message = "Price must be strictly positive")
        Double price,

        @Min(value = 0, message = "Stock quantity cannot be negative")
        int stockQuantity,

        @Email(message = "Supplier email format is invalid")
        String supplierEmail
) {}
```

### Controller Implementation Leveraging `@Valid`:

```java
package com.example.demo.controller;

import com.example.demo.dto.CreateProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody CreateProductRequest request) {
        // If validation fails, Spring Boot intercepts the execution,
        // raises MethodArgumentNotValidException, and prevents code from proceeding to the service layer.
        
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body("Product " + request.name() + " saved successfully!");
    }
}
```

---

## 6. Customizing Error Messages

Custom validation messages can be defined inline via the `message = "..."` attribute or managed centrally using an external `ValidationMessages.properties` resource bundle for internationalization (i18n).

When clients submit invalid payloads, Spring Boot rejects the request with HTTP `400 Bad Request`. In the upcoming lesson (Part 11), we build a centralized Global Exception Handler to transform these errors into clean, structured JSON payloads.

---

## 7. Summary

- Integrate `spring-boot-starter-validation` to leverage the Jakarta Validation reference implementation (Hibernate Validator).
- Choose the correct constraint: `@NotBlank` for strings, `@NotNull` for objects, and `@Positive`/`@Min` for numeric types.
- Annotate handler parameters with `@Valid` to enforce declarative request validation before controller logic executes.

---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Robust Global Exception Handling with @RestControllerAdvice](../10-exception-handling/README.md) | [📚 Module Index](../README.md) | [Spring Boot Integration with MySQL Database →](../../05-spring-boot-database-and-data-jpa/01-integration-with-mysql/README.md) |
