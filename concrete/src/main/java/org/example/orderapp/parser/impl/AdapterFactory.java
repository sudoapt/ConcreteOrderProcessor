package org.example.orderapp.parser.impl;

import org.example.orderapp.parser.OrderProcessor;

public class AdapterFactory {
    public static OrderProcessor createOrderProcessor() {
        OrderParserImpl parser = new OrderParserImpl();

        return new OrderAdapter(parser);
    }
}
