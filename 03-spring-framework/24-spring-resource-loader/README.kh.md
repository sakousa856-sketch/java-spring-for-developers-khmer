# Part 24: ការគ្រប់គ្រងឯកសារ និងធនធាន Resource Loader (Spring Resource Loader & File Abstraction)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)
> 
> 📖 **ឯកសារយោងផ្លូវការ Spring Docs:** [Resources](https://docs.spring.io/spring-framework/reference/core/resources.html) | [The ResourceLoader](https://docs.spring.io/spring-framework/reference/core/resources/resourceloader.html)

![Spring Resource Loader Architecture](./assets/spring-resource-loader.svg "Spring Resource Loader & File Abstraction Architecture")

## មាតិកា (Table of Contents)

- [1. ដែនកំណត់នៃ java.net.URL និងដំណោះស្រាយរបស់ Spring Resource](#1-ដែនកំណត់នៃ-javaneturl-និងដំណោះស្រាយរបស់-spring-resource)
- [2. ប្រភេទ Resource Prefixes សំខាន់ៗ (classpath:, file:, http:)](#2-ប្រភេទ-resource-prefixes-សំខាន់ៗ-classpath-file-http)
- [3. ការប្រើប្រាស់ ResourceLoader ក្នុងការអានឯកសារ](#3-ការប្រើប្រាស់-resourceloader-ក្នុងការអានឯកសារ)
- [4. ការ Inject Resource ដោយផ្ទាល់តាមរយៈ @Value](#4-ការ-inject-resource-ដោយផ្ទាល់តាមរយៈ-value)
- [5. ការទាញយកឯកសារច្រើនដោយ Wildcards (ResourcePatternResolver)](#5-ការទាញយកឯកសារច្រើនដោយ-wildcards-resourcepatternresolver)
- [6. លំហាត់អនុវត្តកូដ (Code Challenge)](#6-លំហាត់អនុវត្តកូដ-code-challenge)
- [🔗 ឯកសារយោងផ្លូវការ Spring Docs](#-ឯកសារយោងផ្លូវការ-spring-docs)

---

## 1. ដែនកំណត់នៃ java.net.URL និងដំណោះស្រាយរបស់ Spring Resource

នៅក្នុង Java ស្តង់ដារ ថ្នាក់ `java.net.URL` មិនផ្តល់នូវវិធីងាយស្រួលក្នុងការអាន File ពី Classpath ឬពីខាងក្នុង JAR File ឡើយ។

Spring Framework បានបង្កើតនូវចំណុចប្រទាក់ **`org.springframework.core.io.Resource`** ដែលជា Abstraction ដ៏មានអនុភាព រួបរួមគ្រប់ប្រភពឯកសារទាំងអស់ឱ្យនៅក្រោម Interface តែមួយ៖
- `exists()`: ពិនិត្យមើលថាតើឯកសារមានពិតឬទេ
- `isReadable()`: អាចបើកអានបានឬទេ
- `isOpen()`: បញ្ជាក់ថាតើ Stream ត្រូវបានបើកឬនៅ
- `getInputStream()`: យក `InputStream` ដើម្បីអានទិន្នន័យ
- `contentLength()`: ទំហំឯកសារគិតជា Bytes
- `getFilename()`: ឈ្មោះឯកសារ

---

## 2. ប្រភេទ Resource Prefixes សំខាន់ៗ

Spring ស្គាល់ Prefixes ជាច្រើនដើម្បីកំណត់ប្រភពឯកសារ៖

| Prefix | ឧទាហរណ៍ | ការពន្យល់ |
| :--- | :--- | :--- |
| **`classpath:`** | `classpath:data/users.json` | ផ្ទុកឯកសារពី Classpath (ក្នុង `src/main/resources` ឬក្នុង JAR) |
| **`file:`** | `file:/var/data/report.pdf` | ផ្ទុកឯកសារពី File System របស់ប្រព័ន្ធប្រតិបត្តិការ |
| **`https:` / `http:`**| `https://api.example.com/data` | ផ្ទុកឯកសារពី Web Server តាមបណ្តាញ Internet |
| **គ្មាន Prefix** | `data/config.xml` | ពឹងផ្អែកលើប្រភេទ Container (ឧ. Classpath បើប្រើ `ClassPathXmlApplicationContext`) |

---

## 3. ការប្រើប្រាស់ ResourceLoader ក្នុងការអានឯកសារ

គ្រប់ `ApplicationContext` ក្នុង Spring សុទ្ធតែជា `ResourceLoader`។ យើងអាច Inject `ResourceLoader` ចូលក្នុង Service បានយ៉ាងងាយស្រួល៖

```java
@Service
public class ReportDataLoader {

    private final ResourceLoader resourceLoader;

    public ReportDataLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String loadTemplate(String path) throws IOException {
        Resource resource = resourceLoader.getResource(path);

        if (!resource.exists()) {
            throw new FileNotFoundException("រកមិនឃើញឯកសារ: " + path);
        }

        try (InputStream is = resource.getInputStream()) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
```

---

## 4. ការ Inject Resource ដោយផ្ទាល់តាមរយៈ @Value

Spring អនុញ្ញាតឱ្យអ្នក Inject ឯកសារ `Resource` ដោយផ្ទាល់ទៅក្នុង Field តាមរយៈ `@Value` ដោយមិនចាំបាច់សរសេរកូដ Load ដោយដៃឡើយ៖

```java
@Component
public class DatabaseSchemaInitializer {

    // Spring នឹងស្វែងរក និង Inject Resource ដោយស្វ័យប្រវត្តិតាម Type Converter
    @Value("classpath:schema.sql")
    private Resource sqlSchema;

    @Value("file:/etc/app/license.key")
    private Resource licenseFile;

    public void initialize() throws IOException {
        System.out.println("Reading schema: " + sqlSchema.getFilename());
        System.out.println("File size: " + sqlSchema.contentLength() + " bytes");
    }
}
```

---

## 5. ការទាញយកឯកសារច្រើនដោយ Wildcards (ResourcePatternResolver)

ប្រសិនបើអ្នកចង់អាន Files ច្រើនស្របពេលគ្នា (ឧ. រាល់ file `.xml` ទាំងអស់ក្នុង folder) អ្នកអាចប្រើ `ResourcePatternResolver` ជាមួយ Prefix **`classpath*:`**៖

```java
@Service
public class MultiConfigLoader {

    private final ResourcePatternResolver patternResolver;

    public MultiConfigLoader(ResourcePatternResolver patternResolver) {
        this.patternResolver = patternResolver;
    }

    public void loadAllPlugins() throws IOException {
        // អានគ្រប់ file json ទាំងអស់ក្នុង folder plugins និង subfolders
        Resource[] resources = patternResolver.getResources("classpath*:plugins/**/*.json");

        for (Resource r : resources) {
            System.out.println("Loaded plugin file: " + r.getFilename());
        }
    }
}
```

---

## 6. លំហាត់អនុវត្តកូដ (Code Challenge)

**លំហាត់:** ចូរបង្កើត Service ឈ្មោះ `BannerPrinter` ដែល Inject `Resource` ឈ្មោះ `classpath:banner.txt` តាមរយៈ `@Value` រួចបង្កើត method `printBanner()` ដែលអាន និងបង្ហាញអត្ថបទ banner នោះទៅកាន់ Console ពេលកម្មវិធីចាប់ផ្តើម (`@PostConstruct`)។

<details>
<summary>🔍 ចុចទីនេះដើម្បីមើលដំណោះស្រាយគំរូ</summary>

```java
@Component
public class BannerPrinter {

    @Value("classpath:banner.txt")
    private Resource bannerResource;

    @PostConstruct
    public void printBanner() {
        if (bannerResource.exists()) {
            try (InputStream is = bannerResource.getInputStream()) {
                String banner = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                System.out.println("====================================");
                System.out.println(banner);
                System.out.println("====================================");
            } catch (IOException e) {
                System.err.println("Could not load banner: " + e.getMessage());
            }
        }
    }
}
```
</details>

---

## 🔗 ឯកសារយោងផ្លូវការ Spring Docs

- [Spring Resources Abstraction](https://docs.spring.io/spring-framework/reference/core/resources.html)
- [The ResourceLoader Specification](https://docs.spring.io/spring-framework/reference/core/resources/resourceloader.html)
- [The ResourcePatternResolver](https://docs.spring.io/spring-framework/reference/core/resources/resourceloader.html#resources-resourceloader-resourcepatternresolver)

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | វគ្គបន្ទាប់ (Next Course) |
| :--- | :---: | :--- |
| [← Part 23: Circular Dependencies](../23-circular-dependencies-resolution/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Course 04: Spring Boot →](../../04-spring-boot/README.kh.md) |
