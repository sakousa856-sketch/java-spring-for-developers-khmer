# Spring Bean Lifecycle & BeanPostProcessor Example

This project traces every step of the Spring Bean lifecycle in real-time on the console:
1. Instantiation (`Constructor`)
2. Dependency Injection
3. Aware Interfaces (`BeanNameAware`)
4. `BeanPostProcessor.postProcessBeforeInitialization`
5. `@PostConstruct`
6. `InitializingBean.afterPropertiesSet`
7. `BeanPostProcessor.postProcessAfterInitialization`
8. In Service (`executeQuery`)
9. `@PreDestroy`
10. `DisposableBean.destroy`

## How to Run
```bash
mvn compile exec:java -Dexec.mainClass="com.example.lifecycle.MainLifecycleApp"
```
