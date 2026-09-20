# មេរៀនទី ៣: យន្តការកំណត់រចនាសម្ព័ន្ធស្វ័យប្រវត្តិ (Auto-Configuration Deep Dive)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../02-spring-boot-annotations/README.md) | [មេរៀនបន្ទាប់ →](../04-dependency-management/README.md)

## មាតិកា (Table of Contents)

- [1. តើ Auto-Configuration ដំណើរការយ៉ាងដូចម្តេច?](#1-តើ-auto-configuration-ដំណើរការយ៉ាងដូចម្តេច)
- [2. ការបំបែកសមាសធាតុនៃ `@SpringBootApplication`](#2-ការបំបែកសមាសធាតុនៃ-springbootapplication)
- [3. យន្តការលក្ខខណ្ឌ Conditional Annotations](#3-យន្តការលក្ខខណ្ឌ-conditional-annotations)
- [4. កន្លែងផ្ទុកបញ្ជី Auto-Configuration (Spring Boot 3.x)](#4-កន្លែងផ្ទុកបញ្ជី-auto-configuration-spring-boot-3x)
- [5. របៀបបិទ Auto-Configuration ខ្លះដែលមិនចង់ប្រើ (Disabling Auto-Config)](#5-របៀបបិទ-auto-configuration-ខ្លះដែលមិនចង់ប្រើ-disabling-auto-config)

---

## 1. តើ Auto-Configuration ដំណើរការយ៉ាងដូចម្តេច?

**Auto-Configuration** គឺជា "មន្តអាគម" ដ៏ល្បីល្បាញបំផុតរបស់ Spring Boot។ វាជាយន្តការស្វ័យប្រវត្តិនៃការបង្កើត និងរៀបចំ Beans នៅក្នុង IoC Container ដោយផ្អែកលើ៖
1. **Libraries ដែលមាននៅលើ Classpath:** (ឧ. បើឃើញ Driver របស់ PostgreSQL វានឹងរៀបចំ Connection ទៅ DB)
2. **Properties ដែលបានកំណត់ក្នុង `application.properties`**
3. **Beans ដែល Developer បានបង្កើតដោយខ្លួនឯង**

> **គោលការណ៍មាស:** *"បើអ្នកមិនបានបង្កើត Bean នោះទេ Spring Boot នឹងបង្កើតតម្លៃលំនាំដើមឱ្យអ្នក។ តែបើអ្នកបានបង្កើត Bean ផ្ទាល់ខ្លួនហើយ នោះ Spring Boot នឹងដកថយឱ្យ Bean របស់អ្នកដើរតួនាទីជំនួសវិញ"*។

---

## 2. ការបំបែកសមាសធាតុនៃ `@SpringBootApplication`

នៅលើ Main Class នៃ Spring Boot យើងតែងតែឃើញ Annotation មួយគត់គឺ `@SpringBootApplication`។ តាមពិតវាជា **Meta-Annotation** ដែលរួមផ្សំដោយ Annotations ធំៗចំនួន ៣៖

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootConfiguration     // 1. សម្គាល់ថា Class នេះជា @Configuration Class
@EnableAutoConfiguration     // 2. បើកដំណើរការយន្តការ Auto-Configuration
@ComponentScan               // 3. ស្កេនរក @Component, @Service, @Repository ក្នុង package បច្ចុប្បន្ន
public @interface SpringBootApplication { ... }
```

---

## 3. យន្តការលក្ខខណ្ឌ Conditional Annotations

Spring Boot ដឹងថាពេលណាត្រូវរៀបចំ Bean អ្វីមួយ តាមរយៈ **Conditional Annotations**៖

| Annotation | លក្ខខណ្ឌដែលត្រូវផ្ទៀងផ្ទាត់ |
| :--- | :--- |
| **`@ConditionalOnClass`** | ដំណើរការ Auto-Config លុះត្រាតែ Class ឬ Library ជាក់លាក់មានវត្តមានក្នុង Classpath |
| **`@ConditionalOnMissingBean`** | បង្កើត Bean លំនាំដើម **លុះត្រាតែ Developer មិនទាន់បានបង្កើត Bean នោះដោយខ្លួនឯង** |
| **`@ConditionalOnProperty`** | ដំណើរការលុះត្រាតែ Property ក្នុង `application.properties` ត្រូវបានបើកឱ្យប្រើ (`true`) |
| **`@ConditionalOnWebApplication`** | ដំណើរការលុះត្រាតែ Project បច្ចុប្បន្នជាប្រភេទ Web Application |

### ឧទាហរណ៍ជាក់ស្តែង៖
ប្រសិនបើអ្នកបង្កើត `DataSource` Bean ដោយខ្លួនឯង Spring Boot នឹងឃើញថាមាន Bean រួចហើយ (តាម `@ConditionalOnMissingBean(DataSource.class)`) ដូច្នេះវានឹងមិនបង្កើត DataSource ស្វ័យប្រវត្តិនោះឡើយ។

---

## 4. កន្លែងផ្ទុកបញ្ជី Auto-Configuration (Spring Boot 3.x)

- ក្នុង **Spring Boot 2.x:** បញ្ជី Auto-configuration ត្រូវបានផ្ទុកក្នុងឯកសារ `META-INF/spring.factories`។
- ក្នុង **Spring Boot 3.x:** បញ្ជីនេះត្រូវបានផ្លាស់ប្តូរទៅកាន់ឯកសារថ្មីដែលមានទម្រង់ស្អាតជាងមុន៖
  ```
  META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
  ```
  ឯកសារនេះផ្ទុកនូវឈ្មោះ Configuration Classes រាប់រយ (ដូចជា `DataSourceAutoConfiguration`, `JacksonAutoConfiguration`, `WebMvcAutoConfiguration`) ដែល Spring Boot ត្រូវត្រួតពិនិត្យពេល Application ចាប់ផ្តើម។

---

## 5. របៀបបិទ Auto-Configuration ខ្លះដែលមិនចង់ប្រើ (Disabling Auto-Config)

ប្រសិនបើអ្នកចង់បិទការបង្កើត DataSource ស្វ័យប្រវត្តិ (ឧ. ពេលកំពុងបង្កើត App ដែលមិនទាន់ចង់ភ្ជាប់ Database) អ្នកអាចប្រើពាក្យបញ្ជា `exclude`៖

```java
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```


---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Spring Boot Annotations សំខាន់ៗ (Core Spring Boot Annotations)](../02-spring-boot-annotations/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការគ្រប់គ្រង Starter Dependencies (Dependency Management) →](../04-dependency-management/README.md) |
