# មេរៀនទី ៩: ការប្រៀបធៀប Spring AOP និង AspectJ (Spring AOP vs AspectJ)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../08-aop-vs-oop/README.kh.md) | [មេរៀនបន្ទាប់ →](../../10-spring-boot-testing/01-unit-testing-junit/README.kh.md)

---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើម](#សេចក្តីផ្តើម)
2. [យន្តការ Proxy-based vs Bytecode Weaving](#យន្តការ)
3. [តារាងប្រៀបធៀប Spring AOP vs AspectJ](#តារាងប្រៀបធៀប)
4. [ពេលណាត្រូវជ្រើសរើសមួយណា?](#ការជ្រើសរើស)

---

## តារាងប្រៀបធៀប Spring AOP vs AspectJ

| លក្ខណៈពិសេស | Spring AOP | AspectJ |
| :--- | :--- | :--- |
| **គោលដៅ** | សាមញ្ញ ងាយស្រួលប្រើជាមួយ Spring IoC | Full-featured AOP Solution |
| **យន្តការអនុវត្ត** | Dynamic Proxies (JDK Proxy / CGLIB) | Bytecode Weaving (Compile, Post-compile, Load-time) |
| **Join Points** | គាំទ្រតែ Method Execution ប៉ុណ្ណោះ | គាំទ្រ Method, Field Access, Constructor, Object Creation |
| **Performance** | យឺតជាង AspectJ បន្តិច (Proxy Overhead) | លឿនបំផុត (Direct Bytecode) |
| **ភាពស្មុគស្មាញ** | ងាយស្រួល មិនបាច់ compile ពិសេស | ត្រូវមាន AspectJ Compiler (ajc) ឬ Java Agent |

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រៀបធៀប AOP និង OOP (Aspect-Oriented vs Object-Oriented Programming)](../08-aop-vs-oop/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការធ្វើតេស្តកម្មវិធី Spring Boot ជាមួយ JUnit 5 និង AssertJ (Unit Testing) →](../../10-spring-boot-testing/01-unit-testing-junit/README.kh.md) |
