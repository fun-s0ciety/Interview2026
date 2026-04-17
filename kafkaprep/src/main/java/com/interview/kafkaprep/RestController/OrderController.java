package com.interview.kafkaprep.RestController;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.kafkaprep.Models.Order;
import com.interview.kafkaprep.Services.OrderProducer;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        Order newOrder = new Order(UUID.randomUUID().toString(), order.getProductName(), order.getPrice());
        orderProducer.sendOrder(newOrder);
        return ResponseEntity.ok("Order created and sent to Kafka: " + newOrder.getOrderId());
    }
    
}
