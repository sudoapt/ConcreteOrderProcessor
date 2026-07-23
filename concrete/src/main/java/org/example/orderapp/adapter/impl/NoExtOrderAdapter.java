package org.example.orderapp.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.orderapp.adapter.OrderAdapter;
import org.example.orderapp.model.Order;
import org.example.orderapp.parser.NoExtOrderParser;

public class NoExtOrderAdapter implements OrderAdapter {
    private final NoExtOrderParser parser = new NoExtOrderParser();

    @Override
    public List<Order> addItem() {
        List<Order> orders = new ArrayList<>();
        
    }

    return orders;
}
