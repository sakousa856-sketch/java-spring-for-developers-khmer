# មេរៀនទី ៣: ការប្រៀបធៀប Spring MVC vs Spring Boot
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../02-spring-vs-spring-boot/README.md) | [មេរៀនបន្ទាប់ →](../04-sts-project-setup/README.md)

## មាតិកា (Table of Contents)

- [1. ស្វែងយល់ពីតួនាទីខុសគ្នារវាង Spring MVC និង Spring Boot](#1-ស្វែងយល់ពីតួនាទីខុសគ្នារវាង-spring-mvc-និង-spring-boot)
- [2. តារាងប្រៀបធៀប (Comparison Matrix)](#2-តារាងប្រៀបធៀប)
- [3. របៀបដែល Spring Boot ប្រើប្រាស់ Spring MVC ក្នុងខ្លួន](#3-របៀបដែល-spring-boot-ប្រើប្រាស់-spring-mvc-ក្នុងខ្លួន)
- [4. សង្ខេប](#4-សង្ខេប)

---

## 1. ស្វែងយល់ពីតួនាទីខុសគ្នារវាង Spring MVC និង Spring Boot

សំណួរសម្ភាសន៍ការងារដ៏ពេញនិយម៖ *"តើ Spring MVC និង Spring Boot ខុសគ្នាយ៉ាងដូចម្តេច?"*
- **Spring MVC (Model-View-Controller):** គឺជា **Web Module** មួយរបស់ Spring Framework សម្រាប់បង្កើត Web Applications និង REST APIs តាមលំនាំស្ថាបត្យកម្ម MVC (Model, View, Controller)។
- **Spring Boot:** គឺជា **Application Bootstrapper** ដែលរុំព័ទ្ធប្រព័ន្ធទាំងមូល រួមទាំង Spring MVC ផងដែរ ដើម្បីឱ្យអ្នកអាច Run កម្មវិធីបានភ្លាមៗ។

---

## 2. តារាងប្រៀបធៀប

| ចំណុចប្រៀបធៀប | Spring MVC | Spring Boot |
| :--- | :--- | :--- |
| **ប្រភេទបច្ចេកវិទ្យា** | Web Presentation Framework | Complete Application Framework & Bootstrapper |
| **វិសាលភាព** | ដោះស្រាយតែ Web Request & Controller Layer | គ្រប់គ្រងប្រព័ន្ធទាំងមូល (Web, Data, Security, Cloud) |
| **Server** | ត្រូវការ External Server (Tomcat/WildFly) | បង្កប់ Server ក្នុងខ្លួនស្រាប់ |
| **Deployment** | WAR File | Standalone JAR File |
| **ទំនាក់ទំនង** | ជាផ្នែកមួយដែលរត់លើ Spring Boot | ជាអ្នកគ្រប់គ្រង និង Auto-configure លើ Spring MVC |

---

## 3. របៀបដែល Spring Boot ប្រើប្រាស់ Spring MVC ក្នុងខ្លួន

នៅពេលអ្នកបញ្ចូល `spring-boot-starter-web` ក្នុង `pom.xml` នោះ Spring Boot នឹងទាញយក **Spring MVC** និង **Jackson** មកដោយស្វ័យប្រវត្តិ ព្រមទាំងកំណត់ `DispatcherServlet` ឱ្យដំណើរការភ្លាមៗដោយអ្នកមិនបាច់សរសេរ `web.xml` មួយជួរឡើយ!

---

## 4. សង្ខេប

- Spring MVC គឺជាអ្នករៀបចំ Web Routing, Controllers, និង Views។
- Spring Boot គឺជាអ្នកវេចខ្ចប់ និងរៀបចំឱ្យ Spring MVC ដើរដោយស្វ័យប្រវត្តិ។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រៀបធៀប Spring Framework vs Spring Boot](../02-spring-vs-spring-boot/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការដំឡើង និងបង្កើតគម្រោងលើ Spring Tool Suite (STS) →](../04-sts-project-setup/README.md) |
