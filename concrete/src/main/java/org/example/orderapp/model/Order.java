package org.example.orderapp.model;

import java.time.LocalDateTime;

public class Order {

    private final LocalDateTime orderDateTime;
    private final String customerName;
    private double productAmount;
    private double totalCost;


    public Order(LocalDateTime orderDateTime, String customerName, double productAmount) {
        this(orderDateTime, customerName, productAmount, 0.0);
    }


    public Order(LocalDateTime orderDateTime, String customerName, double productAmount, double totalCost) {
        this.orderDateTime = orderDateTime;
        this.customerName = customerName;
        this.productAmount = productAmount;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return orderDateTime + " " + customerName + " " + productAmount + " " + totalCost + "\n";
    }

    public static Order makeOrder(LocalDateTime orderDateTime, String customerName, double productAmount, double totalCost) {
        return new Order(orderDateTime, customerName, productAmount, totalCost);
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

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
}