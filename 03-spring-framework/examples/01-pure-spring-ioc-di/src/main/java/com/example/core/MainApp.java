package com.example.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 1. Initialize Spring IoC Container via Java Configuration
        System.out.println(">>> Starting Pure Spring Framework 6 Container...");
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // 2. Retrieve managed bean from IoC Container
            OrderService orderService = context.getBean(OrderService.class);

            // 3. Execute business logic
            orderService.checkout(250.00);
        }
        System.out.println(">>> Spring Container closed gracefully.");
    }
}
