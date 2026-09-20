# Lesson 5: Working with @PutMapping & @DeleteMapping

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../04-get-and-post-mapping/README.md) | [Next Lesson →](../06-pathvariable-and-requestparam/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore REST API (@PutMapping & @DeleteMapping)](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`BookService.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/service/BookService.java)


---

## Table of Contents
1. [Core Concepts of @PutMapping and @DeleteMapping](#core-concepts-of-putmapping-and-deletemapping)
2. [PUT vs PATCH (Full Update vs Partial Update)](#put-vs-patch-full-update-vs-partial-update)
3. [Implementing @PutMapping](#implementing-putmapping)
4. [Implementing @DeleteMapping](#implementing-deletemapping)
5. [Understanding Idempotency in REST APIs](#understanding-idempotency-in-rest-apis)
6. [Summary](#summary)

---

## Core Concepts of @PutMapping and @DeleteMapping
- `@PutMapping`: Maps HTTP PUT requests to completely replace or update an existing resource.
- `@DeleteMapping`: Maps HTTP DELETE requests to remove a resource from the server.

---

## PUT vs PATCH (Full Update vs Partial Update)

| Feature | PUT (`@PutMapping`) | PATCH (`@PatchMapping`) |
| :--- | :--- | :--- |
| **Scope** | Complete resource replacement | Targeted partial modification |
| **Missing Fields** | Reset to defaults/null | Preserved as-is |
| **Idempotency** | Strictly Idempotent | Usually Idempotent (context-dependent) |

---

## Implementing @PutMapping

```java
@PutMapping("/{id}")
public ResponseEntity<UserResponse> updateUser(
        @PathVariable Long id,
        @Valid @RequestBody UpdateUserRequest request) {
    
    UserResponse updated = userService.update(id, request);
    return ResponseEntity.ok(updated);
}
```

---

## Implementing @DeleteMapping

```java
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
    
    // Standard response: 204 No Content
    return ResponseEntity.noContent().build();
}
```

---

## Understanding Idempotency in REST APIs
An HTTP method is **idempotent** if making identical multiple requests produces the exact same server-side state as a single request:
- `GET`, `PUT`, `DELETE` are **idempotent**.
- `POST` is **non-idempotent** (invoking it repeatedly will create duplicate entries).

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Mastering @GetMapping & @PostMapping](../04-get-and-post-mapping/README.md) | [📚 Module Index](../README.md) | [Handling Input with @PathVariable and @RequestParam →](../06-pathvariable-and-requestparam/README.md) |
