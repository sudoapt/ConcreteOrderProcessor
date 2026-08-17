package org.example.orderapp.parser.impl;

import org.example.orderapp.parser.OrderProcessor;
import org.example.orderapp.utils.InboundFileFormatEnum;

public class OrderProcessorFactory {
    public static OrderProcessor createOrderProcessor(InboundFileFormatEnum format) {
        if (format == null) {
            throw new IllegalArgumentException("Orders file format cannot be null");
        }

        return format.create(new OrderTxtPipeParser());
    }
}
