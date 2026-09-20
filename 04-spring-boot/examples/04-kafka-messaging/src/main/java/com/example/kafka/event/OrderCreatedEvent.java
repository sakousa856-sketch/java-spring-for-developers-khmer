package com.example.kafka.event;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderCreatedEvent(
    String orderId,
    String customerEmail,
    BigDecimal totalAmount,
    Instant createdAt
) {}
