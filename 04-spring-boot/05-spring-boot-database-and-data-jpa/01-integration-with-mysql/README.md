# Lesson 1: Spring Boot Integration with MySQL Database

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../../04-spring-boot-with-rest-api/11-validation/README.md) | [Next Lesson →](../02-integration-with-postgresql/README.md)

## Table of Contents

- [1. Introduction to Spring Boot Database Drivers](#1-introduction-to-spring-boot-database-drivers)
- [2. In-Memory H2 Database for Prototyping and Automated Testing](#2-in-memory-h2-database-for-prototyping-and-automated-testing)
- [3. PostgreSQL Integration](#3-postgresql-integration)
- [4. MySQL Integration](#4-mysql-integration)
- [5. HikariCP Connection Pool (Performance Engine)](#5-hikaricp-connection-pool-performance-engine)
- [6. Deep Dive into `spring.jpa.hibernate.ddl-auto` (Production Pitfalls)](#6-deep-dive-into-springjpahibernateddl-auto-production-pitfalls)
- [7. Summary](#7-summary)

---

## 1. Introduction to Spring Boot Database Drivers

Spring Boot's auto-configuration engine abstracts complex datasource lifecycle management. Establishing persistence connections requires only two inputs:
1. Adding the target database's **JDBC Driver Dependency** to `pom.xml`.
2. Supplying connection credentials (`url`, `username`, `password`) within `application.yml` or `application.properties`.

---

## 2. In-Memory H2 Database for Prototyping and Automated Testing

**H2** is a lightweight, zero-installation database residing entirely within the JVM heap memory. Tables and data are ephemeral by default, cycling cleanly across application restarts.

### `pom.xml`:
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
    driver-class-name: org.h2.Driver
    username: sa
    password: 
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create-drop
```
*(Access `http://localhost:8080/h2-console` in any browser to interactively inspect tables and run ad-hoc SQL)*.

---

## 3. PostgreSQL Integration

PostgreSQL is the leading open-source relational database for enterprise services and containerized microservices.

### `pom.xml`:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

### `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ecommerce_db
    username: postgres
    password: mysecretpassword
    driver-class-name: org.postgresql.Driver
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

---

## 4. MySQL Integration

### `pom.xml`:
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

### `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ecommerce_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: root
    password: rootpassword
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    database-platform: org.hibernate.dialect.MySQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## 5. HikariCP Connection Pool (Performance Engine)

Spring Boot designates **HikariCP** as its default, high-throughput connection pool. Handshaking a physical database socket connection is an expensive operating system operation. HikariCP reuses warm connections, serving client requests with minimal overhead.

```yaml
spring:
  datasource:
    hikari:
      maximum-pool-size: 20       # Upper bound of simultaneous physical connections
      minimum-idle: 5             # Idle connection buffer
      idle-timeout: 300000        # 5 minutes before reclaiming idle connection
      connection-timeout: 20000   # 20 seconds maximum wait duration before timing out
      pool-name: SpringBootHikariCP
```

---

## 6. Deep Dive into `spring.jpa.hibernate.ddl-auto` (Production Pitfalls)

| Configuration Value | Hibernate Schema Behavior | Target Environment |
| :--- | :--- | :--- |
| **`none`** | Disables DDL generation entirely; makes zero modifications | 🚨 **Production (Mandatory)** |
| **`validate`** | Validates Java entities against the DB schema; aborts startup on mismatch | 🛡️ **Staging / Production** |
| **`update`** | Incrementally applies new entities and columns (never drops columns) | 💻 **Local Development Only** |
| **`create`** | Issues `DROP TABLE` across all tables, rebuilding schema from scratch | 🧪 Isolated Experiments |
| **`create-drop`** | Generates schema at boot and drops all tables during shutdown | 🧪 **Automated Testing (H2 DB)** |

> ⚠️ **Severe Production Warning:** Under no circumstances should `ddl-auto: update` or `create` be enabled in a production cluster! Unexpected schema mutations risk catastrophic data loss. In production environments, manage migrations via declarative schema versioning tools like **Flyway** or **Liquibase**.

---

## 7. Summary

- Leverage **H2 Database** for frictionless developer onboarding and isolated integration tests.
- Deploy **PostgreSQL** or **MySQL** for persistent multi-tenant backends.
- **HikariCP** provides exceptional defaults that can be fine-tuned based on workload characteristics.
- Enforce `ddl-auto: validate` or `none` in all production release pipelines.


---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Input Validation with Jakarta Bean Validation](../../04-spring-boot-with-rest-api/11-validation/README.md) | [📚 Module Index](../README.md) | [Integration with PostgreSQL →](../02-integration-with-postgresql/README.md) |
