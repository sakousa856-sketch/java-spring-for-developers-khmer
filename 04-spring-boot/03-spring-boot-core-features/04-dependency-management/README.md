# Lesson 4: Starter Dependencies and Dependency Management

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../03-auto-configuration/README.md) | [Next Lesson →](../05-application-properties/README.md)

## Table of Contents

- [1. Creating a Project with Spring Initializr](#1-creating-a-project-with-spring-initializr)
- [2. Standard Spring Boot Directory Structure](#2-standard-spring-boot-directory-structure)
- [3. What Are Starter Dependencies?](#3-what-are-starter-dependencies)
- [4. The Bill of Materials (BOM) Mechanism](#4-the-bill-of-materials-bom-mechanism)
- [5. Most Essential Spring Boot Starters](#5-most-essential-spring-boot-starters)

---

## 1. Creating a Project with Spring Initializr

The official and fastest bootstrapping mechanism is **[start.spring.io](https://start.spring.io/)** (Spring Initializr):

1. **Project:** Choose **Maven** or **Gradle** (Maven is widely favored in enterprise environments).
2. **Language:** **Java**.
3. **Spring Boot Version:** Choose the latest stable release (e.g., `3.2.x` or `3.3.x`).
4. **Project Metadata:**
   - `Group`: Organization package prefix (e.g., `com.example`).
   - `Artifact`: Application identifier (e.g., `order-service`).
   - `Packaging`: **Jar** (self-contained executable).
   - `Java Version`: **17** or **21** (minimum required for Spring Boot 3+).
5. **Dependencies:** Add `Spring Web`, `Spring Data JPA`, `Lombok`, `PostgreSQL Driver`.
6. Click **GENERATE** to download the pre-configured zip archive and open it in **IntelliJ IDEA**, **VS Code**, or **STS**.

---

## 2. Standard Spring Boot Directory Structure

```
my-spring-boot-app/
├── pom.xml                         # Dependency descriptor (Maven)
├── src/
│   ├── main/
│   │   ├── java/                   # Application Java source files
│   │   │   └── com/example/demo/
│   │   │       └── DemoApplication.java  # Main entrypoint (@SpringBootApplication)
│   │   └── resources/              # Configuration files & static assets
│   │       ├── application.properties    # or application.yml
│   │       ├── static/                   # Static web assets (CSS/JS)
│   │       └── templates/                # Server-rendered templates (Thymeleaf)
│   └── test/
│       └── java/                   # Unit and integration test suites
```

---

## 3. What Are Starter Dependencies?

**Spring Boot Starters** are aggregated dependency descriptors that bundle transitive libraries required for a specific capability:

```xml
<!-- Example: Importing a complete web stack with a single dependency -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Declaring `spring-boot-starter-web` automatically pulls in:
- `spring-web` and `spring-webmvc`
- `tomcat-embed-core` (Embedded Apache Tomcat server)
- `jackson-databind` (JSON serializer/deserializer)
- `spring-boot-starter-validation`

---

## 4. The Bill of Materials (BOM) Mechanism

Notice why individual Spring Boot dependencies omit the `<version>` tag:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <!-- No explicit version specified! -->
</dependency>
```

Spring Boot achieves this via **`spring-boot-starter-parent`** or the **Bill of Materials (BOM)**:
- Curates compatible, tested version matrix across dozens of third-party libraries (Hibernate, Jackson, HikariCP, PostgreSQL).
- Completely prevents **JAR version mismatch (JAR Hell)**.

---

## 5. Most Essential Spring Boot Starters

| Starter | Primary Capability |
| :--- | :--- |
| **`spring-boot-starter-web`** | REST APIs, Spring MVC, embedded Tomcat web server |
| **`spring-boot-starter-data-jpa`** | Hibernate, Spring Data repositories, HikariCP connection pool |
| **`spring-boot-starter-security`** | Spring Security authentication & authorization (JWT, OAuth2) |
| **`spring-boot-starter-validation`** | Jakarta Bean Validation engine |
| **`spring-boot-starter-actuator`** | Production readiness, health checks, performance metrics |
| **`spring-boot-starter-test`** | Testing suite: JUnit 5, Mockito, AssertJ, MockMvc |


---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Auto-Configuration Deep Dive](../03-auto-configuration/README.md) | [📚 Module Index](../README.md) | [Managing Configuration with Application Properties →](../05-application-properties/README.md) |
