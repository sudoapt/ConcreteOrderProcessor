package org.example.orderapp.service;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.example.orderapp.model.Order;

public class OrderDiscounterPolicyManager {
    // gets the ordersTotalCost HashMap
    // takes order timestamp, ranges earliest first
    // aplies stepdown discount
    
    // private double productPriceDiscount;
    // private double discountStepdown;



    public ArrayList<Order> applyStepdownedDiscount(ArrayList<Order> orders, double productPriceDiscount, double discountStepdown) {
        ArrayList<Order> discountedOrders = new ArrayList<>();
        ArrayList<Order> sortedOrders =  orders.stream()
        .sorted(Comparator.comparing(Order::getOrderDateTime))
        .collect(Collectors.toCollection(ArrayList::new));


        double currentDiscount = productPriceDiscount; // init discount

        for (int i = 0; i < sortedOrders.size(); i++) {
            Order order = sortedOrders.get(i);

            double totalCost = Math.round(order.getTotalCost() * (1 - currentDiscount));

            //stepdown
            currentDiscount = Math.max(0, currentDiscount - discountStepdown);
            
            double newTotalCost = order.getTotalCost() * 1 - currentDiscount;
            discountedOrders.add(new Order(order.getOrderDateTime(), order.getCustomerName(), order.getProductAmount(), totalCost));

            

        }
        return discountedOrders;
    }

}
