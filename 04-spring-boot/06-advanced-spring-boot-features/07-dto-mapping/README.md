# មេរៀនទី ៧: ការបម្លែងទិន្នន័យ DTO ជាមួយ MapStruct និង ModelMapper (DTO Mapping Patterns)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../06-transaction-management/README.md) | [មេរៀនបន្ទាប់ →](../../07-microservices-with-spring-boot/01-microservices-step-by-step-guide/README.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Java 17 Records DTOs & Mapping](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`CreateBookRequest.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/dto/CreateBookRequest.java) | [`BookResponse.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/dto/BookResponse.java) | [`BookService.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/service/BookService.java)


---

## មាតិកា (Table of Contents)
1. [ហេតុអ្វីត្រូវប្រើ Data Transfer Object (DTO)?](#ហេតុអ្វីត្រូវប្រើ-dto)
2. [វិធីសាស្រ្តបម្លែងទិន្នន័យ (Manual vs Reflection vs Compile-Time)](#វិធីសាស្រ្តបម្លែងទិន្នន័យ)
3. [ការប្រើប្រាស់ Java 17+ Records ជា DTOs](#ការប្រើប្រាស់-java-records)
4. [ការប្រើប្រាស់ MapStruct សម្រាប់ High-Performance Mapping](#ការប្រើប្រាស់-mapstruct)
5. [ការគ្រប់គ្រង Nested Objects និង Custom Mapping Logic](#ការគ្រប់គ្រង-nested-objects)
6. [សង្ខេប](#សង្ខេប)

---

## ហេតុអ្វីត្រូវប្រើ DTO?
ការ return JPA Entity ដោយផ្ទាល់ទៅកាន់ REST API Response គឺជាការអនុវត្តមិនល្អ (Anti-pattern) ព្រោះ៖
1. **បញ្ហា Security**: អាចនឹងលេចធ្លាយទិន្នន័យសម្ងាត់ (ដូចជា password hash, internal flags)។
2. **បញ្ហា Jackson Infinite Recursion**: ទំនាក់ទំនងទ្វេទិស (`@OneToMany`, `@ManyToOne`) នឹងបង្កឱ្យមាន StackOverflowError។
3. **Over-fetching**: បញ្ជូនទិន្នន័យលើសតម្រូវការរបស់ Client។

```mermaid
graph LR
    A["Database Entity<br/>(User Entity)"] -->|MapStruct Mapper| B["Client DTO Record<br/>(UserResponseDTO)"]
    B -->|Jackson Serializer| C["JSON Output to Client"]

```

---

## ការប្រើប្រាស់ MapStruct (Compile-Time Code Generator)

**MapStruct** បង្កើត Java Code បម្លែងទិន្នន័យនៅពេល Compile time (គ្មាន Reflection Overhead ឡើយ លឿនដូចសរសេរកូដដោយដៃ)។

### Maven Setup:
```xml
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.5.5.Final</version>

</dependency>
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.5.5.Final</version>
    <scope>provided</scope>

</dependency>
```

---

## ការបង្កើត Mapper Interface

```java
package com.example.mapper;

import com.example.dto.CreateUserRequest;
import com.example.dto.UserResponse;
import com.example.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // បម្លែងពី Entity ទៅ Response DTO
    @Mapping(target = "fullName", expression = "java(user.getFirstName() + ' ' + user.getLastName())")
    UserResponse toDto(User user);

    // បម្លែងពី Request DTO ទៅ Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toEntity(CreateUserRequest request);
}
```

---

## ការប្រើប្រាស់ក្នុង Service Layer

```java
@Service
public class UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(CreateUserRequest req) {
        User user = userMapper.toEntity(req);
        User saved = userRepo.save(user);
        return userMapper.toDto(saved);
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការគ្រប់គ្រង Transaction ជាមួយ @Transactional (Declarative Transaction Management)](../06-transaction-management/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [មគ្គុទ្ទេសក៍បង្កើត Microservices មួយជំហានម្តងៗ (Microservices Step-by-Step Guide) →](../../07-microservices-with-spring-boot/01-microservices-step-by-step-guide/README.md) |
