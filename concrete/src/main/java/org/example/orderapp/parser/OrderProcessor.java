package org.example.orderapp.parser;

import org.example.orderapp.model.Order;

public interface OrderProcessor {
    Order parseLineToOrder(String dataline);
}
