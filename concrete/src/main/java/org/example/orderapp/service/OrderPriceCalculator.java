package org.example.orderapp.service;

import org.example.orderapp.model.Order;

public class OrderPriceCalculator {

   public Order calculateOrderTotalCost(Order order, double productPrice) {
    double totalCost = order.getProductAmount() * productPrice;
    return new Order(
        order.getOrderDateTime(),
        order.getCustomerName(),
        order.getProductAmount(),
        totalCost
    );
}
   

}
