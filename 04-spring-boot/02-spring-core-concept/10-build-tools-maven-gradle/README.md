# មេរៀនទី ១០: ការប្រើប្រាស់ Build Tools ជាមួយ Spring (Maven & Gradle)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../09-dispatcherservlet/README.md) | [មេរៀនបន្ទាប់ →](../../03-spring-boot-core-features/01-spring-boot-architecture/README.md)

## មាតិកា (Table of Contents)

- [1. តើ Build Tool ជាអ្វី?](#1-តើ-build-tool-ជាអ្វី)
- [2. ការប្រៀបធៀប Apache Maven vs Gradle](#2-ការប្រៀបធៀប-apache-maven-vs-gradle)
- [3. រចនាសម្ព័ន្ធ `pom.xml` ក្នុង Maven](#3-រចនាសម្ព័ន្ធ-pomxml)
- [4. រចនាសម្ព័ន្ធ `build.gradle` ក្នុង Gradle](#4-រចនាសម្ព័ន្ធ-buildgradle)
- [5. សង្ខេប](#5-សង្ខេប)

---

## 1. តើ Build Tool ជាអ្វី?

Build Tool គឺជាកម្មវិធីស្វ័យប្រវត្តិកម្មដែលទទួលបន្ទុក៖
- ទាញយក External Libraries (Dependencies) ពី Central Repository
- Compile កូដ Java ទៅជា `.class` Bytecode
- ដំណើរការ Automated Unit Tests
- វេចខ្ចប់ជា Executable JAR ឬ WAR

---

## 2. ការប្រៀបធៀប Apache Maven vs Gradle

| លក្ខណៈវិនិច្ឆ័យ | Apache Maven | Gradle |
| :--- | :--- | :--- |
| **ភាសាកំណត់ (Config DSL)** | XML (`pom.xml`) | Groovy ឬ Kotlin DSL (`build.gradle.kts`) |
| **ល្បឿន Build** | មធ្យម (ដំណើរការ Sequential) | លឿនខ្លាំង (Build Cache & Daemon Parallelism) |
| **ភាពពេញនិយមក្នុង Enterprise** | ពេញនិយមខ្លាំង (ស្ថេរភាព និង Predictable) | ពេញនិយមខ្លាំងក្នុងគម្រោងធំៗ និង Android |
| **Learning Curve** | ងាយស្រួលយល់ | ពិបាកជាងបន្តិច |

---

## 3. រចនាសម្ព័ន្ធ `pom.xml` ក្នុង Maven

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

---

## 4. រចនាសម្ព័ន្ធ `build.gradle` ក្នុង Gradle

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```

---

## 5. សង្ខេប

- Maven ផ្តល់នូវភាពងាយស្រួល ស្ថេរភាព និងងាយស្រួលថែទាំ។
- Gradle ផ្តល់នូវល្បឿន Build លឿន និងភាពបត់បែនខ្ពស់តាមកូដ Script។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ](../09-dispatcherservlet/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ស្ថាបត្យកម្មខាងក្នុងរបស់ Spring Boot (Spring Boot Architecture) →](../../03-spring-boot-core-features/01-spring-boot-architecture/README.md) |
