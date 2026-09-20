# មេរៀនទី ៥: ការប្រើប្រាស់ @PutMapping និង @DeleteMapping (Working with @PutMapping & @DeleteMapping)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../04-get-and-post-mapping/README.md) | [មេរៀនបន្ទាប់ →](../06-pathvariable-and-requestparam/README.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore REST API (@PutMapping & @DeleteMapping)](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`BookService.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/service/BookService.java)


---

## មាតិកា (Table of Contents)
1. [គោលបំណងនៃ @PutMapping និង @DeleteMapping](#គោលបំណងនៃ-putmapping-និង-deletemapping)
2. [PUT vs PATCH (Full Update vs Partial Update)](#put-vs-patch-full-update-vs-partial-update)
3. [ការអនុវត្ត @PutMapping ជាក់ស្តែង](#ការអនុវត្ត-putmapping-ជាក់ស្តែង)
4. [ការអនុវត្ត @DeleteMapping ជាក់ស្តែង](#ការអនុវត្ត-deletemapping-ជាក់ស្តែង)
5. [Idempotency នៅក្នុង REST APIs](#idempotency-នៅក្នុង-rest-apis)
6. [សង្ខេប](#សង្ខេប)

---

## គោលបំណងនៃ @PutMapping និង @DeleteMapping
- `@PutMapping`: ប្រើសម្រាប់កែប្រែ ឬជំនួស Resource ដែលមានស្រាប់ទាំងមូល (Replace Existing Resource)។
- `@DeleteMapping`: ប្រើសម្រាប់លុប Resource ចេញពីប្រព័ន្ធ។

---

## PUT vs PATCH (Full Update vs Partial Update)

| លក្ខណៈ | PUT (`@PutMapping`) | PATCH (`@PatchMapping`) |
| :--- | :--- | :--- |
| **វិសាលភាព** | ជំនួសទិន្នន័យ Entity ទាំងមូល | កែប្រែតែវាល (fields) មួយចំនួនដែលផ្ញើមក |
| **Fields អវត្តមាន** | អាចនឹងត្រូវ Reset ទៅជា null ឬ default | រក្សាតម្លៃចាស់ដដែល |
| **Idempotency** | Idempotent (ហៅប៉ុន្មានដងក៏លទ្ធផលដដែល) | អាច Idempotent ឬ Not Idempotent |

---

## ការអនុវត្ត @PutMapping ជាក់ស្តែង

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

## ការអនុវត្ត @DeleteMapping ជាក់ស្តែង

```java
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
    
    // បញ្ជូន 204 No Content បញ្ជាក់ថាការលុបបានជោគជ័យ
    return ResponseEntity.noContent().build();
}
```

---

## Idempotency នៅក្នុង REST APIs
**Idempotent** មានន័យថា ប្រតិបត្តិការមួយ ប្រសិនបើដំណើរការ ១ ដង ឬ ១០០ ដង ស្ថានភាពចុងក្រោយនៅលើ Server គឺដូចគ្នាទាំងស្រុង៖
- `GET`, `PUT`, `DELETE` គឺជា **Idempotent**។
- `POST` គឺ **Non-idempotent** (ហៅ ៥ ដង បង្កើត ៥ Records ផ្សេងគ្នា)។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ @GetMapping និង @PostMapping (Mastering @GetMapping & @PostMapping)](../04-get-and-post-mapping/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការគ្រប់គ្រងទិន្នន័យ Input ជាមួយ @PathVariable និង @RequestParam →](../06-pathvariable-and-requestparam/README.md) |
