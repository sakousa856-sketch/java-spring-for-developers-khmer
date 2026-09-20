# Part 9: វិធីទាំង ៣ ក្នុងការកំណត់ Config ក្នុង Spring (3 Ways to Configure Spring)
![វិធីទាំង ៣ ក្នុងការកំណត់ Config ក្នុង Spring](./assets/how-many-ways-are-there-to-configure-the-spring.jpg "How many ways are there to configure the Spring")

## មាតិកា (Table of Contents)

- [1. ទិដ្ឋភាពទូទៅនៃវិធីកំណត់ Configuration](#1-ទិដ្ឋភាពទូទៅនៃវិធីកំណត់-configuration)
- [2. វិធីទី ១៖ XML-Based Configuration](#2-វិធីទី-១-xml-based-configuration)
- [3. វិធីទី ២៖ Java-Based Configuration](#3-វិធីទី-២-java-based-configuration)
- [4. វិធីទី ៣៖ Annotation-Based Configuration](#4-វិធីទី-៣-annotation-based-configuration)
- [5. តារាងប្រៀបធៀបវិធីទាំង ៣ (Comparison Table)](#5-តារាងប្រៀបធៀបវិធីទាំង-៣-comparison-table)

---

## 1. ទិដ្ឋភាពទូទៅនៃវិធីកំណត់ Configuration

នៅក្នុង **Spring Framework** អ្នកអភិវឌ្ឍន៍មានជម្រើស ៣ យ៉ាងក្នុងការកំណត់ និងប្រាប់ទៅកាន់ IoC Container អំពី Beans និង Dependencies៖

1. **XML-Based Configuration** (វិធីសាស្ត្រជំនាន់មុន)
2. **Java-Based Configuration** (វិធីសាស្ត្រ Type-Safe តាមរយៈ Java Code)
3. **Annotation-Based Configuration** (វិធីសាស្ត្រស្វ័យប្រវត្តិតាម Stereotype Annotations)

---

## 2. វិធីទី ១៖ XML-Based Configuration

កំណត់ឈ្មោះ Class និង Properties នៅក្នុងឯកសារ XML ដាច់ដោយឡែក៖

```xml
<beans>
    <bean id="accountService" class="com.example.service.AccountServiceImpl">
        <property name="accountRepository" ref="accountRepository"/>
    </bean>
    <bean id="accountRepository" class="com.example.repository.AccountRepositoryImpl"/>
</beans>
```

- **គុណសម្បត្តិ:** បំបែក Config ដាច់ស្រឡះពីកូដ Java អាចកែប្រែដោយមិនបាច់ Recompile កូដ។
- **គុណវិបត្តិ:** គ្មាន Type-Safety, ងាយសរសេរខុសអក្ខរាវិរុទ្ធ (Typo), ឯកសារ XML វែងពិបាកថែទាំ។

---

## 3. វិធីទី ២៖ Java-Based Configuration

ប្រើប្រាស់ Java Class ធម្មតា ដោយដាក់ `@Configuration` ពីលើ Class និង `@Bean` ពីលើ Methods ដែលបង្កើត Object៖

```java
@Configuration
public class AppConfig {

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepositoryImpl();
    }

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl(accountRepository());
    }
}
```

- **គុណសម្បត្តិ:** មាន **Compile-time Type Safety**, ងាយស្រួល Refactor ឈ្មោះ Method/Class ក្នុង IDE, អាចសរសេរ Logic លក្ខខណ្ឌមុននឹង Return Object។
- **ស័ក្តិសមសម្រាប់:** ការចុះឈ្មោះ Third-party Libraries (ដូចជា AWS S3 Client, RedisTemplate) ដែលយើងមិនអាចកែ Code ផ្ទាល់បាន។

---

## 4. វិធីទី ៣៖ Annotation-Based Configuration

ជាវិធីដែលពេញនិយមបំផុតក្នុង **Spring Boot** ដោយគ្រាន់តែដាក់ **Stereotype Annotations** នៅពីលើ Class នោះ Spring នឹងស្វែងរក និងបង្កើតវាជា Bean ដោយស្វ័យប្រវត្តិ (Component Scanning)៖

```java
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    // Database logic
}

@Service
public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
```

- **Stereotype Annotations ចម្បងៗ:**
  - `@Component`: Annotation ទូទៅសម្រាប់ Spring Bean
  - `@Service`: សម្រាប់ Service Layer (Business Logic)
  - `@Repository`: សម្រាប់ Data Access Layer (DAO / Database)
  - `@Controller` / `@RestController`: សម្រាប់ Presentation / REST API Layer

---

## 5. តារាងប្រៀបធៀបវិធីទាំង ៣ (Comparison Table)

| លក្ខណៈសម្បត្តិ | XML-Based | Java-Based (`@Configuration`) | Annotation-Based (`@Component`) |
| :--- | :--- | :--- | :--- |
| **Type Safety** | ❌ គ្មាន (String-based) | ✅ ខ្ពស់បំផុត (Compile-time) | ✅ ខ្ពស់ |
| **ល្បឿនអភិវឌ្ឍន៍** | យឺត (សរសេរ XML ច្រើន) | មធ្យម | **លឿនបំផុត (Fastest)** |
| **ការគ្រប់គ្រង 3rd Party Libs** | អាចធ្វើបាន | **ល្អឥតខ្ចោះ (Recommended)** | មិនអាចធ្វើបាន |
| **កម្រិតប្រើប្រាស់បច្ចុប្បន្ន** | កម្រប្រើណាស់ (Legacy) | ពេញនិយមសម្រាប់ Config | **ពេញនិយមបំផុតក្នុង Spring Boot** |

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 8: ឯកសារ Spring Configuration](../08-spring-configuration-file/README.md) | [📚 មាតិកា Spring Framework](../README.md) | [Part 10: តើ Spring Bean ជាអ្វី? →](../10-what-is-a-spring-bean/README.md) |
