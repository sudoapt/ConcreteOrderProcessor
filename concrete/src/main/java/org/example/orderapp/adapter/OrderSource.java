package org.example.orderapp.adapter;

import java.util.List;

import org.example.orderapp.model.Order;

public interface OrderSource {
    List<Order> parseLineToOrder(String dataline);
}
