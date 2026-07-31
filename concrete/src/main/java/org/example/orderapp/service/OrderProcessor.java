package org.example.orderapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.example.orderapp.adapter.impl.NoExtOrderAdapter;
import org.example.orderapp.model.Order;


public class OrderProcessor {
    
    public static void main(String[] args) throws IOException {
        OrderProcessor op = new OrderProcessor();
        String datapath = "concrete/data/inbound_files/discount_day_without_ext";
        NoExtOrderAdapter adapter = new NoExtOrderAdapter();
        List<Order> parsedOrdersList = adapter.read(datapath);
        op.sortOrdersOldestFirst(parsedOrdersList);


    }

    public List<Order> sortOrdersOldestFirst(List<Order> orders) throws IOException {
        
        List<Order> sortedOrders = orders.stream()
        .sorted(Comparator.comparing(Order::getOrderDateTime))
        .collect(Collectors.toCollection(ArrayList::new));
        
        System.out.println("OrderProcessor: \n" + sortedOrders);
        return sortedOrders;
        
    }
    
}
