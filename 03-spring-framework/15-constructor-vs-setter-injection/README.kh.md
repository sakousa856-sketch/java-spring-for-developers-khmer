# Part 15: ការប្រៀបធៀប Constructor vs Setter Injection (Constructor vs Setter Injection)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![Constructor vs Setter Injection](./assets/what-is-the-difference-between-constructor-injection-and-setter-injection.jpg "What is the difference between constructor injection and setter injection")

## មាតិកា (Table of Contents)

- [1. សេចក្តីផ្តើម](#1-សេចក្តីផ្តើម)
- [2. ភាពខុសគ្នាសំខាន់ៗទាំង ៥](#2-ភាពខុសគ្នាសំខាន់ៗទាំង-៥)
- [3. តារាងប្រៀបធៀបលម្អិត (Detailed Comparison Table)](#3-តារាងប្រៀបធៀបលម្អិត-detailed-comparison-table)
- [4. ករណីសិក្សា៖ ពេលណាគួរប្រើមួយណា?](#4-ករណីសិក្សា-ពេលណាគួរប្រើមួយណា)

---

## 1. សេចក្តីផ្តើម

នៅក្នុង Spring Framework ទោះបីជាយើងអាចប្រើប្រាស់ Field Injection បានក៏ដោយ ក៏ **Constructor Injection** និង **Setter Injection** គឺជាវិធីសាស្ត្រ ២ ដែលត្រូវបានពិភាក្សា និងសួរដេញដោលច្រើនបំផុតក្នុងវិស្វកម្មសូហ្វវែរ។ ការយល់ច្បាស់ពីភាពខុសគ្នារវាងវិធីទាំងពីរនេះ ជួយឱ្យអ្នកអាចរចនា Class ឱ្យមានស្ថេរភាព និងសុវត្ថិភាពខ្ពស់។

---

## 2. ភាពខុសគ្នាសំខាន់ៗទាំង ៥

### 1. Mandatory vs. Optional Dependencies (ភាពចាំបាច់នៃ Dependency)
- **Constructor Injection:** សមស្របសម្រាប់ **Mandatory Dependencies** (dependencies ណាដែលខ្វះមិនបាន)។ Class មិនអាចត្រូវបានបង្កើតឡើយប្រសិនបើគ្មាន Dependency នោះ។
- **Setter Injection:** សមស្របសម្រាប់ **Optional Dependencies** (dependencies ណាដែលមានក៏បាន អត់ក៏បាន ឬមាន default value ស្រាប់)។

### 2. Immutability (ភាពមិនអាចប្រែប្រួល)
- **Constructor Injection:** អនុញ្ញាតឱ្យយើងប្រកាស Field ជា **`final`** (ឧ. `private final PaymentService service;`)។ នៅពេល Bean ត្រូវបានបង្កើតរួច គ្មាននរណាអាចផ្លាស់ប្តូរ Reference របស់វាបានឡើយ ដែលធានាបាននូវ Thread Safety ខ្ពស់បំផុត។
- **Setter Injection:** មិនអាចប្រើប្រាស់ពាក្យគន្លឹះ `final` បានទេ ព្រោះ Setter Method ត្រូវហៅក្រោយពេល Constructor ដំណើរការចប់។

### 3. Dependency Overriding (ការសរសេរជាន់ពីលើ)
- ប្រសិនបើយើងប្រកាសទាំង Constructor Injection និង Setter Injection សម្រាប់ Dependency ដូចគ្នា នោះ **Setter Injection នឹងដំណើរការក្រោយគេ និងសរសេរជាន់ (Override) លើតម្លៃដែលបាន Inject តាម Constructor**។

### 4. ភាពបត់បែនក្នុងការកែប្រែតម្លៃ (Re-injection)
- **Setter Injection:** អនុញ្ញាតឱ្យយើងផ្លាស់ប្តូរ Dependency នៅពេលក្រោយ (Runtime) ដោយគ្រាន់តែហៅ Setter method ឡើងវិញ ដោយមិនចាំបាច់បង្កើត Instance ថ្មីឡើយ។
- **Constructor Injection:** មិនអាចផ្លាស់ប្តូរបានទេ លុះត្រាតែបង្កើត Object ថ្មី។

### 5. Circular Dependency (ការពឹងផ្អែកវិលជុំ)
- ប្រសិនបើ Class A ត្រូវការ Class B ហើយ Class B ត្រូវការ Class A វិញ៖
  - **Constructor Injection:** នឹងបង្កជាកំហុស `BeanCurrentlyInCreationException` នៅពេល Application ចាប់ផ្តើម។
  - **Setter Injection:** អាចដំណើរការបានដោយសារ Spring បង្កើត Objects ជាមុន រួចទើប Inject តាម Setter ជាក្រោយ (ទោះជាយ៉ាងណា Circular Dependency គឺជា Bad Design)។

---

## 3. តារាងប្រៀបធៀបលម្អិត (Detailed Comparison Table)

| លក្ខណៈវិនិច្ឆ័យ | Constructor Injection | Setter Injection |
| :--- | :--- | :--- |
| **ប្រភេទ Dependency** | **Mandatory (ខ្វះមិនបាន)** | **Optional (មានក៏បាន អត់ក៏បាន)** |
| **ការគាំទ្រពាក្យ `final`** | ✅ **គាំទ្រ (Immutable)** | ❌ មិនគាំទ្រ (Mutable) |
| **សុវត្ថិភាព NullPointer** | ✅ ធានាគ្មាន `NullPointerException` | ⚠️ អាចជួប Null បើភ្លេច Inject |
| **Overriding Priority** | ដំណើរការមុន | ដំណើរការក្រោយ (ជាន់លើ Constructor) |
| **ភាពងាយស្រួល Unit Test** | ✅ ងាយស្រួលបំផុត (`new Service(mock)`) | មធ្យម (ត្រូវហៅ `set...()` បន្ថែម) |
| **ការណែនាំពី Spring Team** | **⭐⭐⭐⭐⭐ ណែនាំខ្ពស់បំផុត** | ⭐⭐⭐ ប្រើសម្រាប់តែករណីពិសេស |

---

## 4. ករណីសិក្សា៖ ពេលណាគួរប្រើមួយណា?

- **ប្រើ Constructor Injection ជាជម្រើសចម្បង (Default Choice):** សម្រាប់ ៩៥% នៃ Services, Repositories, និង Components របស់អ្នក ដើម្បីធានាបាននូវកូដរឹងមាំ និង Immutability។
- **ប្រើ Setter Injection:** លុះត្រាតែ Dependency នោះជាជម្រើសបន្ថែម (Optional) ឬអាចផ្លាស់ប្តូរ Configuration ក្នុងអំឡុងពេល Runtime។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 14: តើ Dependency Injection (DI) ជាអ្វី?](../14-what-is-dependency-injection/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 16: វិធីសាស្រ្តល្អបំផុតក្នុងការ Inject Beans & ហេតុផល →](../16-best-way-of-injecting-beans/README.kh.md) |
