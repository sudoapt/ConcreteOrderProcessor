package org.example.orderapp.service;

import org.example.orderapp.model.Order;

public class OrderPriceCalculator {
    double productPrice;
    double productPriceDiscount;
    int discountStepdown;


    public OrderPriceCalculator(double productPrice, double productPriceDiscount, int discountStepdown) {
        this.productPrice = productPrice;
        this.productPriceDiscount = productPriceDiscount;
        this.discountStepdown = discountStepdown;
    }


    public double calutaleOrderTotalCost(Order order, double productPrice, double productPriceDiscount, double discountStepdown) {
        return order.getProductAmount() * productPrice * (1 - productPriceDiscount);
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


    public int getDiscountStepdown() {
        return discountStepdown;
    }


    public void setDiscountStepdown(int discountStepdown) {
        this.discountStepdown = discountStepdown;
    }


    

    

}
