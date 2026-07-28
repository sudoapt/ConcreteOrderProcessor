package org.example.orderapp.model;

import java.time.LocalDateTime;

public class Order {

    private final LocalDateTime orderDateTime;
    private final String customerName;
    private final double productAmount;

    public Order(LocalDateTime orderDateTime, String customerName, double productAmount) {
        this.orderDateTime = orderDateTime;
        this.customerName = customerName;
        this.productAmount = productAmount;
    }

     @Override
    public String toString() {
        return orderDateTime + " " + customerName + " " + productAmount + 
        "\n";
    }

    public static Order makeOrder(LocalDateTime orderDateTime, String customerName, double productAmount) {
        return new Order(orderDateTime, customerName, productAmount);
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }


    public String getCustomerName() {
        return customerName;
    }


    public double getProductAmount() {
        return productAmount;
    }

    

    

    





}