# Part 12: Default Bean Scope ក្នុង Spring Framework (Default Bean Scope in Spring)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![Default Bean Scope ក្នុង Spring](./assets/what-is-the-default-bean-scope-in-spring-framework.jpg "What Is the Default Bean Scope in Spring Framework")

## មាតិកា (Table of Contents)

- [1. តម្លៃលំនាំដើមនៃ Bean Scope](#1-តម្លៃលំនាំដើមនៃ-bean-scope)
- [2. ហេតុអ្វីបានជា Spring ជ្រើសរើស Singleton ជា Default?](#2-ហេតុអ្វីបានជា-spring-ជ្រើសរើស-singleton-ជា-default)
- [3. ការអនុវត្តក្នុងកូដជាក់ស្តែង](#3-ការអនុវត្តក្នុងកូដជាក់ស្តែង)
- [4. បម្រុងប្រយ័ត្ន៖ Thread Safety លើ Singleton Bean](#4-បម្រុងប្រយ័ត្ន-thread-safety-លើ-singleton-bean)

---

## 1. តម្លៃលំនាំដើមនៃ Bean Scope

នៅក្នុង **Spring Framework** ប្រសិនបើអ្នកមិនបានបញ្ជាក់ `@Scope` ច្បាស់លាស់ទេនោះ៖
> **តម្លៃលំនាំដើម (Default Bean Scope) របស់ Spring Bean គឺ `singleton`។**

នេះមានន័យថា រាល់ `@Component`, `@Service`, `@Repository`, ឬ `@Bean` ទាំងអស់ដែលអ្នកបង្កើតឡើង នឹងត្រូវបាន Spring បង្កើតជា **Instance តែមួយគត់ (Single Shared Instance)** សម្រាប់ចែករំលែកប្រើប្រាស់រួមគ្នានៅទូទាំង Spring IoC Container ទាំងមូល។

---

## 2. ហេតុអ្វីបានជា Spring ជ្រើសរើស Singleton ជា Default?

Spring ជ្រើសរើសយក `singleton` ជា Default ដោយសារមូលហេតុសំខាន់ៗ ៣៖

1. **Memory Efficiency (សន្សំសំចៃ Memory ខ្ពស់):**
   - ក្នុង Web Application ដែលមានរាប់ពាន់ Requests ក្នុងមួយវិនាទី ប្រសិនបើរាល់ Request ត្រូវបង្កើត Service និង Repository ថ្មី នោះ Heap Memory នឹងត្រូវពេញភ្លាមៗ ហើយ Garbage Collector នឹងធ្វើការធ្ងន់ធ្ងរ។ ការប្រើ Instance តែមួយជួយសន្សំសំចៃ RAM បានច្រើនបំផុត។

2. **High Performance (ល្បឿនប្រតិបត្តិការលឿន):**
   - Bean ត្រូវបានបង្កើតទុកជាមុន (Pre-instantiated) ក្នុងអំឡុងពេល Startup ដូច្នេះនៅពេលមាន Client ហៅប្រើ ប្រព័ន្ធមិនចាំបាច់ចំណាយពេល Instantiate Object ថ្មីឡើយ។

3. **Stateless Service Architecture:**
   - ភាគច្រើននៃ Services, Repositories, និង Controllers ក្នុង Enterprise Apps គឺជា **Stateless** (គ្មានផ្ទុក State ឬទិន្នន័យអថេររបស់ User ម្នាក់ៗក្នុង Instance Variables ឡើយ) ដូច្នេះការចែករំលែក Instance តែមួយមានសុវត្ថិភាពឥតខ្ចោះ។

---

## 3. ការអនុវត្តក្នុងកូដជាក់ស្តែង

កូដទាំងពីរខាងក្រោមនេះមានប្រសិទ្ធភាពដូចគ្នាបេះបិទ ១០០%៖

```java
// វិធីទី ១៖ មិនដាក់ @Scope (Spring នឹងចាត់ទុកជា Singleton ដោយស្វ័យប្រវត្តិ)
@Service
public class PaymentService {
    // Singleton Bean
}

// វិធីទី ២៖ ដាក់ @Scope("singleton") ដោយច្បាស់លាស់ (Explicit)
@Service
@Scope("singleton")
public class PaymentService {
    // Singleton Bean ដូចគ្នា
}
```

---

## 4. បម្រុងប្រយ័ត្ន៖ Thread Safety លើ Singleton Bean

> ⚠️ **ការព្រមានសំខាន់សម្រាប់ Developer:**
> ដោយសារ Singleton Bean ត្រូវបានចែករំលែកប្រើប្រាស់ដោយ Threads ច្រើនក្នុងពេលតែមួយ (Multithreaded Environment ដូចជា Tomcat)៖
> - **ដាច់ខាតកុំរក្សាទុកទិន្នន័យ User (User State) ក្នុង Instance Variable របស់ Singleton Bean ឡើយ!**
> - Singleton Beans គួរតែជា **Stateless** ជានិច្ច (ប្រើប្រាស់តែ Method Arguments ឬ Local Variables ក្នុង Method)។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 11: របៀបកំណត់វិសាលភាព Bean Scope](../11-how-to-define-bean-scope/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 13: ការយល់ដឹងស៊ីជម្រៅអំពី Singleton Scope →](../13-singleton-scope/README.kh.md) |
