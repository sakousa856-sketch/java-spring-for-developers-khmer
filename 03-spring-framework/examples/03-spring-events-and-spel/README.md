# Spring Application Events & SpEL Runnable Project

This project demonstrates:
1. **Spring Application Events:** Publishing domain POJO events (`OrderPlacedEvent`) using `ApplicationEventPublisher`, and listening cleanly with `@EventListener`.
2. **Spring Expression Language (SpEL):** Dynamic arithmetic, string manipulation, and static math method calls with `#{...}`.

## How to Run
```bash
mvn compile exec:java -Dexec.mainClass="com.example.eventandspel.MainEventAndSpELApp"
```
