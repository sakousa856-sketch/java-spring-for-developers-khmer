# Lesson 6: Scaffolding Projects in IntelliJ IDEA

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../05-eclipse-ide-setup/README.md) | [Next Lesson →](../07-run-spring-boot-application/README.md)

## Table of Contents

- [1. Industry Dominance of IntelliJ IDEA](#1-industry-dominance-of-intellij-idea)
- [2. Scaffolding in IntelliJ IDEA Ultimate Edition](#2-scaffolding-in-intellij-idea-ultimate-edition)
- [3. Scaffolding in IntelliJ IDEA Community Edition (Free)](#3-scaffolding-in-intellij-idea-community-edition-free)
- [4. Canonical Project Directory Structure](#4-canonical-project-directory-structure)
- [5. Summary](#5-summary)

---

## 1. Industry Dominance of IntelliJ IDEA

IntelliJ IDEA by JetBrains commands over 70% of professional Java enterprise mindshare due to:
- Context-aware code indexing and static analysis
- Effortless semantic refactorings
- Seamless build tool and git integration

---

## 2. Scaffolding in IntelliJ IDEA Ultimate Edition

1. Select **New Project**
2. Select **Spring Initializr** from the left navigation panel
3. Configure language (`Java`), build system (`Maven`), and JDK (`17` / `21`)
4. Attach required starters (`Spring Web`, `DevTools`) and click **Create**

---

## 3. Scaffolding in IntelliJ IDEA Community Edition (Free)

Because Community Edition omits the embedded Spring wizard:
1. Navigate to the official web generator: `https://start.spring.io`
2. Configure Maven coordinates, Java LTS, and add `Spring Web`
3. Click **GENERATE** and unzip the generated archive
4. Launch IntelliJ Community -> Click **Open** -> Select target directory -> Confirm **Open as Maven Project**.

---

## 4. Canonical Project Directory Structure

```
demo-app/
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java          # Root Application bootstrap
│   ├── controller/                   # HTTP Web endpoints
│   ├── service/                      # Core transactional domain logic
│   ├── repository/                   # Persistence access interfaces
│   └── entity/                       # JPA Database domain records
└── src/main/resources/
    └── application.yml               # Unified environment configuration
```

---

## 5. Summary

- IntelliJ IDEA provides the industry gold-standard productivity environment for enterprise Java development.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Eclipse IDE Setup for Spring Boot](../05-eclipse-ide-setup/README.md) | [📚 Module Index](../README.md) | [4 Ways to Run a Spring Boot Application →](../07-run-spring-boot-application/README.md) |
