# មេរៀនទី ៤: ការដំឡើង និងបង្កើតគម្រោងលើ Spring Tool Suite (STS)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../03-spring-mvc-vs-spring-boot/README.md) | [មេរៀនបន្ទាប់ →](../05-eclipse-ide-setup/README.md)

## មាតិកា (Table of Contents)

- [1. អំពី Spring Tool Suite 4 (STS)](#1-អំពី-spring-tool-suite-4-sts)
- [2. របៀបដំឡើង STS](#2-របៀបដំឡើង-sts)
- [3. ជំហានបង្កើតគម្រោង Spring Boot ដំបូង](#3-ជំហានបង្កើតគម្រោង-spring-boot-ដំបូង)
- [4. ការដំណើរការ និងផ្ទៀងផ្ទាត់](#4-ការដំណើរការ-និងផ្ទៀងផ្ទាត់)
- [5. សង្ខេប](#5-សង្ខេប)

---

## 1. អំពី Spring Tool Suite 4 (STS)

**Spring Tool Suite 4 (STS)** គឺជា IDE ផ្លូវការដែលបង្កើតឡើងដោយក្រុមការងារ Spring ផ្អែកលើ Eclipse Foundation។ វាត្រូវបាន Optimized យ៉ាងពិសេសសម្រាប់ Spring Boot ដោយមានមុខងារដូចជា Code Completion សម្រាប់ Annotations, Live Hover Information, និង Spring Boot Dash View។

---

## 2. របៀបដំឡើង STS

1. ចូលទៅកាន់គេហទំព័រផ្លូវការ: `https://spring.io/tools`
2. ទាញយក Version ត្រូវនឹង OS របស់អ្នក (macOS, Windows, ឬ Linux)
3. Extract និងបើកដំណើរការកម្មវិធី

---

## 3. ជំហានបង្កើតគម្រោង Spring Boot ដំបូង

1. បើក STS រួចចុច **File -> New -> Spring Starter Project**

2. កំណត់ Project Metadata:
   - **Name:** `demo-sts-app`
   - **Type:** Maven
   - **Java Version:** 17 ឬ 21
   - **Packaging:** Jar
3. ជ្រើសរើស Dependencies សំខាន់ៗ:
   - **Spring Web** (`spring-boot-starter-web`)
   - **Spring Boot DevTools**
4. ចុច **Finish** រួចរង់ចាំ Maven ទាញយក Dependencies។

---

## 4. ការដំណើរការ និងផ្ទៀងផ្ទាត់

- ចុចកណ្ដុរស្ដាំលើ `DemoStsAppApplication.java` -> **Run As -> Spring Boot App**

- Console នឹងបង្ហាញ Spring Banner និងសារ `Tomcat started on port 8080 (http)`។

---

## 5. សង្ខេប

- STS ផ្តល់នូវបទពិសោធន៍រៀបចំគម្រោង Spring Boot ផ្លូវការលឿន និងឥតគិតថ្លៃ។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រៀបធៀប Spring MVC vs Spring Boot](../03-spring-mvc-vs-spring-boot/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការតម្លើង និងបង្កើតគម្រោងលើ Eclipse IDE →](../05-eclipse-ide-setup/README.md) |
