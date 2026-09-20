# Part 19: Annotations ស្នូល និងការគ្រប់គ្រងបរិស្ថាន Properties (Core Annotations & Environment Properties)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)
> 
> 📖 **ឯកសារយោងផ្លូវការ Spring Docs:** [Environment Abstraction](https://docs.spring.io/spring-framework/reference/core/beans/environment.html) | [Annotation-based Container Configuration](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config.html)

![Core Annotations & Properties](./assets/core-annotations-properties.svg "Core Annotations & Environment Properties")

## មាតិកា (Table of Contents)

- [1. ការអាន Config ពី External Files ដោយ @PropertySource & @Value](#1-ការអាន-config-ពី-external-files-ដោយ-propertysource--value)
- [2. ការបំបែក Environment ដោយប្រើ @Profile](#2-ការបំបែក-environment-ដោយប្រើ-profile)
- [3. ការពន្យារពេលបង្កើត Bean ដោយ @Lazy](#3-ការពន្យារពេលបង្កើត-bean-ដោយ-lazy)
- [4. ការគ្រប់គ្រងលំដាប់លំដោយដោយ @DependsOn និង @Order](#4-ការគ្រប់គ្រងលំដាប់លំដោយដោយ-dependson-និង-order)
- [5. មូលដ្ឋានគ្រឹះនៃ @Conditional Annotation](#5-មូលដ្ឋានគ្រឹះនៃ-conditional-annotation)
- [6. លំហាត់អនុវត្តកូដ (Code Challenge)](#6-លំហាត់អនុវត្តកូដ-code-challenge)
- [🔗 ឯកសារយោងផ្លូវការ Spring Docs](#-ឯកសារយោងផ្លូវការ-spring-docs)

---

## 1. ការអាន Config ពី External Files ដោយ @PropertySource & @Value

ក្នុងកម្មវិធី Production យើងមិនដែល Hardcode តម្លៃដូចជា Database URLs, API Keys, ឬ Port ក្នុង Java Code ឡើយ។ យើងរក្សាទុកវាក្នុងឯកសារ `.properties`៖

ឯកសារ `application.properties` ក្នុង Classpath:
```properties
app.name=CoreBankSystem
app.timeout=5000
app.admin.email=admin@bank.com
```

ការអាន និងចាក់បញ្ចូលតម្លៃចូលក្នុង Spring Bean៖
```java
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
}

@Component
public class BankConfigService {

    // ១. Inject String ធម្មតា
    @Value("${app.name}")
    private String appName;

    // ២. Inject និងបម្លែងជា int ដោយស្វ័យប្រវត្តិ
    @Value("${app.timeout}")
    private int timeout;

    // ៣. ការផ្ដល់តម្លៃ Default បើរកមិនឃើញ Property ក្នុង file (ប្រើសញ្ញា :)
    @Value("${app.retry.limit:3}")
    private int retryLimit;
}
```

---

## 2. ការបំបែក Environment ដោយប្រើ @Profile

Spring `@Profile` អនុញ្ញាតឱ្យយើងបែងចែក Beans ឱ្យដំណើរការតែនៅក្នុង Environment ជាក់លាក់ប៉ុណ្ណោះ (ឧ. `dev`, `test`, `prod`)៖

```java
public interface EmailSender {
    void send(String to, String msg);
}

@Service
@Profile("dev")
public class MockEmailSender implements EmailSender {
    public void send(String to, String msg) {
        System.out.println("[DEV MOCK] Log email to console without sending: " + msg);
    }
}

@Service
@Profile("prod")
public class SmtpEmailSender implements EmailSender {
    public void send(String to, String msg) {
        System.out.println("[PROD SMTP] Sending real email through AWS SES to " + to);
    }
}
```

ការបើកដំណើរការ Profile តាមរយៈ Java Code ឬ JVM Argument:
```java
// តាម Java Code
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.getEnvironment().setActiveProfiles("dev");
ctx.register(AppConfig.class);
ctx.refresh();

// ឬតាម Terminal JVM Option:
// -Dspring.profiles.active=prod
```

---

## 3. ការពន្យារពេលបង្កើត Bean ដោយ @Lazy

តាមលំនាំដើម រាល់ Singleton Beans ទាំងអស់នឹងត្រូវ Instantiate ភ្លាមៗពេល Spring Container ចាប់ផ្តើម (Eager Initialization)។ ប្រសិនបើ Bean នោះធ្ងន់ (ស៊ី Memory ច្រើន) ឬកម្រនឹងត្រូវប្រើ យើងអាចប្រើ `@Lazy`៖

```java
@Component
@Lazy
public class HeavyReportGenerator {
    public HeavyReportGenerator() {
        System.out.println("HeavyReportGenerator created ONLY when first injected or called!");
    }
}
```

---

## 4. ការគ្រប់គ្រងលំដាប់លំដោយដោយ @DependsOn និង @Order

- **`@DependsOn("dbMigrationBean")`:** បង្ខំឱ្យ Spring បង្កើត Bean ឈ្មោះ `dbMigrationBean` ឱ្យចប់សព្វគ្រប់សិន មុននឹងចាប់ផ្តើមបង្កើត Bean បច្ចុប្បន្ន។
- **`@Order(1)`:** កំណត់លំដាប់លំដោយ (Priority) នៅពេល Inject Collection នៃ Beans (លេខតូច រត់មុន)៖

```java
@Component
@Order(1)
public class AuthenticationFilter implements Filter { ... }

@Component
@Order(2)
public class LoggingFilter implements Filter { ... }
```

---

## 5. មូលដ្ឋានគ្រឹះនៃ @Conditional Annotation

`@Conditional` គឺជាសសរទ្រូងដ៏ធំបំផុតដែលធ្វើឱ្យ **Spring Boot Auto-Configuration** អាចដំណើរការបាន។ វាអនុញ្ញាតឱ្យ Bean ត្រូវបានបង្កើតឡើង លុះត្រាតែលក្ខខណ្ឌ Boolean មួយត្រូវបានផ្ទៀងផ្ទាត់ជោគជ័យ៖

```java
public class OnProductionCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "true".equalsIgnoreCase(context.getEnvironment().getProperty("app.is-prod"));
    }
}

@Bean
@Conditional(OnProductionCondition.class)
public AuditService auditService() {
    return new ProductionAuditService();
}
```

---

## 6. លំហាត់អនុវត្តកូដ (Code Challenge)

**លំហាត់:** ចូរបង្កើត Bean មួយឈ្មោះ `DatabaseConfig` ដោយប្រើ `@PropertySource("classpath:db.properties")` រួច Inject `db.url`, `db.port` (Default 5432 បើគ្មាន), និងកំណត់ Bean នេះឱ្យដំណើរការតែក្នុង `@Profile("staging")` ប៉ុណ្ណោះ។

<details>
<summary>🔍 ចុចទីនេះដើម្បីមើលដំណោះស្រាយគំរូ</summary>

```java
@Component
@Profile("staging")
@PropertySource("classpath:db.properties")
public class DatabaseConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.port:5432}")
    private int port;

    public void printConfig() {
        System.out.println("Connected to: " + url + " on port: " + port);
    }
}
```
</details>

---

## 🔗 ឯកសារយោងផ្លូវការ Spring Docs

- [Spring Environment Abstraction](https://docs.spring.io/spring-framework/reference/core/beans/environment.html)
- [Annotation-based Container Configuration](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config.html)
- [Spring Bean Profiles](https://docs.spring.io/spring-framework/reference/core/beans/environment.html#beans-definition-profiles)

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 18: វដ្តជីវិតលម្អិតរបស់ Spring Bean](../18-bean-lifecycle-and-postprocessor/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 20: Spring Expression Language (SpEL) →](../20-spring-expression-language-spel/README.kh.md) |
