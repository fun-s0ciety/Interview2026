package com.interview.kafkaprep.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.interview.kafkaprep.Models.Order;

@Service
public class OrderProducer {

    private static final String TOPIC = "order-events";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrder(Order order) {
        System.out.println("--> PRODUCER: Sending order to Kafka: " + order.getOrderId());
        kafkaTemplate.send(TOPIC, order);
        System.out.println("Sent order: " + order);
    }
    
}
