package org.example.orderapp.model;

public class OrderItem {
    private String productName;
    private double productAmount;
    private double productPrice;
    private double productPriceDiscount;

    
    public OrderItem (int productId, String productName, double productAmount, double productPrice, double productPriceDiscount) {
            this.productName = productName;
            this.productAmount = 1; // cant order < 1kgs
            this.productPrice = productPrice;
            this.productPriceDiscount = productPriceDiscount;
    }

    


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public double getProductAmount() {
        return productAmount;
    }


    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }


    public double getProductPrice() {
        return productPrice;
    }


    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


    public double getProductPriceDiscount() {
        return productPriceDiscount;
    }


    public void setProductPriceDiscount(double productPriceDiscount) {
        this.productPriceDiscount = productPriceDiscount;
    }


    public double getTotalPrice() {
        return (this.productAmount * this.productPrice) * this.productPriceDiscount;
    }

    



}