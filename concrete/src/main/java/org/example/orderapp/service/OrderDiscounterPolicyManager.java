package org.example.orderapp.service;



import java.util.ArrayList;

import java.util.List;

import org.example.orderapp.model.Order;

public class OrderDiscounterPolicyManager {


    public List<Order> applyStepdownedDiscount(List<Order> orders, double productPriceDiscount, double discountStepdown) {
        
        List<Order> discountedOrders = new ArrayList<>();

        double currentDiscount = productPriceDiscount / 100; // init discount

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);

            double totalCost = Math.round(order.getTotalCost() * (1 - currentDiscount));

            //stepdown
            currentDiscount = Math.max(0, currentDiscount - discountStepdown / 100);
            
            double newTotalCost = order.getTotalCost() * 1 - currentDiscount;
            discountedOrders.add(new Order(order.getOrderDateTime(), order.getCustomerName(), order.getProductAmount(), totalCost));

            

        }
        return discountedOrders;
    }

}
