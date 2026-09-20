# Lesson 10: Build Tools in Spring: Maven and Gradle

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../09-dispatcherservlet/README.md) | [Next Lesson →](../../03-spring-boot-core-features/01-spring-boot-architecture/README.md)

## Table of Contents

- [1. What is a Build Automation Tool?](#1-what-is-a-build-automation-tool)
- [2. Apache Maven vs Gradle Comparison](#2-apache-maven-vs-gradle-comparison)
- [3. Maven `pom.xml` Configuration](#3-maven-pomxml-configuration)
- [4. Gradle `build.gradle` Configuration](#4-gradle-buildgradle-configuration)
- [5. Summary](#5-summary)

---

## 1. What is a Build Automation Tool?

Build automation tools orchestrate the software release pipeline:
- Resolving transitive third-party dependencies from remote artifact repositories
- Compiling Java source into JVM bytecode
- Executing test suites
- Packaging artifacts into standalone executable JARs or WARs

---

## 2. Apache Maven vs Gradle Comparison

| Criteria | Apache Maven | Gradle |
| :--- | :--- | :--- |
| **Configuration DSL** | Declarative XML (`pom.xml`) | Groovy or Kotlin DSL (`build.gradle.kts`) |
| **Build Performance** | Standard linear execution | Blazing fast (incremental build caching & parallel execution daemons) |
| **Enterprise Adoption** | Industry staple for strict consistency | Standard in high-complexity monoliths and Android |
| **Learning Curve** | Gentle, standardized convention | Steeper due to programmatic DSL flexibility |

---

## 3. Maven `pom.xml` Configuration

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

---

## 4. Gradle `build.gradle` Configuration

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```

---

## 5. Summary

- Maven emphasizes convention, predictability, and uniform declarative XML schemas.
- Gradle delivers peak execution velocity, fine-grained lifecycle customization, and modern DSLs.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← ](../09-dispatcherservlet/README.md) | [📚 Module Index](../README.md) | [Spring Boot Internal Architecture and Execution Flow →](../../03-spring-boot-core-features/01-spring-boot-architecture/README.md) |
