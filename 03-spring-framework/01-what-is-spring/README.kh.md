# Part 1: តើ Spring Framework ជាអ្វី? (What Is Spring Framework?)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![តើ Spring Framework ជាអ្វី?](./assets/what-is-spring.jpg "What is Spring?")

## មាតិកា (Table of Contents)

- [1. និយមន័យនៃ Spring Framework](#1-និយមន័យនៃ-spring-framework)
- [2. ប្រវត្តិ និងប្រភពដើម (History & Origins)](#2-ប្រវត្តិ-និងប្រភពដើម-history--origins)
- [3. ហេតុអ្វីបានជា Spring ក្លាយជាជម្រើសលេខ ១ សម្រាប់ Java Backend?](#3-ហេតុអ្វីបានជា-spring-ក្លាយជាជម្រើសលេខ-១-សម្រាប់-java-backend)
- [4. ទស្សនវិជ្ជានៃ Spring Framework (Core Philosophy)](#4-ទស្សនវិជ្ជានៃ-spring-framework-core-philosophy)

---

## 1. និយមន័យនៃ Spring Framework

**Spring Framework** គឺជាកម្មវិធី Framework កម្រិត Enterprise ដ៏ពេញនិយមបំផុតសម្រាប់ភាសា Java ដែលរួមបញ្ចូលនូវគំនិតនៃការបង្កើត និងគ្រប់គ្រងនូវ Instances ទាំងអស់របស់ Class នីមួយៗ (ហៅថា **Spring Beans**) នៅក្នុងប្រព័ន្ធកម្មវិធី។

- មុខងារស្នូល (Core functionality) របស់ Spring អាចយកទៅប្រើប្រាស់ក្នុងការបង្កើតកម្មវិធី Java គ្រប់ប្រភេទ ចាប់ពី Desktop Applications រហូតដល់ Microservices និង Web APIs។
- សព្វថ្ងៃនេះ Spring ត្រូវបានគេនិយមប្រើប្រាស់ខ្លាំងបំផុតក្នុងការបង្កើត **Enterprise Web Applications** និង **RESTful Web Services**។
- Spring គឺជា **Open-Source Framework** ក្រោមអាជ្ញាបណ្ណ Apache 2.0 ដែលផ្តល់នូវហេដ្ឋារចនាសម្ព័ន្ធដ៏ទូលំទូលាយ ជួយឱ្យការអភិវឌ្ឍកម្មវិធី Java មានភាពរហ័ស ងាយស្រួល និងរៀបចំកូដបានស្អាតល្អ (Clean Code & Architecture)។

---

## 2. ប្រវត្តិ និងប្រភពដើម (History & Origins)

- Spring ត្រូវបានសរសេរ និងបង្កើតដំបូងឡើងដោយលោក **Rod Johnson** (អ្នកជំនាញខាងវិស្វកម្មសូហ្វវែរ និងតន្ត្រីករជនជាតិអូស្ត្រាលី)។
- នៅឆ្នាំ ២០០២ លោក Rod Johnson បានបោះពុម្ពសៀវភៅដ៏ល្បីល្បាញមួយក្បាលមានចំណងជើងថា *"Expert One-on-One J2EE Design and Development"* ដោយបានបង្ហាញនូវកូដគំរូ និងគំនិតបដិវត្តន៍ប្រឆាំងនឹងភាពស្មុគស្មាញហួសហេតុរបស់ Java 2 Enterprise Edition (J2EE) នៅសម័យនោះ (ជាពិសេសគឺ Enterprise JavaBeans ឬ EJB)។
- ដោយសារតែគំនិត និងកូដនោះមានភាពសាមញ្ញ និងមានប្រសិទ្ធភាពខ្ពស់ ក្រុមអ្នកអភិវឌ្ឍន៍ក៏បានសហការគ្នាអភិវឌ្ឍវាឱ្យក្លាយជា Open-Source Framework ពេញលេញមួយឈ្មោះថា **Spring** (តំណាងឱ្យការចាប់ផ្តើមថ្មីដ៏ស្រស់បំព្រងដូចរដូវផ្ការីក បន្ទាប់ពីរដូវរងារដ៏លំបាកនៃ J2EE)។
- Spring ត្រូវបានចេញផ្សាយជាផ្លូវការដំបូងនៅ **ខែមិថុនា ឆ្នាំ ២០០៣**។

---

## 3. ហេតុអ្វីបានជា Spring ក្លាយជាជម្រើសលេខ ១ សម្រាប់ Java Backend?

| ចំណុចប្រៀបធៀប | វិធីបុរាណ (Traditional Java / J2EE) | ដំណោះស្រាយរបស់ Spring Framework |
| :--- | :--- | :--- |
| **ការគ្រប់គ្រង Object** | សរសេរ `new Class()` ដោយដៃពេញកូដ | គ្រប់គ្រងតាមរយៈ **IoC Container** |
| **ការភ្ជាប់ទំនាក់ទំនង** | Tight Coupling (ជាប់ជំពាក់គ្នាស្អិត) | **Loose Coupling** តាមរយៈ Dependency Injection |
| **ការធ្វើ Unit Test** | លំបាកខ្លាំងក្នុងការ Mock Objects | ងាយស្រួលធ្វើ Mock និង Test គ្រប់ Component |
| **កូដ Boilerplate** | សរសេរបញ្ជា Database ស្ទួនៗ និងវែងអន្លាយ | ប្រើ Templates (ឧ. `JdbcTemplate`) និង Declarative Transactions |

---

## 4. ទស្សនវិជ្ជានៃ Spring Framework (Core Philosophy)

ទស្សនវិជ្ជាចម្បងរបស់ Spring គឺ **"Non-Invasive Development"** មានន័យថា៖
1. **POJO-Based:** កូដ Business Logic របស់អ្នកមិនចាំបាច់ Implement Interfaces ឬ Inherit Classes របស់ Spring ឡើយ — វាគឺជា Plain Old Java Objects (POJO) ធម្មតា។
2. **Focus on Business Logic:** Spring ទទួលខុសត្រូវលើហេដ្ឋារចនាសម្ព័ន្ធ (Connection, Security, Transactions) ទុកឱ្យ Developer ផ្តោតតែលើតម្រូវការអាជីវកម្ម (Business Requirements) សុទ្ធសាធ។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← វគ្គមុន: Advance Java](../../02-advance-java/18-interfaces/README.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 2: គុណសម្បត្តិរបស់ Spring Framework →](../02-advantages-of-spring/README.kh.md) |
