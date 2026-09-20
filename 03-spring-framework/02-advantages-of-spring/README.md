# Part 2: Advantages of Spring

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![Advantages of Spring](./assets/advantages-of-spring.jpg "Advantages of Spring")

## Table of Contents

- [1. 7 Core Advantages of Spring Framework](#1-7-core-advantages-of-spring-framework)
- [2. Real-World Example: Slashing Boilerplate with JdbcTemplate](#2-real-world-example-slashing-boilerplate-with-jdbctemplate)
- [3. Advantages Comparison Table](#3-advantages-comparison-table)

---

## 1. 7 Core Advantages of Spring Framework

Spring Framework's widespread industry adoption is driven by key engineering benefits:

1. **Predefined Templates:**
   - Spring provides built-in helper templates for persistence technologies such as **JDBC**, **Hibernate**, and **JPA**.
   - Developers do not need to write repetitive connection handling, prepared statements, transaction commits, or low-level exception handling.

2. **Loose Coupling:**
   - With **Dependency Injection (DI)** and **Inversion of Control (IoC)**, components depend on abstract contracts (interfaces) rather than concrete implementations, making systems modular and flexible.

3. **Easy to Test:**
   - Because components are Plain Old Java Objects (POJOs), dependencies can be easily mocked in unit tests without starting heavy application servers or live databases.

4. **Lightweight:**
   - Spring's core container is lightweight and executes on standard JVM environments without requiring heavy, proprietary JavaEE application servers like WebSphere or WebLogic.

5. **Fast Development:**
   - Removing boilerplate code and offering smart auto-wiring drastically shortens time-to-market.

6. **Powerful Abstraction:**
   - Delivers elegant abstraction layers over complex JavaEE technologies, such as **JMS** (Messaging), **JDBC/JPA** (Data Access), and **JTA** (Distributed Transactions).

7. **Declarative Support:**
   - Cross-cutting concerns such as transactions, caching, and validation can be applied declaratively via annotations (`@Transactional`, `@Cacheable`, `@Validated`).

---

## 2. Real-World Example: Slashing Boilerplate with JdbcTemplate

### Traditional Raw JDBC
Executing a simple SQL query traditionally required 20–30 lines of error-prone boilerplate:
- Opening `Connection`
- Creating `PreparedStatement`
- Catching `SQLException`
- Iterating `ResultSet`
- Closing resources in a `finally` block to prevent connection leaks

### Spring's `JdbcTemplate`
Spring handles all resource management and exception translation; developers only supply the SQL and mapping logic:

```java
public List<User> getAllUsers() {
    String sql = "SELECT id, name, email FROM users";
    return jdbcTemplate.query(sql, (rs, rowNum) -> 
        new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"))
    );
}
```

---

## 3. Advantages Comparison Table

| Feature Area | Traditional JavaEE Approach | Spring Framework |
| :--- | :--- | :--- |
| **Data Access** | Verbose raw JDBC boilerplate | `JdbcTemplate` & Spring Data JPA |
| **Testing** | Hardcoded `new` makes mocking difficult | Mockito & Spring TestContext |
| **Transactions** | Manual `commit()` & `rollback()` blocks | Declarative `@Transactional` annotation |
| **Architecture** | Monolithic dependencies | Modular components selected as needed |

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 1: What Is Spring Framework?](../01-what-is-spring/README.md) | [📚 Spring Framework Index](../README.md) | [Part 3: Features of Spring →](../03-features-of-spring/README.md) |
