# មេរៀនទី ៣: ការប្រៀបធៀប BeanFactory vs ApplicationContext

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../02-dependency-injection/README.kh.md) | [មេរៀនបន្ទាប់ →](../04-spring-bean-lifecycle/README.kh.md)

## មាតិកា (Table of Contents)

- [1. ឋានានុក្រមនៃ Spring IoC Containers](#1-ឋានានុក្រមនៃ-spring-ioc-containers)
- [2. តារាងប្រៀបធៀបលម្អិត](#2-តារាងប្រៀបធៀបលម្អិត)
- [3. Lazy Loading vs Eager Loading](#3-lazy-loading-vs-eager-loading)
- [4. សង្ខេប](#4-សង្ខេប)

---

## 1. ឋានានុក្រមនៃ Spring IoC Containers

Spring ផ្តល់នូវ Container Implementation ពីរថ្នាក់ធំៗ៖
```
       BeanFactory (Interface មូលដ្ឋាន)
               ▲
               │ extends
      ApplicationContext (Interface កម្រិតខ្ពស់)
```

---

## 2. តារាងប្រៀបធៀបលម្អិត

| លក្ខណៈវិនិច្ឆ័យ | `BeanFactory` | `ApplicationContext` |
| :--- | :--- | :--- |
| **កម្រិត Abstraction** | Basic Container (គ្រឹះស្រាល) | Advanced Enterprise Container |
| **យន្តការ Loading** | **Lazy Loading:** បង្កើត Bean តែពេលណាមានការហៅ `getBean()` | **Eager Loading:** បង្កើត Singleton Beans ទាំងអស់ភ្លាមៗពេល App ចាប់ផ្តើម |
| **AOP Integration** | ពិបាកកំណត់រចនាសម្ព័ន្ធ | គាំទ្រ AOP, `@Aspect` មកជាមួយស្រាប់ |
| **Event Handling** | មិនគាំទ្រ | គាំទ្រ Application Events (`ApplicationEventPublisher`) |
| **i18n (Internationalization)** | មិនគាំទ្រ | គាំទ្រពហុភាសា (`MessageSource`) |
| **កាលៈទេសៈប្រើប្រាស់** | ឧបករណ៍តូចៗ Memory តិចបំផុត (IoT / Mobile) | **គ្រប់កម្មវិធី Enterprise និង Spring Boot ទាំងអស់** |

---

## 3. Lazy Loading vs Eager Loading

- **BeanFactory (Lazy):** កម្មវិធី Start លឿន ប៉ុន្តែបើសិនមានកំហុសខ្វះ Class ឬ Config ខុស វានឹងផ្ទុះ Error នៅពេលដែល User កំពុងប្រើប្រាស់ជាក់ស្តែង (Runtime Failure)។
- **ApplicationContext (Eager):** កម្មវិធីចំណាយពេល Startup បន្តិចដើម្បីបង្កើត Beans ទាំងអស់។ បើសិនមានបញ្ហា Config វាផ្ទុះ Error ពេល Start ភ្លាម (Fail-fast) ដែលការពារកុំឱ្យឡើងទៅខូចលើ Production!

---

## 4. សង្ខេប

- Spring Boot ប្រើប្រាស់ **`ApplicationContext`** (ជាក់ស្តែងគឺ `AnnotationConfigServletWebServerApplicationContext`) ជាលំនាំដើមជានិច្ច។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការយល់ដឹងស៊ីជម្រៅអំពី Dependency Injection (DI)](../02-dependency-injection/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [វដ្តជីវិតរបស់ Spring Bean (Spring Bean Lifecycle) →](../04-spring-bean-lifecycle/README.kh.md) |
