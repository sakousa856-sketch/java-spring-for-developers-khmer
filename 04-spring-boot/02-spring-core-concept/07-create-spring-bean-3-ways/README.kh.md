# មេរៀនទី ៧: 07-create-spring-bean-3-ways

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../06-custom-bean-scope/README.kh.md) | [មេរៀនបន្ទាប់ →](../08-spring-autowiring/README.kh.md)

## មាតិកា (Table of Contents)

- [1. វិធីទី ១៖ ការប្រើប្រាស់ Stereotype Annotations (`@Component`, `@Service`)](#1-វិធីទី-១-stereotypes)
- [2. វិធីទី ២៖ ការប្រើប្រាស់ Java Configuration (`@Configuration` & `@Bean`)](#2-វិធីទី-២-java-config)
- [3. វិធីទី ៣៖ ការប្រើប្រាស់ XML Configuration (Legacy)](#3-វិធីទី-៣-xml)
- [4. តារាងប្រៀបធៀប](#4-តារាងប្រៀបធៀប)
- [5. សង្ខេប](#5-សង្ខេប)

---

## 1. វិធីទី ១៖ ការប្រើប្រាស់ Stereotype Annotations

វិធីដែលពេញនិយម និងលឿនបំផុតសម្រាប់ Classes ក្នុង Project ផ្ទាល់ខ្លួន៖
```java
@Service // ឬ @Component, @Repository, @Controller
public class InvoiceService {}
```

---

## 2. វិធីទី ២៖ ការប្រើប្រាស់ Java Configuration (`@Bean`)

វិធីស្តង់ដារសម្រាប់បង្កើត Bean ពី **Third-Party Libraries** ដែលយើងមិនអាចចូលទៅកែ Code ដាក់ `@Component` បាន (ឧ. `RestTemplate`, `ModelMapper`, `ObjectMapper`)៖
```java
@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
```

---

## 3. វិធីទី ៣៖ ការប្រើប្រាស់ XML Configuration (Legacy)

```xml
<bean id="accountService" class="com.example.service.AccountServiceImpl" />
```

---

## 4. តារាងប្រៀបធៀប

| វិធីសាស្រ្ត | ស័ក្តិសមសម្រាប់ | គុណសម្បត្តិ |
| :--- | :--- | :--- |
| **`@Component` / Stereotypes** | កូដផ្ទាល់ខ្លួនក្នុង Project | សរសេរតិច លឿន ស្អាត |
| **`@Configuration` + `@Bean`** | Third-party classes | បត់បែនខ្ពស់ អាចសរសេរ Logic Configure បាន |
| **XML Configuration** | Legacy Systems ចាស់ៗ | មិនប៉ះពាល់ Java source code |

---

## 5. សង្ខេប

- ប្រើ `@Service`/`@Component` លើ Class ខ្លួនឯង និងប្រើ `@Bean` លើ Third-party Classes។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ](../06-custom-bean-scope/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការប្រើប្រាស់ Autowiring ជាមួយ @Autowired →](../08-spring-autowiring/README.kh.md) |
