package org.example.orderapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.orderapp.adapter.impl.NoExtOrderAdapter;
import org.example.orderapp.model.Order;


public class OrderProcessor {
    
    public static void main(String[] args) throws IOException {
        OrderProcessor op = new OrderProcessor();
        String datapath = "concrete/data/inbound_files/discount_day_without_ext";
        NoExtOrderAdapter adapter = new NoExtOrderAdapter();
        List<Order> parsedOrdersList = adapter.read(datapath);

        List<Order> sortedAndFilteredOrderList = new ArrayList<>(op.mergeSameClientOrders(op.sortOrdersOldestFirst(parsedOrdersList)));

        OrderPriceCalculator calc = new OrderPriceCalculator();
        OrderDiscounterPolicyManager discMan = new OrderDiscounterPolicyManager();

        double price = 2.0;
        double discount = 50;
        double discountStepdown = 5;

        List<Order> totalCostOrdersList = new ArrayList<>();

        for (Order order : sortedAndFilteredOrderList) {
            totalCostOrdersList.add(calc.calculateOrderTotalCost(order, price));
        }
        
        List<Order> discountedTotalCostOrderList = new ArrayList<>(discMan.applyStepdownedDiscount(totalCostOrdersList, discount, discountStepdown));

        for (Order order : discountedTotalCostOrderList) {
            System.out.println(order);
        }


    }

    public List<Order> sortOrdersOldestFirst(List<Order> orders) throws IOException {
        
        List<Order> sortedOrders = orders.stream()
        .sorted(Comparator.comparing(Order::getOrderDateTime))
        .collect(Collectors.toCollection(ArrayList::new));
        
        return sortedOrders;
        
    }

    public List<Order> mergeSameClientOrders(List<Order> orders) {
        Map<String, Order> mergredMap = new LinkedHashMap<>(); // to keep an order

        for (Order currentOrder : orders) {
            String customerName = currentOrder.getCustomerName();

            if (mergredMap.containsKey(customerName)) {
                Order existingOrder = mergredMap.get(customerName); // how does it work?
                existingOrder.setProductAmount(existingOrder.getProductAmount() + currentOrder.getProductAmount());
            } else {
                mergredMap.put(customerName, currentOrder);
            }
        }

        List<Order> uniqueOrdersOnly = new ArrayList<>(mergredMap.values());
        
        return uniqueOrdersOnly;
    }

    
}
