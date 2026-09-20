# Lesson 7: 4 Ways to Run a Spring Boot Application

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../06-intellij-idea-setup/README.md) | [Next Lesson →](../../02-spring-core-concept/01-inversion-of-control/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore REST API (Complete Runnable Project)](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`BookstoreApplication.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/BookstoreApplication.java) | [`pom.xml`](../../examples/01-rest-api-crud/pom.xml)


## Table of Contents

- [1. Introduction](#1-introduction)
- [2. Approach 1: Native IDE Execution](#2-approach-1-native-ide-execution)
- [3. Approach 2: Maven Wrapper (`./mvnw spring-boot:run`)](#3-approach-2-maven-wrapper-mvnw-spring-bootrun)
- [4. Approach 3: Executable Standalone JAR (`java -jar`)](#4-approach-3-executable-standalone-jar-java--jar)
- [5. Approach 4: Containerized Docker Execution](#5-approach-4-containerized-docker-execution)
- [6. Summary](#6-summary)

---

## 1. Introduction

Spring Boot provides extensive runtime flexibility, transitioning effortlessly from local development iterations to production-grade cloud cluster deployments.

---

## 2. Approach 1: Native IDE Execution

Execute directly by invoking the standard JVM entry point `public static void main()`:
```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

---

## 3. Approach 2: Maven Wrapper (`./mvnw spring-boot:run`)

Bypass local Maven installations by executing Spring Boot's bundled Maven wrapper script:
```bash
# macOS / Linux terminal:
./mvnw spring-boot:run

# Windows Command Prompt:
mvnw.cmd spring-boot:run
```

---

## 4. Approach 3: Executable Standalone JAR (`java -jar`)

This represents the canonical enterprise production and CI/CD release workflow:

```bash
# Step 1: Compile and package executable fat JAR
./mvnw clean package -DskipTests

# Step 2: Execute anywhere possessing a compatible JRE
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Runtime properties and active profiles can be overridden via command-line arguments:
```bash
java -jar target/demo-app.jar --server.port=9090 --spring.profiles.active=prod
```

---

## 5. Approach 4: Containerized Docker Execution

```dockerfile
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

```bash
docker build -t my-spring-app .
docker run -p 8080:8080 my-spring-app
```

---

## 6. Summary

- Rely on **IDE run** for everyday local development.
- Leverage **Maven Wrapper (`./mvnw`)** for deterministic terminal testing.
- Package as **Fat JARs (`java -jar`)** for automated release pipelines and cloud orchestration.

---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Scaffolding Projects in IntelliJ IDEA](../06-intellij-idea-setup/README.md) | [📚 Module Index](../README.md) | [Understanding Inversion of Control (IoC) →](../../02-spring-core-concept/01-inversion-of-control/README.md) |
