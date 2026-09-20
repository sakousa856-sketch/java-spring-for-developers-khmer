# Part 9: 3 Ways to Configure Spring

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![3 Ways to Configure Spring](./assets/how-many-ways-are-there-to-configure-the-spring.jpg "How many ways are there to configure the Spring")

## Table of Contents

- [1. Overview of Configuration Approaches](#1-overview-of-configuration-approaches)
- [2. Approach 1: XML-Based Configuration](#2-approach-1-xml-based-configuration)
- [3. Approach 2: Java-Based Configuration](#3-approach-2-java-based-configuration)
- [4. Approach 3: Annotation-Based Configuration](#4-approach-3-annotation-based-configuration)
- [5. Comparison Table](#5-comparison-table)

---

## 1. Overview of Configuration Approaches

In the **Spring Framework**, developers have three primary mechanisms to supply metadata to the IoC Container:

1. **XML-Based Configuration** (The legacy declarative approach)
2. **Java-Based Configuration** (Type-safe configuration classes)
3. **Annotation-Based Configuration** (Automatic component scanning)

---

## 2. Approach 1: XML-Based Configuration

Beans and dependencies are defined in standalone XML files:

```xml
<beans>
    <bean id="accountService" class="com.example.service.AccountServiceImpl">
        <property name="accountRepository" ref="accountRepository"/>
    </bean>
    <bean id="accountRepository" class="com.example.repository.AccountRepositoryImpl"/>
</beans>
```

- **Pros:** Total separation of configuration from Java source code; can be altered without recompilation.
- **Cons:** No compile-time type safety; verbose; prone to runtime errors due to XML typos.

---

## 3. Approach 2: Java-Based Configuration

Employs pure Java classes annotated with `@Configuration`, with individual bean factory methods marked with `@Bean`:

```java
@Configuration
public class AppConfig {

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepositoryImpl();
    }

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl(accountRepository());
    }
}
```

- **Pros:** Full **compile-time type safety**, easy IDE refactoring, ability to execute conditional logic when instantiating beans.
- **Best Use Case:** Configuring third-party libraries (e.g., configuring an AWS S3 client, `RestTemplate`, or `ObjectMapper`) where you cannot add annotations directly to source code.

---

## 4. Approach 3: Annotation-Based Configuration

The dominant paradigm in **Spring Boot**. Classes are marked with **stereotype annotations**, and the container automatically discovers and registers them via classpath component scanning:

```java
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    // Database logic
}

@Service
public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
```

- **Core Stereotype Annotations:**
  - `@Component`: Generic stereotype for any Spring-managed component.
  - `@Service`: Marks business logic layer.
  - `@Repository`: Marks data access layer and enables exception translation.
  - `@Controller` / `@RestController`: Marks web presentation and REST endpoints.

---

## 5. Comparison Table

| Dimension | XML-Based | Java-Based (`@Configuration`) | Annotation-Based (`@Component`) |
| :--- | :--- | :--- | :--- |
| **Type Safety** | ❌ None (Strings) | ✅ Full (Compile-time) | ✅ High |
| **Development Speed** | Slow | Moderate | **Fastest** |
| **Third-Party Beans** | Supported | **Recommended** | Not possible |
| **Modern Usage** | Rare (Legacy) | Common for Config | **Dominant (Spring Boot standard)** |

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 8: Spring Configuration File](../08-spring-configuration-file/README.md) | [📚 Spring Framework Index](../README.md) | [Part 10: What Is a Spring Bean? →](../10-what-is-a-spring-bean/README.md) |
