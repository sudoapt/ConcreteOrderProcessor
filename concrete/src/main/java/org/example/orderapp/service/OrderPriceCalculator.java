package org.example.orderapp.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.example.orderapp.adapter.impl.NoExtOrderAdapter;
import org.example.orderapp.model.Order;

public class OrderPriceCalculator {
    double productPrice;
    double productPriceDiscount;
    int discountStepdown;


    // public OrderPriceCalculator(double productPrice, double productPriceDiscount, int discountStepdown) {
    //     this.productPrice = productPrice;
    //     this.productPriceDiscount = productPriceDiscount;
    //     this.discountStepdown = discountStepdown;
    // }

    public static void main(String[] args) {
        try {
            NoExtOrderAdapter adapter1 = new NoExtOrderAdapter();
            OrderPriceCalculator calc = new OrderPriceCalculator();
            
            HashMap<String, Double> ordersTotalCost = new HashMap<>();
            String datapath = "concrete/data/inbound_files/discount_day_without_ext";
            
            List<Order> ordersList1 = adapter1.read(datapath);
            for (Order order : ordersList1) {
                ordersTotalCost.put(order.getCustomerName(),(calc.calculateOrderTotalCost(order, 10.0)));
                
            }
            System.out.println(ordersTotalCost);
            
        } catch (IOException ex) {
            System.getLogger(OrderPriceCalculator.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }


    public double calculateOrderTotalCost(Order order, double productPrice) {
        return order.getProductAmount() * productPrice;
    }

    // public HashMap<String, Double> applyDiscount ();

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
