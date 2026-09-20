# Lesson 6: Repositories Comparison: CrudRepository vs JpaRepository

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../05-spring-boot-jdbc-jdbctemplate/README.md) | [Next Lesson →](../07-h2-database-for-testing/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Todo JpaRepository Implementation](../../examples/02-spring-data-jpa-postgresql)  
> 📄 **Source Code Files:** [`TodoRepository.java`](../../examples/02-spring-data-jpa-postgresql/src/main/java/com/example/todo/repository/TodoRepository.java) | [`TodoService.java`](../../examples/02-spring-data-jpa-postgresql/src/main/java/com/example/todo/service/TodoService.java)


## Table of Contents

- [1. Hierarchy of Spring Data Repositories](#1-hierarchy-of-spring-data-repositories)
- [2. Comparing `CrudRepository` and `JpaRepository`](#2-comparing-crudrepository-and-jparepository)
- [3. Automated Derived Query Methods](#3-automated-derived-query-methods)
- [4. Custom Queries with `@Query` (JPQL vs Native SQL)](#4-custom-queries-with-query-jpql-vs-native-sql)
- [5. Pagination and Sorting with `Pageable`](#5-pagination-and-sorting-with-pageable)
- [6. Summary](#6-summary)

---

## 1. Hierarchy of Spring Data Repositories

Spring Data repositories are organized in a clean, composable inheritance hierarchy:

```
                    Repository<T, ID>
                           ▲
                           │
                   CrudRepository<T, ID>
                           ▲
            ┌──────────────┴──────────────┐
            │                             │
ListCrudRepository<T, ID>     PagingAndSortingRepository<T, ID>
            ▲                             ▲
            └──────────────┬──────────────┘
                           │
                   JpaRepository<T, ID>
```

---

## 2. Comparing `CrudRepository` and `JpaRepository`

| Feature / Aspect | `CrudRepository<T, ID>` | `JpaRepository<T, ID>` |
| :--- | :--- | :--- |
| **Abstraction Level** | Storage-agnostic (works across SQL and NoSQL like Mongo, Cassandra) | Tailored strictly to JPA Relational Stores |
| **Return Type** | Returns `Iterable<T>` | Returns `List<T>` (idiomatic & convenient) |
| **Paging & Sorting** | Not included | Inherited natively |
| **Batch Operations** | Not supported | Supported (`saveAllAndFlush()`, `deleteAllInBatch()`) |
| **Session Flush Control** | Not supported | Explicit `flush()` support to sync persistence context |

> 💡 **Best Practice:** When architecting relational database applications with Spring Boot and JPA, always default to **`JpaRepository`**.

---

## 3. Automated Derived Query Methods

Spring Data JPA inspects repository method signatures using a query creation Domain Specific Language (DSL) to derive SQL queries dynamically without explicit SQL code:

```java
public interface ProductRepository extends JpaRepository<Product, Long> {

    // SELECT * FROM products WHERE product_name = ?
    List<Product> findByName(String name);

    // SELECT * FROM products WHERE LOWER(product_name) LIKE LOWER('%keyword%')
    List<Product> findByNameContainingIgnoreCase(String keyword);

    // SELECT * FROM products WHERE price >= ? AND status = ?
    List<Product> findByPriceGreaterThanEqualAndStatus(BigDecimal minPrice, ProductStatus status);

    // High performance existence verification (emits SELECT COUNT(1))
    boolean existsByName(String name);

    // Direct aggregation count
    long countByStatus(ProductStatus status);
}
```

---

## 4. Custom Queries with `@Query` (JPQL vs Native SQL)

For complex domain logic involving multi-table joins or grouping, author custom queries:

### Approach 1: JPQL (Java Persistence Query Language) - *Recommended*
JPQL queries target **Java Entity names and properties** instead of underlying database tables:

```java
@Query("SELECT p FROM Product p WHERE p.status = :status AND p.price < :maxPrice")
List<Product> findActiveAffordableProducts(
        @Param("status") ProductStatus status,
        @Param("maxPrice") BigDecimal maxPrice
);
```

### Approach 2: Native SQL (Database Engine Specific Optimization)
Native SQL maps directly to raw database dialect features:

```java
@Query(value = "SELECT * FROM products WHERE status = 'ACTIVE' ORDER BY RAND() LIMIT 5", nativeQuery = true)
List<Product> findTop5RandomActiveProducts();
```

---

## 5. Pagination and Sorting with `Pageable`

Querying unrestricted datasets from tables containing hundreds of thousands of rows risks heap memory exhaustion (`OutOfMemoryError`). Always apply pagination:

```java
// 1. In Repository Definition:
Page<Product> findByStatus(ProductStatus status, Pageable pageable);

// 2. In Service or Controller execution:
// Request Page 0 with a page size of 10 items, sorted by price descending
Pageable pageable = PageRequest.of(0, 10, Sort.by("price").descending());

Page<Product> productPage = productRepository.findByStatus(ProductStatus.ACTIVE, pageable);

// Metadata available for frontend client rendering:
int totalPages = productPage.getTotalPages();
long totalElements = productPage.getTotalElements();
List<Product> items = productPage.getContent();
```

---

## 6. Summary

- `JpaRepository` is the standard repository choice for relational databases, offering batching, paging, and list-oriented returns out-of-the-box.
- Rely on **Derived Query Methods** for intuitive, zero-boilerplate queries.
- Use `@Query` with **JPQL** for type-safe, database-agnostic entity querying.
- Always implement `Pageable` and `Page<T>` on unbounded collection endpoints to ensure memory safety.

---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Spring Boot JDBC with JdbcTemplate](../05-spring-boot-jdbc-jdbctemplate/README.md) | [📚 Module Index](../README.md) | [H2 In-Memory Database for Fast Testing →](../07-h2-database-for-testing/README.md) |
