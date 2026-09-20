package com.example.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentService defaultPayment;
    private final PaymentService specificPayment;
    private final String appName;
    private final double feeRate;

    // Constructor Injection with @Primary, @Qualifier, and @Value
    public OrderService(
            PaymentService defaultPayment, // Takes @Primary StripePaymentService
            @Qualifier("paypalPayment") PaymentService specificPayment,
            @Value("${app.name}") String appName,
            @Value("${app.fee.rate:0.01}") double feeRate) {
        this.defaultPayment = defaultPayment;
        this.specificPayment = specificPayment;
        this.appName = appName;
        this.feeRate = feeRate;
    }

    public void checkout(double amount) {
        System.out.println("====================================================");
        System.out.println("System: " + appName + " | Fee Rate: " + (feeRate * 100) + "%");
        System.out.println("--- 1. Using Default Payment (Stripe via @Primary) ---");
        defaultPayment.pay(amount);
        System.out.println("--- 2. Using Specific Payment (PayPal via @Qualifier) ---");
        specificPayment.pay(amount);
        System.out.println("====================================================");
    }
}
