# Lesson 3: Integration with MongoDB (NoSQL)

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../02-integration-with-postgresql/README.md) | [Next Lesson →](../04-spring-data-jpa-basics/README.md)

---

## Table of Contents
1. [Introduction to MongoDB NoSQL](#introduction-to-mongodb-nosql)
2. [Maven Dependency Setup](#maven-dependency-setup)
3. [Configuring MongoDB Connection](#configuring-mongodb-connection)
4. [Document Annotations (@Document, @Id, @Field, @Indexed)](#document-annotations)
5. [MongoRepository CRUD Operations](#mongorepository-crud-operations)
6. [MongoTemplate for Advanced Queries](#mongotemplate-for-advanced-queries)

---

## Introduction to MongoDB NoSQL
**MongoDB** is an open-source, high-performance document-oriented NoSQL database storing data as JSON-like documents with dynamic schemas (BSON). Spring Boot offers comprehensive integration via `spring-boot-starter-data-mongodb`, supporting both declarative `MongoRepository` abstractions and dynamic `MongoTemplate` queries.

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

## Configuring MongoDB Connection

In `application.yml`:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://admin:secret@localhost:27017/catalog_db?authSource=admin
      auto-index-creation: true
```

---

## Document Annotations

In place of JPA entities, annotate models with MongoDB document annotations:

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

## MongoTemplate for Advanced Queries

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

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Integration with PostgreSQL](../02-integration-with-postgresql/README.md) | [📚 Module Index](../README.md) | [Spring Data JPA Fundamentals and Entity Mapping →](../04-spring-data-jpa-basics/README.md) |
