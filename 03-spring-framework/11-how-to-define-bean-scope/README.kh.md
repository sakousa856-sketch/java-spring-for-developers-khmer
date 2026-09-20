# Part 11: របៀបកំណត់វិសាលភាព Bean Scope (Defining Bean Scopes)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![របៀបកំណត់ Bean Scope](./assets/how-to-define-the-scope-of-a-bean.jpg "How to Define the Scope of a Bean")

## មាតិកា (Table of Contents)

- [1. តើ Bean Scope ជាអ្វី?](#1-តើ-bean-scope-ជាអ្វី)
- [2. របៀបកំណត់ Scope ក្នុងកូដជាក់ស្តែង](#2-របៀបកំណត់-scope-ក្នុងកូដជាក់ស្តែង)
- [3. ប្រភេទ Scopes ទាំង ៦ ក្នុង Spring Framework](#3-ប្រភេទ-scopes-ទាំង-៦-ក្នុង-spring-framework)
- [4. តារាងសង្ខេបវិសាលភាព (Scope Overview Table)](#4-តារាងសង្ខេបវិសាលភាព-scope-overview-table)

---

## 1. តើ Bean Scope ជាអ្វី?

**Bean Scope** គឺជាវិសាលភាព និងអាយុកាល (Lifecycle / Visibility) របស់ Instance មួយនៅក្នុង Spring IoC Container។ វាជាអ្នកកំណត់ថា៖
- តើ Spring ត្រូវបង្កើត Instance តែមួយគត់សម្រាប់ប្រើរួមគ្នាពេញទាំង Application ឬទេ?
- ឬមួយក៏ត្រូវបង្កើត Instance ថ្មីរៀងរាល់ពេលដែលមានការហៅប្រើប្រាស់?
- ឬមួយក៏បង្កើត Instance ថ្មីសម្រាប់រាល់ HTTP Request នីមួយៗ?

---

## 2. របៀបកំណត់ Scope ក្នុងកូដជាក់ស្តែង

ដើម្បីកំណត់ Bean Scope យើងមាន ២ ជម្រើសចម្បង៖

### ជម្រើសទី ១៖ ប្រើ `@Scope` Annotation (Java / Spring Boot)

```java
// វិធីទី ១: កំណត់លើ Class ផ្ទាល់
@Component
@Scope("prototype")
public class ReportGenerator {
    // នឹងបង្កើត Instance ថ្មីរាល់ពេលហៅ
}

// វិធីទី ២: កំណត់លើ @Bean Method ក្នុង @Configuration
@Configuration
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public NotificationService notificationService() {
        return new NotificationService();
    }
}
```

### ជម្រើសទី ២៖ ប្រើ attribute `scope` ក្នុង XML

```xml
<bean id="reportGenerator" class="com.example.ReportGenerator" scope="prototype"/>
```

---

## 3. ប្រភេទ Scopes ទាំង ៦ ក្នុង Spring Framework

Spring ផ្តល់នូវ Scopes ចំនួន ៦ (២ Scopes ទូទៅ និង ៤ Scopes សម្រាប់ Web Applications)៖

1. **`singleton` (Default):** បង្កើត Instance តែមួយគត់ក្នុង Spring IoC Container។
2. **`prototype`:** បង្កើត Instance ថ្មីស្រឡាងរាល់ពេលមានការស្នើសុំ (`getBean()`) ឬ Injection។
3. **`request` (Web Only):** បង្កើត Instance ថ្មីមួយសម្រាប់រាល់ **HTTP Request** នីមួយៗ ហើយបំផ្លាញចោលពេល Request បញ្ចប់។
4. **`session` (Web Only):** បង្កើត Instance មួយសម្រាប់រាល់ **HTTP Session** របស់អ្នកប្រើប្រាស់ (User Session)។
5. **`application` (Web Only):** បង្កើត Instance មួយសម្រាប់រាល់ **`ServletContext`** ទាំងមូលនៃ Web App។
6. **`websocket` (Web Only):** បង្កើត Instance មួយសម្រាប់វដ្តជីវិតនៃ **WebSocket Session** មួយ។

---

## 4. តារាងសង្ខេបវិសាលភាព (Scope Overview Table)

| Scope | បរិស្ថាន (Environment) | ចំនួន Instance ដែលបង្កើត |
| :--- | :--- | :--- |
| **`singleton`** | គ្រប់ទីកន្លែង (Standalone/Web) | **តែ ១ គត់** ពេញ Container (Default) |
| **`prototype`** | គ្រប់ទីកន្លែង (Standalone/Web) | **ច្រើន** (Instance ថ្មីរាល់ពេលហៅ) |
| **`request`** | Spring Web MVC | ១ សម្រាប់រាល់ **HTTP Request** |
| **`session`** | Spring Web MVC | ១ សម្រាប់រាល់ **HTTP Session** |
| **`application`** | Spring Web MVC | ១ សម្រាប់រាល់ **ServletContext** |

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 10: តើ Spring Bean ជាអ្វី?](../10-what-is-a-spring-bean/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 12: Default Bean Scope ក្នុង Spring Framework →](../12-default-bean-scope/README.kh.md) |
