package org.example.orderapp.parser.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.example.orderapp.model.Order;
import org.example.orderapp.parser.OrderProcessor;

public class OrderTxtPipeParser implements OrderProcessor {

    @Override
    public Order parseLineToOrder(String dataline) {
        String[] entries = dataline.split("\\|");
        LocalDateTime timestamp = LocalDateTime.parse(entries[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String customerName = entries[1];
        double productAmount = Double.parseDouble(entries[2]);
        return new Order(timestamp, customerName, productAmount);
    }

}
