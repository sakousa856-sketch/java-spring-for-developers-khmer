# មេរៀនទី ៣: ការភ្ជាប់ Spring Boot ជាមួយ MongoDB (Integration with MongoDB NoSQL)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../02-integration-with-postgresql/README.kh.md) | [មេរៀនបន្ទាប់ →](../04-spring-data-jpa-basics/README.kh.md)

---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើមអំពី MongoDB NoSQL](#សេចក្តីផ្តើមអំពី-mongodb-nosql)
2. [Maven Dependency Setup](#maven-dependency-setup)
3. [ការកំណត់រចនាសម្ព័ន្ធ MongoDB Connection](#ការកំណត់រចនាសម្ព័ន្ធ-mongodb-connection)
4. [Document Annotations (@Document, @Id, @Field, @Indexed)](#document-annotations)
5. [MongoRepository CRUD Operations](#mongorepository-crud-operations)
6. [MongoTemplate សម្រាប់ Advanced Queries](#mongotemplate-សម្រាប់-advanced-queries)

---

## សេចក្តីផ្តើមអំពី MongoDB NoSQL
**MongoDB** គឺជា NoSQL Document Database ដ៏ពេញនិយមបំផុតដែលផ្ទុកទិន្នន័យជាទម្រង់ BSON (Binary JSON) documents។ Spring Boot ផ្តល់នូវ `spring-boot-starter-data-mongodb` ដើម្បីធ្វើការជាមួយ MongoDB បានយ៉ាងងាយស្រួល ទាំងតាមរយៈ High-level Repository (`MongoRepository`) និង Low-level Template (`MongoTemplate`)។

```mermaid
graph LR
    A["Spring Boot App"] --> B["MongoRepository / MongoTemplate"]
    B --> C["Mongo Java Driver"]
    C --> D[("MongoDB:27017 (Collections)")]
```

---

## Maven Dependency Setup

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

---

## ការកំណត់រចនាសម្ព័ន្ធ MongoDB Connection

នៅក្នុង `application.yml`៖

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://admin:secret@localhost:27017/catalog_db?authSource=admin
      auto-index-creation: true
```

---

## Document Annotations

ជំនួស JPA `@Entity` ដោយ MongoDB `@Document`៖

```java
package com.example.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "products")
public class ProductDocument {

    @Id
    private String id; // MongoDB ObjectId (Hex string)

    @Indexed(unique = true)
    private String sku;

    @Field("product_name")
    private String name;

    private BigDecimal price;
    private List<String> tags;

    // Constructors, Getters & Setters
    public ProductDocument() {}
    public ProductDocument(String sku, String name, BigDecimal price, List<String> tags) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.tags = tags;
    }
    public String getId() { return id; }
    public String getSku() { return sku; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public List<String> getTags() { return tags; }
}
```

---

## MongoRepository CRUD Operations

```java
package com.example.repository;

import com.example.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import java.util.Optional;

public interface ProductMongoRepository extends MongoRepository<ProductDocument, String> {
    Optional<ProductDocument> findBySku(String sku);
    List<ProductDocument> findByTagsContaining(String tag);

    @Query("{ 'price': { $lte: ?0 } }")
    List<ProductDocument> findCheaperThan(double maxPrice);
}
```

---

## MongoTemplate សម្រាប់ Advanced Queries

```java
@Service
public class CatalogService {

    private final MongoTemplate mongoTemplate;

    public CatalogService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<ProductDocument> searchProducts(String tag, double maxPrice) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tags").is(tag).and("price").lte(maxPrice));
        query.with(Sort.by(Sort.Direction.ASC, "price"));
        return mongoTemplate.find(query, ProductDocument.class);
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការភ្ជាប់ Spring Boot ជាមួយ PostgreSQL (Integration with PostgreSQL)](../02-integration-with-postgresql/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [មូលដ្ឋានគ្រឹះនៃ Spring Data JPA និង Entity Mapping →](../04-spring-data-jpa-basics/README.kh.md) |
