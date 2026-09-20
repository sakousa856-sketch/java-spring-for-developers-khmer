# Pure Spring 6 IoC & DI Example Project

This runnable project demonstrates how Spring Framework 6 functions natively without Spring Boot:
- **IoC Container Bootstrap:** `AnnotationConfigApplicationContext`
- **Metadata:** `@Configuration`, `@ComponentScan`, `@PropertySource`
- **Dependency Injection:** Constructor Injection
- **Ambiguity Resolution:** `@Primary` vs `@Qualifier`
- **Property Injection:** `@Value("${...}")`

## How to Run
```bash
# Compile and run via command line or import into IntelliJ IDEA / Eclipse
mvn compile exec:java -Dexec.mainClass="com.example.core.MainApp"
```
