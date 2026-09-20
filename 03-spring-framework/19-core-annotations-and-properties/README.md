# Part 19: Core Annotations & Environment Properties

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)
> 
> 📖 **Official Spring Documentation:** [Environment Abstraction](https://docs.spring.io/spring-framework/reference/core/beans/environment.html) | [Annotation-based Container Configuration](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config.html)

![Core Annotations & Properties](./assets/core-annotations-properties.svg "Core Annotations & Environment Properties")

## Table of Contents

- [1. Reading Configuration with @PropertySource & @Value](#1-reading-configuration-with-propertysource--value)
- [2. Environment Segmentation with @Profile](#2-environment-segmentation-with-profile)
- [3. Deferred Instantiation with @Lazy](#3-deferred-instantiation-with-lazy)
- [4. Deterministic Ordering with @DependsOn and @Order](#4-deterministic-ordering-with-dependson-and-order)
- [5. Conditional Component Registration with @Conditional](#5-conditional-component-registration-with-conditional)
- [6. Practical Code Challenge](#6-practical-code-challenge)
- [🔗 Official Spring Documentation](#-official-spring-documentation)

---

## 1. Reading Configuration with @PropertySource & @Value

Externalizing application settings avoids recompilation across differing environments.

`application.properties`:
```properties
server.port=8080
app.name=OrderService
app.timeout-ms=2500
```

Injecting properties into components:
```java
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {}

@Component
public class ServerSettings {

    @Value("${app.name}")
    private String name;

    @Value("${server.port:8080}") // Fallback default value 8080
    private int port;

    @Value("${app.timeout-ms:1000}")
    private long timeout;
}
```

---

## 2. Environment Segmentation with @Profile

Spring Profiles allow segregating bean definitions to specific target deployment environments (e.g., `dev`, `test`, `prod`):

```java
public interface MessageBroker {
    void publish(String message);
}

@Service
@Profile("dev")
public class LocalInMemoryBroker implements MessageBroker {
    public void publish(String message) {
        System.out.println("[LOCAL] Published to in-memory queue: " + message);
    }
}

@Service
@Profile("prod")
public class CloudAwsSqsBroker implements MessageBroker {
    public void publish(String message) {
        System.out.println("[AWS SQS] Published to cloud queue: " + message);
    }
}
```

Activate via JVM options:
```bash
-Dspring.profiles.active=prod
```

---

## 3. Deferred Instantiation with @Lazy

By default, Singleton beans are eagerly initialized at startup. Annotating a component or bean method with `@Lazy` delays creation until first accessed:

```java
@Component
@Lazy
public class HeavyReportGenerator {
    public HeavyReportGenerator() {
        System.out.println("Initialized on-demand to preserve heap memory!");
    }
}
```

---

## 4. Deterministic Ordering with @DependsOn and @Order

- **`@DependsOn("migrationService")`:** Enforces initialization sequence when dependencies are implicit (not wired via constructor).
- **`@Order(1)`:** Dictates sorting priority when autowiring collections like `List<Handler>` (lower numbers execute first).

---

## 5. Conditional Component Registration with @Conditional

The `@Conditional` annotation is the foundation behind Spring Boot's intelligent auto-configuration:

```java
public class HighMemoryCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Runtime.getRuntime().maxMemory() > 1024 * 1024 * 512;
    }
}

@Bean
@Conditional(HighMemoryCondition.class)
public CacheStore memoryIntensiveCache() {
    return new HighPerformanceMemoryCache();
}
```

---

## 6. Practical Code Challenge

**Challenge:** Create a bean `DatasourceProps` that reads from `db.properties`, injecting `db.host` with a fallback to `localhost`, and activates strictly when the active profile is `"local"`.

<details>
<summary>🔍 Click to view solution</summary>

```java
@Component
@Profile("local")
@PropertySource("classpath:db.properties")
public class DatasourceProps {

    @Value("${db.host:localhost}")
    private String host;

    @Value("${db.port:3306}")
    private int port;

    public String getConnectionString() {
        return host + ":" + port;
    }
}
```
</details>

---

## 🔗 Official Spring Documentation

- [Spring Environment Abstraction](https://docs.spring.io/spring-framework/reference/core/beans/environment.html)
- [Annotation-based Container Configuration](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config.html)
- [Spring Bean Profiles](https://docs.spring.io/spring-framework/reference/core/beans/environment.html#beans-definition-profiles)

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 18: Spring Bean Lifecycle & BeanPostProcessor](../18-bean-lifecycle-and-postprocessor/README.md) | [📚 Spring Framework Index](../README.md) | [Part 20: Spring Expression Language (SpEL) →](../20-spring-expression-language-spel/README.md) |
