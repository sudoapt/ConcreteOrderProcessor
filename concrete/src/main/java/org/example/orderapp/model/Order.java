package org.example.orderapp.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;
    private String orderDateTime;
    private String customerName;
    private List<OrderItem> items;


    // to avoid nullpointerexception
    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(String orderId, String orderDateTime, String customerName) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
        this.items = new ArrayList<>();
    }


    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // do i need it?
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    





}