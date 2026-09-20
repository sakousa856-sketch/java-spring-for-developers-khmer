# Part 24: Spring Resource Loader & File Abstraction

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)
> 
> 📖 **Official Spring Documentation:** [Resources](https://docs.spring.io/spring-framework/reference/core/resources.html) | [The ResourceLoader](https://docs.spring.io/spring-framework/reference/core/resources/resourceloader.html)

![Spring Resource Loader Architecture](./assets/spring-resource-loader.svg "Spring Resource Loader & File Abstraction Architecture")

## Table of Contents

- [1. Shortcomings of java.net.URL and Spring's Resource Abstraction](#1-shortcomings-of-javaneturl-and-springs-resource-abstraction)
- [2. Primary Resource Prefixes (classpath:, file:, https:)](#2-primary-resource-prefixes-classpath-file-https)
- [3. Leveraging ResourceLoader Programmatically](#3-leveraging-resourceloader-programmatically)
- [4. Direct Resource Injection via @Value](#4-direct-resource-injection-via-value)
- [5. Bulk Wildcard Resolution with ResourcePatternResolver](#5-bulk-wildcard-resolution-with-resourcepatternresolver)
- [6. Practical Code Challenge](#6-practical-code-challenge)
- [🔗 Official Spring Documentation](#-official-spring-documentation)

---

## 1. Shortcomings of java.net.URL and Spring's Resource Abstraction

Standard Java's `java.net.URL` mechanism lacks standardized primitives for loading assets relative to classpaths, servlet contexts, or nested within archived JAR boundaries.

Spring addresses this via the **`org.springframework.core.io.Resource`** descriptor:
- `exists()`: Validates physical file existence
- `isReadable()`: Confirms accessibility
- `getInputStream()`: Provides an open byte stream
- `contentLength()`: Quantifies byte size
- `getFilename()`: Extracts base asset name

---

## 2. Primary Resource Prefixes

| Prefix | Usage Example | Semantic Meaning |
| :--- | :--- | :--- |
| **`classpath:`** | `classpath:config/app.json` | Resolves from application classpath or embedded JAR |
| **`file:`** | `file:/opt/data/certs.pem` | Resolves from underlying operating system filesystem |
| **`https:` / `http:`**| `https://domain.com/feed.xml` | Resolves as HTTP web network stream |
| **(None)** | `data/users.csv` | Depends on context loader implementation |

---

## 3. Leveraging ResourceLoader Programmatically

Every Spring `ApplicationContext` implements `ResourceLoader`:

```java
@Service
public class DocumentService {

    private final ResourceLoader loader;

    public DocumentService(ResourceLoader loader) {
        this.loader = loader;
    }

    public byte[] loadDocument(String uri) throws IOException {
        Resource resource = loader.getResource(uri);
        if (!resource.exists()) {
            throw new FileNotFoundException("Asset not found at: " + uri);
        }
        try (InputStream stream = resource.getInputStream()) {
            return stream.readAllBytes();
        }
    }
}
```

---

## 4. Direct Resource Injection via @Value

Spring's built-in `PropertyEditor` converts string path expressions directly into `Resource` beans:

```java
@Component
public class DatabaseBootstrap {

    @Value("classpath:schema.sql")
    private Resource ddlScript;

    @Value("file:/var/app/license.key")
    private Resource licenseKey;

    public void verify() throws IOException {
        System.out.printf("Resource: %s (Size: %d bytes)%n", 
                ddlScript.getFilename(), ddlScript.contentLength());
    }
}
```

---

## 5. Bulk Wildcard Resolution with ResourcePatternResolver

To load multiple files matching Ant-style patterns (wildcards), leverage `ResourcePatternResolver`:

```java
@Service
public class PluginScanner {

    private final ResourcePatternResolver resolver;

    public PluginScanner(ResourcePatternResolver resolver) {
        this.resolver = resolver;
    }

    public void discover() throws IOException {
        // Loads matching resources across all jars in classpath
        Resource[] definitions = resolver.getResources("classpath*:modules/**/plugin.xml");
        for (Resource r : definitions) {
            System.out.println("Discovered manifest: " + r.getURI());
        }
    }
}
```

---

## 6. Practical Code Challenge

**Challenge:** Create a component `SystemBanner` that injects `classpath:banner.txt` via `@Value`. Print the banner in uppercase to the console upon container initialization (`@PostConstruct`).

<details>
<summary>🔍 Click to view solution</summary>

```java
@Component
public class SystemBanner {

    @Value("classpath:banner.txt")
    private Resource banner;

    @PostConstruct
    public void display() {
        if (banner.exists()) {
            try (InputStream in = banner.getInputStream()) {
                String text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                System.out.println(text.toUpperCase());
            } catch (IOException e) {
                System.err.println("Failed to read banner: " + e.getMessage());
            }
        }
    }
}
```
</details>

---

## 🔗 Official Spring Documentation

- [Spring Resources Abstraction](https://docs.spring.io/spring-framework/reference/core/resources.html)
- [The ResourceLoader Specification](https://docs.spring.io/spring-framework/reference/core/resources/resourceloader.html)
- [The ResourcePatternResolver](https://docs.spring.io/spring-framework/reference/core/resources/resourceloader.html#resources-resourceloader-resourcepatternresolver)

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next Course |
| :--- | :---: | :--- |
| [← Part 23: Circular Dependencies](../23-circular-dependencies-resolution/README.md) | [📚 Spring Framework Index](../README.md) | [Course 04: Spring Boot →](../../04-spring-boot/README.md) |
