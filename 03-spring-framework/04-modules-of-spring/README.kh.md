# Part 4: ស្ថាបត្យកម្ម និង Modules របស់ Spring (Spring Modules Architecture)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![Modules របស់ Spring](./assets/what-are-modules-of-spring.jpg "What are modules of Spring")

## មាតិកា (Table of Contents)

- [1. ស្ថាបត្យកម្មតាមស្រទាប់របស់ Spring (Layered Architecture)](#1-ស្ថាបត្យកម្មតាមស្រទាប់របស់-spring-layered-architecture)
- [2. ការបកស្រាយលម្អិតនៃក្រុម Modules ទាំង ៥](#2-ការបកស្រាយលម្អិតនៃក្រុម-modules-ទាំង-៥)
- [3. តារាងសង្ខេបស្ថាបត្យកម្ម Modules](#3-តារាងសង្ខេបស្ថាបត្យកម្ម-modules)

---

## 1. ស្ថាបត្យកម្មតាមស្រទាប់របស់ Spring (Layered Architecture)

**Spring Framework** ត្រូវបានរចនាឡើងជាលក្ខណៈ **Modular Architecture** មានន័យថាវាបែងចែកមុខងារជាច្រើនទៅតាម Modules តូចៗដាច់ដោយឡែកពីគ្នា។ អត្ថប្រយោជន៍ដ៏អស្ចារ្យគឺ៖
> **អ្នកអាចជ្រើសរើសទាញយកតែ Module ណាដែលអ្នកត្រូវការប្រើប្រាស់ក្នុង Project ប៉ុណ្ណោះ ដោយមិនចាំបាច់ផ្ទុក Library ទាំងមូលដែលមិនពាក់ព័ន្ធឡើយ។**

---

## 2. ការបកស្រាយលម្អិតនៃក្រុម Modules ទាំង ៥

### 1. Spring Core Container (កុងតឺន័រស្នូល)
ជាគ្រឹះបាតក្រោមគេបង្អស់នៃ Framework រួមមាន ៤ Modules សំខាន់ៗ៖
- **`spring-core` & `spring-beans`:** ផ្តល់នូវមុខងារសំខាន់បំផុតគឺ **IoC (Inversion of Control)** និង **Dependency Injection (DI)**។
- **`spring-context`:** កសាងបន្ថែមលើ Core និង Beans ដោយបន្ថែមសមត្ថភាពគ្រប់គ្រង Lifecycle របស់ Objects, ការគាំទ្រ **I18n (Internationalization)**, ការផ្ញើ Events, និង Remoting។
- **`spring-expression` (SpEL):** ផ្តល់នូវភាសា Spring Expression Language សម្រាប់កំណត់តម្លៃ Property, ហៅ Methods, និង Query Object Graph ក្នុងពេល Runtime។

### 2. AOP, Aspects និង Instrumentation
- **`spring-aop`:** ផ្តល់នូវការសរសេរកូដបែប **Aspect-Oriented Programming** ដោយអនុញ្ញាតឱ្យយើងកំណត់ *Pointcuts* និង *Advices* ដើម្បីផ្តាច់កូដ Logging, Auditing, ឬ Security ចេញពី Business Logic។
- **`spring-aspects`:** ផ្តល់នូវការតភ្ជាប់ និងសមាហរណកម្មយ៉ាងពេញលេញជាមួយបណ្ណាល័យ **AspectJ** ដ៏ល្បីល្បាញ។
- **`spring-instrument`:** ផ្តល់នូវការគាំទ្រ Class Instrumentation និង ClassLoader សម្រាប់បំប្លែង Bytecode ក្នុង Application Server។

### 3. Data Access / Integration (ការតភ្ជាប់ទិន្នន័យ)
គ្រប់គ្រងរាល់ប្រតិបត្តិការ Database ទាំងអស់៖
- **`spring-jdbc`:** ផ្តល់នូវ `JdbcTemplate` ដែលកាត់បន្ថយ Boilerplate Code របស់ JDBC ដល់ទៅ ៨០%។
- **`spring-tx` (Transactions):** គ្រប់គ្រង Transactions ស្វ័យប្រវត្តិតាមរយៈ `@Transactional` ទាំង Declarative និង Programmatic។
- **`spring-orm`:** ភ្ជាប់ទំនាក់ទំនងជាមួយ ORM Frameworks ដូចជា Hibernate, JPA, និង JDO។
- **`spring-oxm`:** គាំទ្រការបំលែង Object ទៅជា XML និងច្រាសមកវិញ (JAXB, Castor, XMLBeans)។
- **`spring-jms`:** សម្រាប់ផលិត និងទទួល Messages តាមរយៈ Java Message Service។

### 4. Web Module (គេហទំព័រ និង APIs)
- **`spring-web`:** ផ្តល់មុខងារគ្រឹះសម្រាប់ Web ដូចជា Multipart File Upload, HTTP Client, និង ContextLoaderListener។
- **`spring-webmvc`:** ស្ថាបត្យកម្ម MVC (Model-View-Controller) ដ៏ពេញនិយមសម្រាប់បង្កើត Web Applications និង REST APIs។
- **`spring-websocket`:** គាំទ្រការប្រាស្រ័យទាក់ទងទ្វេទិស Real-time រវាង Client និង Server។

### 5. Test Module
- **`spring-test`:** គាំទ្រការធ្វើ Unit Testing និង Integration Testing យ៉ាងងាយស្រួលជាមួយ **JUnit**, **TestNG**, និងការ Mock នូវ Servlet Context។

---

## 3. តារាងសង្ខេបស្ថាបត្យកម្ម Modules

| ស្រទាប់ (Layer) | Modules សំខាន់ៗ | តួនាទីស្នូល |
| :--- | :--- | :--- |
| **Test** | `spring-test` | Unit & Integration testing ជាមួយ Mocks |
| **Web** | `web`, `webmvc`, `websocket` | REST Controllers, Views, Web Requests |
| **Data Access** | `jdbc`, `tx`, `orm`, `jms` | Database Queries, ORM Mapping, Transactions |
| **AOP** | `aop`, `aspects`, `instrument` | Cross-cutting concerns (Logs, Security) |
| **Core Container** | `core`, `beans`, `context`, `expression` | IoC Container, Bean Wiring, Lifecycle |

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 3: លក្ខណៈពិសេសរបស់ Spring Framework](../03-features-of-spring/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 5: កំណែទម្រង់ និងប្រវត្តិនៃ Spring Versions →](../05-versions-of-spring/README.kh.md) |
