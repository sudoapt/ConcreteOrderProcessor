package org.example.orderapp.parser;

import org.example.orderapp.model.Order;

public interface OrderParser {
    Order parseLineToOrder(String dataline);
}
