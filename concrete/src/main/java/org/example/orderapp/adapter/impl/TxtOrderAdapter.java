package org.example.orderapp.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.orderapp.adapter.OrderSource;
import org.example.orderapp.model.Order;
import org.example.orderapp.parser.impl.OrderParserImpl;


public class TxtOrderAdapter implements OrderSource {
    private final OrderParserImpl parser = new OrderParserImpl();

    

    @Override
    public List<Order> read(List<String> dataline) {
        List<Order> orders = new ArrayList<>();
        String regex = "(?<=\\\\d)T(?=\\\\d)|[^a-zA-Z0-9:-]+";

        for (String line : dataline) {
            line = line.replaceAll(regex,"\\|");
            orders.add(parser.parseLineToOrder(line));
        }

        return orders;
    }

}
