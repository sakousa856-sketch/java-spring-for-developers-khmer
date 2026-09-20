package com.example.eventandspel;

public record OrderPlacedEvent(String orderId, String customerName, double amount) {
}
