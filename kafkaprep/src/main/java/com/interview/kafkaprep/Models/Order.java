package com.interview.kafkaprep.Models;


public class Order {

    private String orderId;
    private String productName;
    private double price;

    public Order() {
    }

    public Order(String orderId, String productName, double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }  
}
