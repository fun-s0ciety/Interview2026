package com.interview.kafkaprep.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.interview.kafkaprep.Models.Order;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-events", groupId = "billing-group")
    public void consumeOrderForBilling(Order order) {
        System.out.println("<-- CONSUMER (Billing): Charging credit card for " + order.getProductName());
        System.out.println("Consumed order for billing: " + order);
    }

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void consumeOrderForNotifications(Order order) {
        System.out.println("<-- CONSUMER (Notifications): Sending notification for " + order.getProductName());
        System.out.println("Consumed order for notifications: " + order);
    }

}
