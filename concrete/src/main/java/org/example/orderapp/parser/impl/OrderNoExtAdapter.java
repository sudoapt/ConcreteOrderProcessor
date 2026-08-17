package org.example.orderapp.parser.impl;

import org.example.orderapp.model.Order;
import org.example.orderapp.parser.OrderProcessor;

public class OrderNoExtAdapter implements OrderProcessor {

    private final OrderTxtPipeParser parser;

    public OrderNoExtAdapter(OrderTxtPipeParser parser) {
        this.parser = parser;
    }

    @Override
    public Order parseLineToOrder(String dataline) {

        String convertedDataLine = dataline.replace('#', '|');

        return parser.parseLineToOrder(convertedDataLine);

    }

}
