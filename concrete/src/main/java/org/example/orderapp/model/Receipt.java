package org.example.orderapp.model;

public class Receipt {
    private final String customerName;
    private final double totalCost;

    public Receipt(String customerName, double totalCost) {
        this.customerName = customerName;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Receipt" + " " + getCustomerName() + " " + getTotalCost();
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalCost() {
        return totalCost;
    }

}
