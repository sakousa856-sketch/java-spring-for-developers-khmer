package com.example.core;

import org.springframework.stereotype.Service;

@Service("paypalPayment")
public class PaypalPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.printf("[PAYPAL] Processed payment of $%.2f%n", amount);
    }
}
