# មេរៀនទី ៤: ការប្រើប្រាស់ @GetMapping និង @PostMapping (Mastering @GetMapping & @PostMapping)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../03-request-mapping/README.md) | [មេរៀនបន្ទាប់ →](../05-put-and-delete-mapping/README.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore REST API (@GetMapping & @PostMapping)](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`CreateBookRequest.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/dto/CreateBookRequest.java)


---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើមអំពី Composed Request Mappings](#សេចក្តីផ្តើមអំពី-composed-request-mappings)
2. [ការប្រើប្រាស់ @GetMapping សម្រាប់ទាញយកទិន្នន័យ](#ការប្រើប្រាស់-getmapping-សម្រាប់ទាញយកទិន្នន័យ)
3. [ការប្រើប្រាស់ @PostMapping សម្រាប់បង្កើត Resource ថ្មី](#ការប្រើប្រាស់-postmapping-សម្រាប់បង្កើត-resource-ថ្មី)
4. [ការប្រើប្រាស់ ResponseEntity ជាមួយ Status Codes (200 vs 201)](#ការប្រើប្រាស់-responseentity-ជាមួយ-status-codes-200-vs-201)
5. [ឧទាហរណ៍ជាក់ស្តែងជាមួយ DTO](#ឧទាហរណ៍ជាក់ស្តែងជាមួយ-dto)
6. [សង្ខេប](#សង្ខេប)

---

## សេចក្តីផ្តើមអំពី Composed Request Mappings
នៅក្នុង Spring 4.3+, `@GetMapping` និង `@PostMapping` គឺជា Composed Annotations ដែលដើរតួជា Shortcut ជំនួស `@RequestMapping(method = RequestMethod.GET)` និង `@RequestMapping(method = RequestMethod.POST)` ដើម្បីឱ្យកូដមានភាពខ្លី ស្អាត និងងាយស្រួលយល់។

---

## ការប្រើប្រាស់ @GetMapping សម្រាប់ទាញយកទិន្នន័យ

`@GetMapping` ប្រើសម្រាប់ទាញយកទិន្នន័យពី Server ដោយគ្មានការផ្លាស់ប្តូរស្ថានភាព (State) របស់ Database ឡើយ (Safe & Idempotent)៖

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

## ការប្រើប្រាស់ @PostMapping សម្រាប់បង្កើត Resource ថ្មី

`@PostMapping` ប្រើប្រាស់សម្រាប់បង្កើត Resource ថ្មីនៅលើ Server ដោយទទួលទិន្នន័យពី HTTP Request Body៖

```java
@PostMapping
public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
    ProductResponse created = productService.create(request);
    
    // បង្កើត URI Location ទៅកាន់ Resource ថ្មី
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(created.id())
            .toUri();

    // ឆ្លើយតបជាមួយ HTTP Status 201 Created និង Header Location
    return ResponseEntity.created(location).body(created);
}
```

---

## ការប្រើប្រាស់ ResponseEntity ជាមួយ Status Codes (200 vs 201)

| HTTP Method | ប្រតិបត្តិការ | Status Code ស្តង់ដារ | ResponseEntity Method |
| :--- | :--- | :--- | :--- |
| `GET` | ជោគជ័យក្នុងការទាញយកទិន្នន័យ | `200 OK` | `ResponseEntity.ok(...)` |
| `POST` | ជោគជ័យក្នុងការបង្កើត Resource ថ្មី | `201 Created` | `ResponseEntity.created(uri).body(...)` |
| `GET / POST` | មិនមាន Content ឆ្លើយតប | `204 No Content` | `ResponseEntity.noContent().build()` |

---

## ឧទាហរណ៍ជាក់ស្តែងជាមួយ DTO

### Product DTOs:
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

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ @RequestMapping (Deep Dive into @RequestMapping)](../03-request-mapping/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការប្រើប្រាស់ @PutMapping និង @DeleteMapping (Working with @PutMapping & @DeleteMapping) →](../05-put-and-delete-mapping/README.md) |
