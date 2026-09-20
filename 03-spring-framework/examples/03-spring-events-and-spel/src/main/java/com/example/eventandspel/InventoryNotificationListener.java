package com.example.eventandspel;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryNotificationListener {

    @EventListener
    public void handleOrder(OrderPlacedEvent event) {
        System.out.printf("  -> [INVENTORY LISTENER] Reserved items for order: %s%n", event.orderId());
    }

    @EventListener
    public void sendEmailReceipt(OrderPlacedEvent event) {
        System.out.printf("  -> [EMAIL LISTENER] Email receipt dispatched to: %s for $%.2f%n",
                event.customerName(), event.amount());
    }
}
