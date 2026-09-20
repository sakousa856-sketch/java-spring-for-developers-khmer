# មេរៀនទី ៨: បង្កើនល្បឿនអភិវឌ្ឍន៍ជាមួយ Spring Boot DevTools (Developer Tools)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../07-spring-boot-actuator/README.kh.md) | [មេរៀនបន្ទាប់ →](../../04-spring-boot-with-rest-api/01-intro-to-restful-web-services/README.kh.md)

## មាតិកា (Table of Contents)

- [1. តើ Spring Boot DevTools ជាអ្វី?](#1-តើ-spring-boot-devtools-ជាអ្វី)
- [2. មុខងារសំខាន់ៗទាំង ៤ របស់ DevTools](#2-មុខងារសំខាន់ៗទាំង-៤-របស់-devtools)
- [3. យន្តការ Restart ក្នុងរង្វង់វិនាទី (Two-ClassLoader Mechanism)](#3-យន្តការ-restart-ក្នុងរង្វង់វិនាទី-two-classloader-mechanism)
- [4. សុវត្ថិភាពពេលឡើង Production (Production Safety)](#4-សុវត្ថិភាពពេលឡើង-production-production-safety)
- [5. របៀបបញ្ចូល DevTools ក្នុង `pom.xml`](#5-របៀបបញ្ចូល-devtools-ក្នុង-pomxml)

---

## 1. តើ Spring Boot DevTools ជាអ្វី?

នៅក្នុងការអភិវឌ្ឍប្រចាំថ្ងៃ រាល់ពេលដែលអ្នកកែ Code មួយជួរ ហើយត្រូវចំណាយពេល ១០–២០ វិនាទីដើម្បី Stop Server រួច Start ឡើងវិញ វានឹងធ្វើឱ្យខាតបង់ពេលវេលា និងរំខានដល់អារម្មណ៍សរសេរកូដ (Development Flow) យ៉ាងខ្លាំង។

**`spring-boot-devtools`** គឺជា Module ពិសេសមួយដែលត្រូវបានរចនាឡើងដើម្បីជួយឱ្យ Developer អាចអភិវឌ្ឍកម្មវិធីបានលឿនដូចផ្លេកបន្ទោរ តាមរយៈការ **Restart ស្វ័យប្រវត្តិក្នងរង្វង់ត្រឹមតែ ១ វិនាទី** នៅពេលកូដត្រូវបាន Save!

---

## 2. មុខងារសំខាន់ៗទាំង ៤ របស់ DevTools

1. **Automatic Restart (ដំណើរការឡើងវិញស្វ័យប្រវត្តិ):**
   - នៅពេលណាអ្នកកែប្រែកូដ Java ហើយ Save ឬ Compile នោះ DevTools នឹងធ្វើការ Restart Application ឡើងវិញភ្លាមៗដោយស្វ័យប្រវត្តិ។

2. **LiveReload (Refresh Browser ស្វ័យប្រវត្តិ):**
   - បង្កប់ LiveReload Server មកជាមួយស្រាប់។ ប្រសិនបើអ្នកកែប្រែ HTML (Thymeleaf), CSS, ឬ JS នោះ Browser របស់អ្នកនឹង Refresh ខ្លួនឯងភ្លាមៗដោយមិនបាច់ចុច F5 ឡើយ។

3. **Development Property Defaults (បិទ Cache ពេល Dev):**
   - ក្នុងពេល Production យើងត្រូវការ Cache ទំព័រ HTML ឬ Data ដើម្បីល្បឿនលឿន។ ប៉ុន្តែក្នុងពេល Development យើងត្រូវការឃើញការផ្លាស់ប្តូរភ្លាមៗ។ DevTools នឹងបិទ Cache (ដូចជា `spring.thymeleaf.cache=false`) ដោយស្វ័យប្រវត្តិ។

4. **Global Configurations:**
   - អាចកំណត់ Configuration សម្រាប់ម៉ាស៊ីនផ្ទាល់ខ្លួនក្នុង `~/.spring-boot-devtools.properties` ដែលមិនប៉ះពាល់ដល់ Git Repo របស់ក្រុមការងារ។

---

## 3. យន្តការ Restart ក្នុងរង្វង់វិនាទី (Two-ClassLoader Mechanism)

ហេតុអ្វីបានជា DevTools Restart លឿនជាងការចុច Run ធម្មតា?
Spring Boot ប្រើប្រាស់ ClassLoaders ចំនួន ២ ផ្សេងគ្នា៖

```
┌────────────────────────────────────────────────────────┐
│ 1. Base ClassLoader (មិនផ្លាស់ប្តូរ)                    │
│    - ផ្ទុក Third-party JARs (Spring, Hibernate, Tomcat) │
│    - ផ្ទុកម្តងគត់ មិនដែល Reload ឡើយ                   │
└────────────────────────────────────────────────────────┘
                           ▲
                           │ ភ្ជាប់ជាមួយ
┌──────────────────────────┴─────────────────────────────┐
│ 2. Restart ClassLoader (បោះចោល និងបង្កើតថ្មីភ្លាមៗ)    │
│    - ផ្ទុកតែកូដដែលអ្នកកំពុងសរសេរក្នុង Project           │
│    - ពេលកែ Code វានឹងបោះចោលចាស់ បង្កើតថ្មីក្នុង < 1s   │
└────────────────────────────────────────────────────────┘
```

---

## 4. សុវត្ថិភាពពេលឡើង Production (Production Safety)

> 🛡️ **ចំណុចពិសេសបំផុតនៃ DevTools:**
> នៅពេលអ្នក Build Project ជា `.jar` ឬ `.war` ដើម្បីយកទៅ Deploy លើ Production Server (តាមរយៈ `java -jar app.jar`) នោះ **DevTools នឹងបិទដំណើរការខ្លួនឯងដោយស្វ័យប្រវត្តិ (Disabled)** ដើម្បីធានាថាកម្មវិធីដំណើរការដោយស្ថេរភាព និងល្បឿនលឿនបំផុត។

---

## 5. របៀបបញ្ចូល DevTools ក្នុង `pom.xml`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

*(កំណត់ `<optional>true</optional>` ដើម្បីកុំឱ្យ DevTools ឆ្លងទៅកាន់ Projects ផ្សេងទៀតដែលទាញយក Project នេះជា Dependency)*។


---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការត្រួតពិនិត្យសុខភាពប្រព័ន្ធ និង Monitoring ជាមួយ Spring Boot Actuator](../07-spring-boot-actuator/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [សេចក្តីផ្តើមអំពី RESTful Web Services (Introduction to RESTful Web Services) →](../../04-spring-boot-with-rest-api/01-intro-to-restful-web-services/README.kh.md) |
