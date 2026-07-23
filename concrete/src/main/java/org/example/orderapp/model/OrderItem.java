package org.example.orderapp.model;

public class OrderItem {
    private String productId;
    private String productName;
    private int productAmount;
    private double productPrice;
    private double productDiscount;

    
    public OrderItem (String productId, String productName, int productAmount, double productPrice, double productDiscount) {
            this.productId = productId;
            this.productName = productName;
            this.productAmount = 1; // cant order < 1kgs
            this.productPrice = productPrice;
            this.productDiscount = 1; // total price * 1 = no discount

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }


    public double getTotalPrice() {
        return (this.productAmount * this.productPrice) * this.productDiscount;
    }

    



}