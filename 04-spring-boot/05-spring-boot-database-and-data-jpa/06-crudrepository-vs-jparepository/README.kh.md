# មេរៀនទី ៦: ការប្រៀបធៀប Repositories: CrudRepository vs JpaRepository

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../05-spring-boot-jdbc-jdbctemplate/README.kh.md) | [មេរៀនបន្ទាប់ →](../07-h2-database-for-testing/README.kh.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Todo JpaRepository Implementation](../../examples/02-spring-data-jpa-postgresql)  
> 📄 **File កូដជាក់ស្តែង:** [`TodoRepository.java`](../../examples/02-spring-data-jpa-postgresql/src/main/java/com/example/todo/repository/TodoRepository.java) | [`TodoService.java`](../../examples/02-spring-data-jpa-postgresql/src/main/java/com/example/todo/service/TodoService.java)


## មាតិកា (Table of Contents)

- [1. រចនាសម្ព័ន្ធឋានានុក្រមនៃ Spring Data Repositories](#1-រចនាសម្ព័ន្ធឋានានុក្រមនៃ-spring-data-repositories)
- [2. ភាពខុសគ្នារវាង `CrudRepository` និង `JpaRepository`](#2-ភាពខុសគ្នារវាង-crudrepository-និង-jparepository)
- [3. ការបង្កើត Query ដោយស្វ័យប្រវត្តិតាមឈ្មោះ Method (Derived Query Methods)](#3-ការបង្កើត-query-ដោយស្វ័យប្រវត្តិតាមឈ្មោះ-method-derived-query-methods)
- [4. ការសរសេរ Query ផ្ទាល់ខ្លួនជាមួយ `@Query` (JPQL vs Native SQL)](#4-ការសរសេរ-query-ផ្ទាល់ខ្លួនជាមួយ-query-jpql-vs-native-sql)
- [5. ការធ្វើ Pagination និង Sorting ជាមួយ `Pageable`](#5-ការធ្វើ-pagination-និង-sorting-ជាមួយ-pageable)
- [6. សង្ខេប](#6-សង្ខេប)

---

## 1. រចនាសម្ព័ន្ធឋានានុក្រមនៃ Spring Data Repositories

នៅក្នុង Spring Data Repositories ត្រូវបានរៀបចំឡើងជាលំដាប់ថ្នាក់យ៉ាងច្បាស់លាស់៖

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

## 2. ភាពខុសគ្នារវាង `CrudRepository` និង `JpaRepository`

| លក្ខណៈពិសេស | `CrudRepository<T, ID>` | `JpaRepository<T, ID>` |
| :--- | :--- | :--- |
| **កម្រិត Abstraction** | Generic ខ្លាំង (ប្រើបានទាំង SQL និង NoSQL ដូចជា MongoDB, Cassandra) | ផ្តាច់មុខសម្រាប់ Relational Databases (JPA) |
| **Return Type** | Return `Iterable<T>` | Return `List<T>` (ងាយស្រួលប្រើជាង) |
| **Paging & Sorting** | គ្មាន | មានស្រាប់ក្នុងខ្លួន |
| **Batch Operations** | គ្មាន | មានដូចជា `saveAllAndFlush()`, `deleteAllInBatch()` |
| **Flush Control** | គ្មាន | មាន `flush()` ដើម្បី Push ទិន្នន័យទៅ DB ភ្លាមៗ |

> 💡 **Best Practice:** ប្រសិនបើអ្នកកំពុងប្រើ Relational Database (MySQL, PostgreSQL, Oracle) ជាមួយ JPA នោះត្រូវជ្រើសរើស **`JpaRepository`** ជានិច្ច!

---

## 3. ការបង្កើត Query ដោយស្វ័យប្រវត្តិតាមឈ្មោះ Method (Derived Query Methods)

Spring Data JPA មានសមត្ថភាពពិសេសមួយ គឺអាចយល់ពីឈ្មោះ Method ដែលយើងសរសេរ ហើយបម្លែងវាទៅជា SQL Query ដោយស្វ័យប្រវត្តិ៖

```java
public interface ProductRepository extends JpaRepository<Product, Long> {

    // SELECT * FROM products WHERE product_name = ?
    List<Product> findByName(String name);

    // SELECT * FROM products WHERE LOWER(product_name) LIKE LOWER('%keyword%')
    List<Product> findByNameContainingIgnoreCase(String keyword);

    // SELECT * FROM products WHERE price >= ? AND status = ?
    List<Product> findByPriceGreaterThanEqualAndStatus(BigDecimal minPrice, ProductStatus status);

    // ត្រួតពិនិត្យថាមានទិន្នន័យឬអត់ (លឿនខ្លាំង ដោយ SELECT COUNT(1))
    boolean existsByName(String name);

    // រាប់ចំនួន
    long countByStatus(ProductStatus status);
}
```

---

## 4. ការសរសេរ Query ផ្ទាល់ខ្លួនជាមួយ `@Query` (JPQL vs Native SQL)

នៅពេល Business Logic មានភាពស្មុគស្មាញ (Join ច្រើន Table ឬ Group By) យើងអាចសរសេរ Query ដោយខ្លួនឯង៖

### វិធីទី១៖ JPQL (Java Persistence Query Language) - *ណែនាំឱ្យប្រើ*
JPQL ដំណើរការលើឈ្មោះ **Java Entity Class និង Field** (មិនមែន Table និង Column ក្នុង DB ទេ)៖

```java
@Query("SELECT p FROM Product p WHERE p.status = :status AND p.price < :maxPrice")
List<Product> findActiveAffordableProducts(
        @Param("status") ProductStatus status,
        @Param("maxPrice") BigDecimal maxPrice
);
```

### វិធីទី២៖ Native SQL (សម្រាប់ប្រើ Database Specific Features)
Native SQL សរសេរកូដ SQL ផ្ទាល់លើ Database Tables៖

```java
@Query(value = "SELECT * FROM products WHERE status = 'ACTIVE' ORDER BY RAND() LIMIT 5", nativeQuery = true)
List<Product> findTop5RandomActiveProducts();
```

---

## 5. ការធ្វើ Pagination និង Sorting ជាមួយ `Pageable`

នៅពេល Database មានទិន្នន័យរាប់ម៉ឺន ឬរាប់លាន Rows យើងមិនត្រូវ `SELECT *` ទាំងអស់ឡើយ ព្រោះវានឹងធ្វើឱ្យ Server គាំង Memory (Out Of Memory Error)។ យើងត្រូវចែកជាទំព័រ (Pagination)៖

```java
// 1. ក្នុង Repository Interface:
Page<Product> findByStatus(ProductStatus status, Pageable pageable);

// 2. ក្នុង Service ឬ Controller:
// ទាញយកទំព័រទី ០ (Page 0) ចំនួន ១០ ធាតុ តម្រៀបតាម price ចុះក្រោម
Pageable pageable = PageRequest.of(0, 10, Sort.by("price").descending());

Page<Product> productPage = productRepository.findByStatus(ProductStatus.ACTIVE, pageable);

// ព័ត៌មានលម្អិតនៃ Page សម្រាប់បញ្ជូនទៅ Frontend:
int totalPages = productPage.getTotalPages();      // ចំនួនទំព័រសរុប
long totalElements = productPage.getTotalElements(); // ចំនួនទិន្នន័យសរុប
List<Product> items = productPage.getContent();      // ទិន្នន័យក្នុងទំព័រនេះ
```

---

## 6. សង្ខេប

- `JpaRepository` គឺជាជម្រើសស្តង់ដារសម្រាប់កម្មវិធី JPA ព្រោះវាផ្តល់ Methods ពេញលេញរួមទាំង Batching, Paging, និង Sorting។
- ប្រើ **Derived Query Methods** សម្រាប់ Queries សាមញ្ញៗដោយមិនបាច់សរសេរ SQL។
- ប្រើ `@Query` ជាមួយ **JPQL** សម្រាប់ Custom Logic និងស្វែងយល់ពី Entity Graph។
- ប្រើប្រាស់ `Pageable` និង `Page<T>` ជានិច្ច ដើម្បីទប់ស្កាត់ការទាញទិន្នន័យច្រើនលើសលុបដែលនាំឱ្យខូច Performance។

---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ Spring Boot JDBC និង JdbcTemplate (Spring Boot JDBC with JdbcTemplate)](../05-spring-boot-jdbc-jdbctemplate/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការប្រើប្រាស់ H2 In-Memory Database សម្រាប់ Testing (H2 In-Memory Database) →](../07-h2-database-for-testing/README.kh.md) |
