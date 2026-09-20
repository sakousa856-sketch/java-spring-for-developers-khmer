# មេរៀនទី ២: ការយល់ដឹងស៊ីជម្រៅអំពី Dependency Injection (DI)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../01-inversion-of-control/README.md) | [មេរៀនបន្ទាប់ →](../03-beanfactory-vs-applicationcontext/README.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore REST API (Constructor Injection)](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`BookService.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/service/BookService.java)


## មាតិកា (Table of Contents)

- [1. តើ Dependency Injection (DI) ជាអ្វី?](#1-តើ-dependency-injection-di-ជាអ្វី)
- [2. ប្រភេទទាំង ៣ នៃ Dependency Injection](#2-ប្រភេទទាំង-៣-នៃ-dependency-injection)
- [3. ហេតុអ្វីបានជា Constructor Injection ជា Best Practice?](#3-ហេតុអ្វីបានជា-constructor-injection-ជា-best-practice)
- [4. កូដគំរូជាក់ស្តែង Spring Boot](#4-កូដគំរូជាក់ស្តែង-spring-boot)
- [5. សង្ខេប](#5-សង្ខេប)

---

## 1. តើ Dependency Injection (DI) ជាអ្វី?

**Dependency Injection (DI)** គឺជាទម្រង់អនុវត្តជាក់ស្តែង (Pattern) នៃគោលការណ៍ IoC។ "Dependency" សំដៅលើ Object មួយដែល Class របស់យើងត្រូវការប្រើ ចំណែក "Injection" គឺការបញ្ជូន Object នោះមកឱ្យពីខាងក្រៅ។

---

## 2. ប្រភេទទាំង ៣ នៃ Dependency Injection

| ប្រភេទ (Type) | វិធីអនុវត្ត | ការវាយតម្លៃ |
| :--- | :--- | :--- |
| **1. Constructor Injection** | ចាក់បញ្ចូលតាមរយៈ Constructor Parameters | ⭐⭐⭐⭐⭐ **(Best Practice ស្តង់ដារ)** |
| **2. Setter Injection** | ចាក់បញ្ចូលតាមរយៈ Setter Method (`setRepository(...)`) | ⭐⭐⭐ (សម្រាប់តែ Optional Dependencies) |
| **3. Field Injection** | ចាក់បញ្ចូលផ្ទាល់លើ Field តាមរយៈ `@Autowired` | ⚠️ **(ចៀសវាង - Bad Practice)** |

---

## 3. ហេតុអ្វីបានជា Constructor Injection ជា Best Practice?

1. **Immutability:** យើងអាចដាក់ពាក្យគន្លឹះ `final` នៅលើ Field បាន ដែលធានាថា Object មិនអាចផ្លាស់ប្តូរបានក្រោយពេលកើត (Thread-safe)។
2. **Easy Unit Testing:** ពេលសរសេរ Unit Test យើងអាចបង្កើត Object ធម្មតា `new OrderService(mockRepo)` ដោយមិនបាច់ពឹងលើ Spring Container ឬ Reflection ឡើយ។
3. **Compile-time Safety:** បើសិនភ្លេច Inject នោះ Compiler នឹងបោះ Error ភ្លាម មិនបណ្តោយឱ្យធ្លាក់ `NullPointerException` ពេល Runtime ឡើយ។

---

## 4. កូដគំរូជាក់ស្តែង Spring Boot

```java
package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 1. ប្រកាសជា final ដើម្បីភាព Immutability
    private final UserRepository userRepository;

    // 2. Constructor Injection (ចាប់ពី Spring 4.3+ មិនបាច់ដាក់ @Autowired ក៏បាន)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(Long id) {
        return userRepository.findById(id).map(User::getName).orElse("Unknown");
    }
}
```

---

## 5. សង្ខេប

- DI គឺជាបច្ចេកទេសបញ្ជូន Dependencies ពីខាងក្រៅចូលមកក្នុង Class។
- ប្រើប្រាស់ **Constructor Injection** ជានិច្ច ជាមួយ `private final` fields។

---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការយល់ដឹងអំពី Inversion of Control (IoC)](../01-inversion-of-control/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការប្រៀបធៀប BeanFactory vs ApplicationContext →](../03-beanfactory-vs-applicationcontext/README.md) |
