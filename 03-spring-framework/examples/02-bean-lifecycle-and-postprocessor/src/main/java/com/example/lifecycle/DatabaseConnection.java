package com.example.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("databaseConnection")
public class DatabaseConnection implements BeanNameAware, InitializingBean, DisposableBean {

    private String beanName;

    public DatabaseConnection() {
        System.out.println("[LIFECYCLE] 1. Constructor: DatabaseConnection instantiated via new()");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("[LIFECYCLE] 3. BeanNameAware: Bean ID assigned -> " + name);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("[LIFECYCLE] 5. @PostConstruct: Establishing database connection sockets...");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("[LIFECYCLE] 6. InitializingBean.afterPropertiesSet: Connection health checked OK.");
    }

    public void executeQuery(String sql) {
        System.out.println("[IN SERVICE] Executing SQL query: " + sql);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("[LIFECYCLE] 8. @PreDestroy: Flushing transaction buffers...");
    }

    @Override
    public void destroy() {
        System.out.println("[LIFECYCLE] 9. DisposableBean.destroy: Sockets closed. Memory released.");
    }
}
