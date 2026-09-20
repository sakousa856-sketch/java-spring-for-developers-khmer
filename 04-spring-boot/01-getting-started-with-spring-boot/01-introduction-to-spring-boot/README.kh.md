# មេរៀនទី ១: សេចក្តីផ្តើមអំពី Spring Boot (What Is Spring Boot?)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../README.kh.md) | [មេរៀនបន្ទាប់ →](../02-spring-vs-spring-boot/README.kh.md)

## មាតិកា (Table of Contents)

- [1. និយមន័យនៃ Spring Boot](#1-និយមន័យនៃ-spring-boot)
- [2. ហេតុអ្វីបានជាមានវត្តមាន Spring Boot?](#2-ហេតុអ្វីបានជាមានវត្តមាន-spring-boot)
- [3. សសរទ្រូងសំខាន់ៗទាំង ៤ របស់ Spring Boot](#3-សសរទ្រូងសំខាន់ៗទាំង-៤-របស់-spring-boot)
- [4. ការប្រៀបធៀប៖ Spring Framework vs Spring Boot](#4-ការប្រៀបធៀប-spring-framework-vs-spring-boot)
- [5. កូដគំរូដំបូងបង្អស់ជាមួយ Spring Boot](#5-កូដគំរូដំបូងបង្អស់ជាមួយ-spring-boot)

---

## 1. និយមន័យនៃ Spring Boot

**Spring Boot** គឺជាបច្ចេកវិទ្យា Open-Source ដែលត្រូវបានកសាងឡើងបន្ថែមនៅលើ **Spring Framework** ដើម្បីជួយឱ្យការបង្កើតកម្មវិធី **Production-Ready Spring Applications** និង **Microservices** មានភាពរហ័ស ងាយស្រួល និងកាត់បន្ថយការកំណត់ Configuration ស្ទើរតែទាំងស្រុង។

ទស្សនវិជ្ជាចម្បងរបស់ Spring Boot គឺ៖
> **"Opinionated View" & "Convention over Configuration"**
> (Spring Boot មានទស្សនៈច្បាស់លាស់ពីការរៀបចំកូដ និងកំណត់តម្លៃលំនាំដើមដ៏សមស្របបំផុតរួចជាស្រេចសម្រាប់អ្នក ដោយអ្នកគ្រាន់តែសរសេរ Business Logic បន្ថែមប៉ុណ្ណោះ)។

---

## 2. ហេតុអ្វីបានជាមានវត្តមាន Spring Boot?

កាលពីជំនាន់ប្រើប្រាស់ **Spring Framework សុទ្ធ** អ្នកអភិវឌ្ឍន៍ត្រូវចំណាយពេលច្រើនម៉ោង ឬច្រើនថ្ងៃដើម្បី Setup គម្រោងថ្មីមួយ៖
- ត្រូវកំណត់ XML Configuration ឬ Java Config វែងអន្លាយ
- ត្រូវគ្រប់គ្រង Dependency Versions និងជួបបញ្ហា Jar Version Conflict
- ត្រូវដំឡើង Apache Tomcat Server ខាងក្រៅ រួច Build ជា `.war` file ដើម្បីយកទៅ Deploy
- ត្រូវសរសេរកូដ Boilerplate ជាច្រើនសម្រាប់ភ្ជាប់ Database ឬ Web Dispatcher

**Spring Boot** ត្រូវបានបង្កើតឡើងដើម្បីលុបបំបាត់រាល់ឧបសគ្គទាំងនេះ ដោយធ្វើឱ្យអ្នកអាចចាប់ផ្តើមសរសេរ និងដំណើរការ Project បានក្នុងរយៈពេលត្រឹមតែ **ប៉ុន្មានវិនាទី** ប៉ុណ្ណោះ!

---

## 3. សសរទ្រូងសំខាន់ៗទាំង ៤ របស់ Spring Boot

1. **Auto-Configuration (ការកំណត់ស្វ័យប្រវត្តិតាមបរិបទ):**
   - តាមរយៈ `@EnableAutoConfiguration` Spring Boot ពិនិត្យមើល Classpath — ប្រសិនបើឃើញ `h2.jar` ឬ `mysql-connector.jar` វានឹងរៀបចំ DataSource និង Connection Pool ឱ្យដោយស្វ័យប្រវត្តិ។

2. **Starter Dependencies (កញ្ចប់បណ្ណាល័យសម្រេច):**
   - ជំនួសឱ្យការ Add Dependencies ដាច់ដោយឡែករាប់សិប អ្នកគ្រាន់តែហៅ Starter មួយគត់ (ឧ. `spring-boot-starter-web`) នោះវានឹងទាញយក Tomcat, Jackson JSON, Spring Web, Spring MVC មកដោយស្វ័យប្រវត្តិ ធានាថាកំណែទាំងអស់ត្រូវគ្នាបេះបិទ។

3. **Embedded Web Servers (Web Server បង្កប់ស្រាប់ក្នុង App):**
   - Spring Boot បង្កប់ **Tomcat**, **Jetty**, ឬ **Undertow** មកជាមួយស្រាប់ក្នុង `.jar` ឯករាជ្យ។ អ្នកគ្រាន់តែ Run `java -jar app.jar` នោះ Server នឹងបើកដំណើរការភ្លាមៗ ដោយមិនបាច់ដំឡើង Server ខាងក្រៅឡើយ។

4. **Spring Boot Actuator (ប្រព័ន្ធតាមដានសុខភាពកម្រិត Production):**
   - ផ្តល់នូវ Endpoints ស្រាប់ៗសម្រាប់ Monitor សុខភាពប្រព័ន្ធ (`/actuator/health`), CPU/RAM Metrics (`/actuator/metrics`), និង Environment Configurations។

---

## 4. ការប្រៀបធៀប៖ Spring Framework vs Spring Boot

| ចំណុចប្រៀបធៀប | Spring Framework | Spring Boot |
| :--- | :--- | :--- |
| **គោលបំណង** | ផ្តល់នូវ IoC, DI, និង Enterprise Architecture | ធ្វើឱ្យការបង្កើត Spring Apps មានល្បឿនលឿន |
| **ការកំណត់ Configuration** | សរសេរ XML ឬ `@Configuration` ច្រើន | **Auto-Configuration ស្ទើរតែ ១០០%** |
| **Server Deployment** | ត្រូវការ External Server (Tomcat WAR) | **Embedded Tomcat/Jetty រួចជាស្រេច (Standalone JAR)** |
| **ការគ្រប់គ្រង Dependency** | ត្រូវជ្រើសរើស Version ដោយដៃ | ប្រើប្រាស់ **Starters & BOM** គ្មាន Version Conflict |
| **Production Monitoring** | ត្រូវសរសេរកូដ Monitor ខ្លួនឯង | មាន **Spring Boot Actuator** ស្រាប់ |

---

## 5. កូដគំរូដំបូងបង្អស់ជាមួយ Spring Boot

អ្នកគ្រាន់តែសរសេរ Java Class មួយប៉ុណ្ណោះ គឺអាចបើក REST API បានភ្លាមៗ៖

```java
@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/hello")
    public String hello() {
        return "សួស្តីពី Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```


---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← មាតិកា Module](../README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការប្រៀបធៀប Spring Framework vs Spring Boot →](../02-spring-vs-spring-boot/README.kh.md) |
