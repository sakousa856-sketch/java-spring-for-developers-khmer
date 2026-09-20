# Lesson 3: Auto-Configuration Deep Dive

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../02-spring-boot-annotations/README.md) | [Next Lesson →](../04-dependency-management/README.md)

## Table of Contents

- [1. How Auto-Configuration Operates](#1-how-auto-configuration-operates)
- [2. Anatomy of `@SpringBootApplication`](#2-anatomy-of-springbootapplication)
- [3. Conditional Annotations Matrix](#3-conditional-annotations-matrix)
- [4. Auto-Configuration Registry (Spring Boot 3.x)](#4-auto-configuration-registry-spring-boot-3x)
- [5. Disabling Specific Auto-Configurations](#5-disabling-specific-auto-configurations)

---

## 1. How Auto-Configuration Operates

**Auto-Configuration** is Spring Boot's hallmark feature. It automatically evaluates the application context at startup and configures beans based on:
1. **Classpath content:** E.g., if PostgreSQL driver is present, it registers a `DataSource`.
2. **Configuration properties:** E.g., checking `application.properties`.
3. **Existing Beans:** Evaluating whether the developer already supplied a custom bean.

> **Guiding Principle:** *"Provide sensible defaults out of the box, but back away completely the moment the developer defines their own bean."*

---

## 2. Anatomy of `@SpringBootApplication`

The `@SpringBootApplication` annotation on the primary bootstrap class is a composite **meta-annotation** combining three key annotations:

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootConfiguration     // 1. Indicates the class provides @Bean configuration
@EnableAutoConfiguration     // 2. Activates Spring Boot auto-configuration machinery
@ComponentScan               // 3. Enables component scanning in the current package tree
public @interface SpringBootApplication { ... }
```

---

## 3. Conditional Annotations Matrix

Spring Boot's auto-configuration classes leverage `@Conditional` annotations:

| Conditional Annotation | Evaluation Criterion |
| :--- | :--- |
| **`@ConditionalOnClass`** | Matches if specified classes/JARs are on the classpath |
| **`@ConditionalOnMissingBean`** | Matches **only if no custom bean** of that type exists |
| **`@ConditionalOnProperty`** | Matches if a configuration property matches expected values |
| **`@ConditionalOnWebApplication`** | Matches if the application is running inside a web context |

### Example:
If you supply a custom `@Bean public DataSource dataSource()`, Spring Boot's internal `DataSourceAutoConfiguration` skips its default instantiation because of `@ConditionalOnMissingBean(DataSource.class)`.

---

## 4. Auto-Configuration Registry (Spring Boot 3.x)

- **Spring Boot 2.x:** Registered inside `META-INF/spring.factories`.
- **Spring Boot 3.x:** Relocated to the dedicated descriptor file:
  ```
  META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
  ```
  This file lists all potential auto-configuration classes (such as `DataSourceAutoConfiguration`, `JacksonAutoConfiguration`, `SecurityAutoConfiguration`) evaluated by the engine.

---

## 5. Disabling Specific Auto-Configurations

To prevent a specific auto-configuration from running (e.g., disabling automatic database initialization):

```java
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```


---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Core Spring Boot Annotations](../02-spring-boot-annotations/README.md) | [📚 Module Index](../README.md) | [Starter Dependencies and Dependency Management →](../04-dependency-management/README.md) |
