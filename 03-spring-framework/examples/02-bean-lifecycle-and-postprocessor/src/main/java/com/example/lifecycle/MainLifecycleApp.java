package com.example.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainLifecycleApp {
    public static void main(String[] args) {
        System.out.println("========== BOOTSTRAPPING SPRING CONTAINER ==========");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifecycleConfig.class);

        System.out.println("\n========== USING THE BEAN ==========");
        DatabaseConnection connection = context.getBean(DatabaseConnection.class);
        connection.executeQuery("SELECT * FROM customers WHERE active = true;");

        System.out.println("\n========== CLOSING SPRING CONTAINER ==========");
        context.close();
        System.out.println("Container closed.");
    }
}
