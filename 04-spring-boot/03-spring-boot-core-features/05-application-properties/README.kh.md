# មេរៀនទី ៥: ការកំណត់រចនាសម្ព័ន្ធជាមួយ Application Properties

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../04-dependency-management/README.kh.md) | [មេរៀនបន្ទាប់ →](../06-yaml-configuration/README.kh.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore Application Configuration](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`application.yml`](../../examples/01-rest-api-crud/src/main/resources/application.yml) | [`pom.xml`](../../examples/01-rest-api-crud/pom.xml)


## មាតិកា (Table of Contents)

- [1. ទិដ្ឋភាពទូទៅនៃ Configuration ក្នុង Spring Boot](#1-ទិដ្ឋភាពទូទៅនៃ-configuration-ក្នុង-spring-boot)
- [2. ការប្រៀបធៀប៖ `application.properties` vs `application.yml`](#2-ការប្រៀបធៀប-applicationproperties-vs-applicationyml)
- [3. វិធីទី ១៖ អានតម្លៃដោយប្រើ `@Value`](#3-វិធីទី-១-អានតម្លៃដោយប្រើ-value)
- [4. វិធីទី ២៖ Type-Safe Configuration ជាមួយ `@ConfigurationProperties`](#4-វិធីទី-២-type-safe-configuration-ជាមួយ-configurationproperties)
- [5. ការគ្រប់គ្រងបរិស្ថានតាម Profiles (`dev`, `staging`, `prod`)](#5-ការគ្រប់គ្រងបរិស្ថានតាម-profiles-dev-staging-prod)

---

## 1. ទិដ្ឋភាពទូទៅនៃ Configuration ក្នុង Spring Boot

នៅក្នុង Spring Boot រាល់ការកំណត់រចនាសម្ព័ន្ធ (ដូចជា Server Port, Database Connection, Secret Keys, Third-party APIs) ត្រូវបានដាក់នៅទីតាំងកណ្តាលមួយក្នុង `src/main/resources/` ដោយប្រើឯកសារ **`application.properties`** ឬ **`application.yml`**។

Spring Boot ផ្តល់នូវភាពបត់បែនខ្ពស់ក្នុងការកែប្រែ Configuration ដោយមិនចាំបាច់ប៉ះពាល់ដល់កូដ Java ឡើយ។

---

## 2. ការប្រៀបធៀប៖ `application.properties` vs `application.yml`

| `application.properties` (Flat format) | `application.yml` (Hierarchical YAML) |
| :--- | :--- |
| ```properties<br>server.port=8080<br>spring.datasource.url=jdbc:postgresql://localhost:5432/mydb<br>spring.datasource.username=postgres<br>spring.datasource.password=secret<br>``` | ```yaml<br>server:<br>  port: 8080<br>spring:<br>  datasource:<br>    url: jdbc:postgresql://localhost:5432/mydb<br>    username: postgres<br>    password: secret<br>``` |

**ហេតុអ្វីបានជា Developer និយមប្រើ YAML?**
- មានទម្រង់ជារចនាសម្ព័ន្ធដើមឈើ (Tree Hierarchy) ស្អាត មិនបាច់សរសេរ prefix ស្ទួនៗ
- គាំទ្រ Data Lists, Maps, និង Comments ច្បាស់លាស់

---

## 3. វិធីទី ១៖ អានតម្លៃដោយប្រើ `@Value`

ប្រើប្រាស់ `@Value` Annotation ដើម្បីទាញយកតម្លៃមកដាក់ក្នុង Field ដោយផ្ទាល់៖

```java
@Service
public class PaymentGatewayService {

    // ទាញយកតម្លៃពី config បើគ្មានដាក់ default ជា 30
    @Value("${payment.timeout:30}")
    private int timeoutSeconds;

    @Value("${payment.api-key}")
    private String apiKey;

    public void process() {
        System.out.println("Connecting with API Key: " + apiKey + ", Timeout: " + timeoutSeconds);
    }
}
```

---

## 4. វិធីទី ២៖ Type-Safe Configuration ជាមួយ `@ConfigurationProperties`

សម្រាប់ Configuration ដែលមានទំហំធំ ឬស្មុគស្មាញ ការប្រើ `@Value` ច្រើនជួរងាយនឹងច្រឡំ។ វិធីសាស្ត្រស្តង់ដារល្អបំផុតគឺបង្កើត Class ឬ **Java Record** ជាមួយ `@ConfigurationProperties`៖

```yaml
# application.yml
app:
  jwt:
    secret: my-ultra-secure-secret-key-32bytes
    expiration-hours: 24
```

```java
// Type-Safe Config Record (Java 17+)
@ConfigurationProperties(prefix = "app.jwt")
public record JwtProperties(String secret, int expirationHours) {}
```

```java
// យកទៅប្រើប្រាស់ក្នុង Service
@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtProperties jwtProperties;

    public void generateToken() {
        System.out.println("Secret: " + jwtProperties.secret());
    }
}
```

---

## 5. ការគ្រប់គ្រងបរិស្ថានតាម Profiles (`dev`, `staging`, `prod`)

Spring Boot អនុញ្ញាតឱ្យយើងបំបែក Configuration តាមបរិស្ថានការងារជាក់ស្តែង៖
- `application-dev.yml` (សម្រាប់ run លើម៉ាស៊ីនផ្ទាល់ខ្លួន — ប្រើ H2 DB)
- `application-prod.yml` (សម្រាប់ Server ពិតប្រាកដ — ប្រើ Cloud PostgreSQL)

### ការជ្រើសរើស Profile ឱ្យដំណើរការ៖
```yaml
# application.yml (Default)
spring:
  profiles:
    active: dev
```

ឬនៅពេល Deploy លើ Production តាមរយៈ Terminal / Docker៖
```bash
java -jar -Dspring.profiles.active=prod app.jar
```

---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការគ្រប់គ្រង Starter Dependencies (Dependency Management)](../04-dependency-management/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការកំណត់រចនាសម្ព័ន្ធជាមួយ YAML (YAML Configuration in Spring Boot) →](../06-yaml-configuration/README.kh.md) |
