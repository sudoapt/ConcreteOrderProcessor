package org.example.orderapp.model;

import java.time.LocalDateTime;

public class Receipt {
    private LocalDateTime receiptDateTime;
    private String customerName;
    private double productAmount;
    private double totalCost;

    public Receipt(LocalDateTime receiptDateTime, String customerName, double productAmount, double totalCost) {
        this.receiptDateTime = receiptDateTime;
        this.customerName = customerName;
        this.productAmount = productAmount;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Receipt" + " " + getReceiptDateTime()
                + " " + getCustomerName() + " " + getProductAmount() + " " + getTotalCost();
    }

    public LocalDateTime getReceiptDateTime() {
        return receiptDateTime;
    }

    public void setReceiptDateTime(LocalDateTime receiptDateTime) {
        this.receiptDateTime = receiptDateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
