package com.example.eventandspel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SpELCalculatorService {

    @Value("#{150 * 0.1}")
    private double taxAmount;

    @Value("#{'Spring Framework 6'.toUpperCase()}")
    private String frameworkBanner;

    @Value("#{T(java.lang.Math).PI * 10}")
    private double circleFormula;

    public void printSpELResults() {
        System.out.println("\n========== SpEL Dynamic Evaluation ==========");
        System.out.println("Framework Banner: " + frameworkBanner);
        System.out.printf("Computed Tax (150 * 0.1): $%.2f%n", taxAmount);
        System.out.printf("Circle Formula (PI * 10): %.4f%n", circleFormula);
        System.out.println("=============================================\n");
    }
}
