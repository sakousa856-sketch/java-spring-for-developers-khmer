# មេរៀនទី ១១: ការផ្ទៀងផ្ទាត់ទិន្នន័យ (Input Validation) ជាមួយ Jakarta Bean Validation
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../10-exception-handling/README.md) | [មេរៀនបន្ទាប់ →](../../05-spring-boot-database-and-data-jpa/01-integration-with-mysql/README.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore Jakarta Bean Validation](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`CreateBookRequest.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/dto/CreateBookRequest.java) | [`GlobalExceptionHandler.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/exception/GlobalExceptionHandler.java)


## មាតិកា (Table of Contents)

- [1. សារៈសំខាន់នៃការផ្ទៀងផ្ទាត់ទិន្នន័យ (Validation)](#1-សារៈសំខាន់នៃការផ្ទៀងផ្ទាត់ទិន្នន័យ-validation)
- [2. ការដំឡើង Dependency `spring-boot-starter-validation`](#2-ការដំឡើង-dependency-spring-boot-starter-validation)
- [3. Validation Annotations សំខាន់ៗបំផុត](#3-validation-annotations-សំខាន់ៗបំផុត)
- [4. ភាពខុសគ្នារវាង `@NotNull`, `@NotEmpty`, និង `@NotBlank`](#4-ភាពខុសគ្នារវាង-notnull-notempty-និង-notblank)
- [5. ការអនុវត្ត Validation លើ DTO និង `@Valid` ក្នុង Controller](#5-ការអនុវត្ត-validation-លើ-dto-និង-valid-ក្នុង-controller)
- [6. ការប្ដូរសារជូនដំណឹងកំហុស (Custom Error Messages)](#6-ការប្ដូរសារជូនដំណឹងកំហុស-custom-error-messages)
- [7. សង្ខេប](#7-សង្ខេប)

---

## 1. សារៈសំខាន់នៃការផ្ទៀងផ្ទាត់ទិន្នន័យ (Validation)

នៅក្នុងការសរសេរកម្មវិធីកម្រិត Enterprise យើងមិនត្រូវទុកចិត្តទិន្នន័យដែលផ្ញើមកពី Client ដាច់ខាត (Never trust client input)។ ការផ្ទៀងផ្ទាត់ទិន្នន័យត្រឹមត្រូវជួយ៖
- ការពារកុំឱ្យទិន្នន័យខូចចូលទៅក្នុង Database (Data Integrity)
- ការពារបញ្ហាសុវត្ថិភាពដូចជា Injection Attacks
- ផ្តល់សារឆ្លើយតបច្បាស់លាស់ដល់ User ពេលពួកគេបំពេញ Form ខុស (Good User Experience)

---

## 2. ការដំឡើង Dependency `spring-boot-starter-validation`

ចាប់តាំងពី Spring Boot 2.3+ និង 3.x មក Validation មិនត្រូវបានបង្កប់ដោយស្វ័យប្រវត្តិក្នង Web Starter ទៀតទេ។ យើងត្រូវបញ្ចូលវាក្នុង `pom.xml`៖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>

</dependency>
```

---

## 3. Validation Annotations សំខាន់ៗបំផុត

| Annotation | ការពន្យល់ | ឧទាហរណ៍ |
| :--- | :--- | :--- |
| **`@NotNull`** | តម្លៃមិនត្រូវ `null` (តែអាចជា string ទទេ `""` បាន) | `@NotNull Long categoryId` |
| **`@NotEmpty`** | មិន `null` ហើយប្រវែង (length/size) ធំជាង ០ | `@NotEmpty List<String> tags` |

| **`@NotBlank`** | មិន `null`, មិនទទេ, ហើយមិនមែនជា Whitespace សុទ្ធ (`"   "`) | `@NotBlank String username` |
| **`@Size`** | កំណត់ប្រវែងអក្សរ Min/Max ឬទំហំ List | `@Size(min = 3, max = 50)` |
| **`@Min` / `@Max`** | កំណត់តម្លៃលេខអប្បបរមា និងអតិបរមា | `@Min(18) int age` |
| **`@Email`** | ផ្ទៀងផ្ទាត់ទម្រង់អ៊ីមែលឱ្យត្រូវតាមស្តង់ដារ | `@Email String email` |
| **`@Pattern`** | ផ្ទៀងផ្ទាត់ទម្រង់អក្សរតាម Regular Expression (Regex) | `@Pattern(regexp = "^0[0-9]{8,9}$")` (លេខទូរស័ព្ទ) |

---

## 4. ភាពខុសគ្នារវាង `@NotNull`, `@NotEmpty`, និង `@NotBlank`

នេះជាចំណុចដែលគេតែងសួរក្នុងសម្ភាសន៍ការងារ (Interview Question)៖

| តម្លៃ (Input Value) | `@NotNull` | `@NotEmpty` | `@NotBlank` |
| :--- | :---: | :---: | :---: |
| `null` | ❌ Invalid | ❌ Invalid | ❌ Invalid |
| `""` (Empty String) | ✅ Valid | ❌ Invalid | ❌ Invalid |
| `"   "` (Whitespace) | ✅ Valid | ✅ Valid | ❌ Invalid |
| `"Sophea"` | ✅ Valid | ✅ Valid | ✅ Valid |

> 💡 **Best Practice:** សម្រាប់ String Text (ឈ្មោះ, អ៊ីមែល, លេខសម្ងាត់) ត្រូវប្រើ **`@NotBlank`** ជានិច្ច!

---

## 5. ការអនុវត្ត Validation លើ DTO និង `@Valid` ក្នុង Controller

### កូដ DTO ជាមួយ Validation Constraints៖

```java
package com.example.demo.dto;

import jakarta.validation.constraints.*;

public record CreateProductRequest(
        @NotBlank(message = "ឈ្មោះផលិតផលមិនអាចទទេបានទេ")
        @Size(min = 2, max = 100, message = "ឈ្មោះត្រូវតែមានចន្លោះពី ២ ទៅ ១០០ តួអក្សរ")
        String name,

        @NotNull(message = "តម្លៃផលិតផលត្រូវតែបញ្ជាក់")
        @Positive(message = "តម្លៃផលិតផលត្រូវតែធំជាងសូន្យ")
        Double price,

        @Min(value = 0, message = "ចំនួនក្នុងស្តុកមិនអាចជាលេខអវិជ្ជមានឡើយ")
        int stockQuantity,

        @Email(message = "ទម្រង់អ៊ីមែលរបស់អ្នកផ្គត់ផ្គង់មិនត្រឹមត្រូវឡើយ")
        String supplierEmail
) {}
```

### កូដ Controller ដោយប្រើ `@Valid`៖

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
        // ប្រសិនបើ Request មិនឆ្លងកាត់ Validation ទេ 
        // នោះ Spring Boot នឹងបោះ MethodArgumentNotValidException ដោយស្វ័យប្រវត្តិ
        // ហើយបញ្ឈប់ Code ត្រឹមនេះ (មិនអនុញ្ញាតឱ្យចូល Service ឡើយ)
        
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body("ផលិតផល " + request.name() + " ត្រូវបានរក្សាទុកដោយជោគជ័យ!");
    }
}
```

---

## 6. ការប្ដូរសារជូនដំណឹងកំហុស (Custom Error Messages)

យើងអាចសរសេរសារជាភាសាខ្មែរ ឬភាសាអង់គ្លេសតាមរយៈ Attribute `message = "..."` នៅក្នុង Annotation ផ្ទាល់ ដូចដែលបានបង្ហាញខាងលើ។

នៅពេល Client បញ្ចូលទិន្នន័យខុស (ឧទាហរណ៍ `name: ""` និង `price: -10`) នោះ Spring Boot នឹងឆ្លើយតបមកវិញនូវកំហុស HTTP `400 Bad Request`។ នៅក្នុងមេរៀនបន្ទាប់ (Part 11) យើងនឹងរៀនចាប់ Exception នេះ ដើម្បីបម្លែង Response Error ឱ្យចេញជា JSON ស្អាត!

---

## 7. សង្ខេប

- បញ្ចូល `spring-boot-starter-validation` ក្នុង `pom.xml` ដើម្បីប្រើ Jakarta Validation API។
- ប្រើ `@NotBlank` សម្រាប់ String, `@NotNull` សម្រាប់ Objects/IDs, និង `@Positive` ឬ `@Min` សម្រាប់លេខ។
- ដាក់ `@Valid` នៅពីមុខ `@RequestBody` ក្នុង Controller ដើម្បីឱ្យ Spring ដំណើរការត្រួតពិនិត្យ។

---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការគ្រប់គ្រង Exception ជាសកល (Global Exception Handling) ជាមួយ @RestControllerAdvice](../10-exception-handling/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការតភ្ជាប់ Spring Boot ជាមួយ MySQL Database →](../../05-spring-boot-database-and-data-jpa/01-integration-with-mysql/README.md) |
