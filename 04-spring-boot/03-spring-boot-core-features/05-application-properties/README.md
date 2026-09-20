# Lesson 5: Managing Configuration with Application Properties

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../04-dependency-management/README.md) | [Next Lesson →](../06-yaml-configuration/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore Application Configuration](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`application.yml`](../../examples/01-rest-api-crud/src/main/resources/application.yml) | [`pom.xml`](../../examples/01-rest-api-crud/pom.xml)


## Table of Contents

- [1. Configuration Management in Spring Boot](#1-configuration-management-in-spring-boot)
- [2. Comparison: `application.properties` vs. `application.yml`](#2-comparison-applicationproperties-vs-applicationyml)
- [3. Pattern 1: Value Injection with `@Value`](#3-pattern-1-value-injection-with-value)
- [4. Pattern 2: Type-Safe Binding with `@ConfigurationProperties`](#4-pattern-2-type-safe-binding-with-configurationproperties)
- [5. Environment Isolation with Profiles](#5-environment-isolation-with-profiles)

---

## 1. Configuration Management in Spring Boot

In Spring Boot, external application settings (server ports, datasource credentials, timeout thresholds, API tokens) reside in `src/main/resources/` within `application.properties` or `application.yml`.

Spring Boot supports externalized configuration, allowing the same application artifact to adapt across different deployment environments without recompiling source code.

---

## 2. Comparison: `application.properties` vs. `application.yml`

| `application.properties` (Flat key-value format) | `application.yml` (Hierarchical YAML) |
| :--- | :--- |
| ```properties<br>server.port=8080<br>spring.datasource.url=jdbc:postgresql://localhost:5432/mydb<br>spring.datasource.username=postgres<br>spring.datasource.password=secret<br>``` | ```yaml<br>server:<br>  port: 8080<br>spring:<br>  datasource:<br>    url: jdbc:postgresql://localhost:5432/mydb<br>    username: postgres<br>    password: secret<br>``` |

**Why engineers prefer YAML:**
- Natural visual nesting prevents repetitive prefix typing
- Native support for ordered lists and structured data objects

---

## 3. Pattern 1: Value Injection with `@Value`

Direct injection of individual configuration values into Spring Beans:

```java
@Service
public class PaymentGatewayService {

    // Injects property with a fallback default value of 30
    @Value("${payment.timeout:30}")
    private int timeoutSeconds;

    @Value("${payment.api-key}")
    private String apiKey;

    public void process() {
        System.out.println("Timeout: " + timeoutSeconds + ", Key: " + apiKey);
    }
}
```

---

## 4. Pattern 2: Type-Safe Binding with `@ConfigurationProperties`

For structured, multi-field configurations, use type-safe binding into POJOs or **Java 17+ Records**:

```yaml
# application.yml
app:
  jwt:
    secret: my-ultra-secure-secret-key-32bytes
    expiration-hours: 24
```

```java
// Immutable, type-safe configuration record
@ConfigurationProperties(prefix = "app.jwt")
public record JwtProperties(String secret, int expirationHours) {}
```

```java
@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtProperties jwtProperties;

    public void generateToken() {
        System.out.println("Configured secret: " + jwtProperties.secret());
    }
}
```

---

## 5. Environment Isolation with Profiles

Segregate environments via dedicated profile configurations:
- `application-dev.yml` (local development with in-memory H2)
- `application-prod.yml` (production cloud database)

### Activating Profiles
```yaml
# application.yml
spring:
  profiles:
    active: dev
```

Or pass at runtime via environment variables or CLI arguments:
```bash
java -jar -Dspring.profiles.active=prod app.jar
```

---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Starter Dependencies and Dependency Management](../04-dependency-management/README.md) | [📚 Module Index](../README.md) | [Configuration with YAML in Spring Boot →](../06-yaml-configuration/README.md) |
