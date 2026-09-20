package com.example.core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("stripePayment")
@Primary // Default fallback
public class StripePaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.printf("[STRIPE - PRIMARY] Processed payment of $%.2f%n", amount);
    }
}
