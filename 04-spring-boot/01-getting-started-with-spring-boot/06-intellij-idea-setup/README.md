# មេរៀនទី ៦: ការបង្កើតគម្រោងជាមួយ IntelliJ IDEA (Community & Ultimate)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../05-eclipse-ide-setup/README.md) | [មេរៀនបន្ទាប់ →](../07-run-spring-boot-application/README.md)

## មាតិកា (Table of Contents)

- [1. ហេតុអ្វីបានជា IntelliJ IDEA ពេញនិយមបំផុត?](#1-ហេតុអ្វីបានជា-intellij-idea-ពេញនិយមបំផុត)
- [2. វិធីបង្កើតក្នុង IntelliJ IDEA Ultimate Edition](#2-វិធីបង្កើតក្នុង-intellij-idea-ultimate-edition)
- [3. វិធីបង្កើតក្នុង IntelliJ IDEA Community Edition (Free)](#3-វិធីបង្កើតក្នុង-intellij-idea-community-edition-free)
- [4. ការរៀបចំ Project Structure ឱ្យត្រឹមត្រូវ](#4-ការរៀបចំ-project-structure-ឱ្យត្រឹមត្រូវ)
- [5. សង្ខេប](#5-សង្ខេប)

---

## 1. ហេតុអ្វីបានជា IntelliJ IDEA ពេញនិយមបំផុត?

IntelliJ IDEA (បង្កើតដោយ JetBrains) គឺជា IDE លេខមួយដែលត្រូវបានប្រើប្រាស់ដោយ Java Software Engineers ជាង ៧០% ទូទាំងពិភពលោក ដោយសារតែ៖
- Smart Code Completion លឿនដូចផ្លេកបន្ទោរ
- ការវិភាគ Error និង Refactoring ដ៏មានឥទ្ធិពល
- ការគាំទ្រ Git និង Maven/Gradle យ៉ាងរលូន

---

## 2. វិធីបង្កើតក្នុង IntelliJ IDEA Ultimate Edition

1. ចុច **New Project**
2. ជ្រើសរើស **Spring Initializr** នៅ Sidebar ខាងឆ្វេង
3. កំណត់ Language: `Java`, Build: `Maven`, JDK: `17` ឬ `21`
4. ជ្រើសរើស Dependencies: `Spring Web`, `Lombok`, `DevTools`
5. ចុច **Create**

---

## 3. វិធីបង្កើតក្នុង IntelliJ IDEA Community Edition (Free)

ដោយសារ Community Edition មិនមាន Built-in Spring Initializr Wizard៖
1. បើក Browser ចូលទៅកាន់ `https://start.spring.io`
2. ជ្រើសរើស Maven, Java 17+, បន្ថែម Dependencies `Spring Web`
3. ចុច **GENERATE** ដើម្បីទាញយក `.zip` មកពន្លា (Unzip)
4. បើក IntelliJ IDEA -> ចុច **Open** -> ជ្រើសរើស Folder ដែលពន្លារួច -> ជ្រើសរើស **Open as Project**។

---

## 4. ការរៀបចំ Project Structure ឱ្យត្រឹមត្រូវ

```
demo-app/
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java          # Main Class (មាន @SpringBootApplication)
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── entity/
└── src/main/resources/
    └── application.yml               # Configuration
```

---

## 5. សង្ខេប

- IntelliJ IDEA គឺជាជម្រើសឈានមុខគេក្នុងឧស្សាហកម្មសម្រាប់អភិវឌ្ឍ Spring Boot។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការតម្លើង និងបង្កើតគម្រោងលើ Eclipse IDE](../05-eclipse-ide-setup/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [វិធីទាំង ៤ ក្នុងការ Run កម្មវិធី Spring Boot →](../07-run-spring-boot-application/README.md) |
