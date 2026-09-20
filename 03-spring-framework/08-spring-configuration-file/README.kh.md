# Part 8: ឯកសារ Spring Configuration (Spring Configuration File)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![Spring Configuration File](./assets/what-is-a-spring-configuration-file.jpg "What is a Spring configuration file")

## មាតិកា (Table of Contents)

- [1. តើ Spring Configuration File ជាអ្វី?](#1-តើ-spring-configuration-file-ជាអ្វី)
- [2. រចនាសម្ព័ន្ធនៃឯកសារ XML Configuration](#2-រចនាសម្ព័ន្ធនៃឯកសារ-xml-configuration)
- [3. របៀបដែល Spring Container អានឯកសារ Configuration](#3-របៀបដែល-spring-container-អានឯកសារ-configuration)
- [4. ការវិវត្តន៍ពី XML មកកាន់ Modern Java Configuration](#4-ការវិវត្តន៍ពី-xml-មកកាន់-modern-java-configuration)

---

## 1. តើ Spring Configuration File ជាអ្វី?

**Spring Configuration File** គឺជាឯកសារ (ជាទូទៅជាទម្រង់ **XML file** ដូចជា `applicationContext.xml` ឬ `beans.xml`) ដែលផ្ទុកនូវ **Metadata** សំខាន់ៗសម្រាប់ប្រាប់ទៅកាន់ Spring IoC Container អំពី៖
1. **Class Definitions:** តើ Class ណាខ្លះដែលត្រូវបង្កើតជា Beans?
2. **Relationships & Wiring:** តើ Bean មួយមានទំនាក់ទំនង និងពឹងផ្អែក (Dependencies) លើ Bean ណាខ្លះទៀត?
3. **Property Values:** តើតម្លៃអថេរណាខ្លះដែលត្រូវបញ្ចូលទៅក្នុង Bean ពេលបង្កើត?

វិធីនេះគឺជាផ្នែកមួយនៃវិធីសាស្ត្របុរាណហៅថា **XML-Based Configuration** នៅក្នុង Spring Framework។

---

## 2. រចនាសម្ព័ន្ធនៃឯកសារ XML Configuration

ឯកសារ XML ប្រើប្រាស់ root tag `<beans>` និងមាន tags `<bean>` នៅខាងក្នុង៖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 1. កំណត់ Bean សម្រាប់ UserRepository -->
    <bean id="userRepository" class="com.example.repository.UserRepositoryImpl" />

    <!-- 2. កំណត់ Bean សម្រាប់ UserService និង Inject UserRepository ចូល -->
    <bean id="userService" class="com.example.service.UserServiceImpl">
        <property name="userRepository" ref="userRepository" />
    </bean>

</beans>
```

- **`id` / `name`:** ឈ្មោះសម្គាល់ពិសេសរបស់ Bean ក្នុង Container។
- **`class`:** Full Qualified Name នៃ Java Class ដែលត្រូវ Instantiate។
- **`<property>`:** សម្រាប់កំណត់តម្លៃតាមរយៈ Setter Injection។
- **`<constructor-arg>`:** សម្រាប់កំណត់តម្លៃតាមរយៈ Constructor Injection។

---

## 3. របៀបដែល Spring Container អានឯកសារ Configuration

នៅក្នុងកូដ Java យើងប្រើប្រាស់ `ClassPathXmlApplicationContext` ដើម្បីផ្ទុកឯកសារ XML នេះ៖

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
UserService userService = context.getBean("userService", UserService.class);
```

---

## 4. ការវិវត្តន៍ពី XML មកកាន់ Modern Java Configuration

ទោះបីជា XML Configuration ធ្លាប់ជាវិធីស្តង់ដារក្នុងជំនាន់ Spring 1.x និង 2.x ក៏ដោយ បច្ចុប្បន្នវាត្រូវបានជំនួសដោយវិធីសាស្ត្រទំនើបជាង៖
- **Java-based Configuration (`@Configuration` & `@Bean`)**: ផ្តល់នូវ Type-safety និងងាយស្រួល Refactor។
- **Annotation-driven (`@Component`, `@Autowired`)**: ប្រើជាមួយ Component Scanning កាត់បន្ថយការសរសេរ Config ស្ទើរតែទាំងស្រុង។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 7: ប្រភេទនៃ IoC Containers](../07-types-of-ioc-container/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 9: វិធីទាំង ៣ ក្នុងការកំណត់ Config ក្នុង Spring →](../09-ways-to-configure-spring/README.kh.md) |
