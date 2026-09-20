package com.example.eventandspel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEventAndSpELApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventAndSpELConfig.class)) {
            // 1. Test SpEL
            SpELCalculatorService calc = context.getBean(SpELCalculatorService.class);
            calc.printSpELResults();

            // 2. Test Events
            OrderService orderService = context.getBean(OrderService.class);
            orderService.placeOrder("ORD-2026-99", "Chanthy Developer", 320.50);
        }
    }
}
