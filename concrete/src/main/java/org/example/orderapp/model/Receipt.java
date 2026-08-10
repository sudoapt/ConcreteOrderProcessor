package org.example.orderapp.model;

public class Receipt {
    private String customerName;
    private double totalCost;

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

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}
