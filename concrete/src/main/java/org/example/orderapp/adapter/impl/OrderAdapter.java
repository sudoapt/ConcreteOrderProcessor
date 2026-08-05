package org.example.orderapp.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.orderapp.adapter.OrderSource;
import org.example.orderapp.model.Order;
import org.example.orderapp.parser.impl.OrderParserImpl;


public class OrderAdapter implements OrderSource {
    private final OrderParserImpl parser = new OrderParserImpl();
    // private final FileReader fileReader = new FileReader();

   
    @Override
    public List<Order> read(List<String> datalines){
        /**
         * Reads the lines via FileManager.
         * @return ArrayList<Order> adaptedOrders
         */
        List<Order> adaptedOrders = new ArrayList<>();
        String pattern = "(?<=\\\\d)T(?=\\\\d)|[^a-zA-Z0-9:-]+";
        for (String line : datalines) {
            line = line.replaceAll(pattern, "\\|");
            adaptedOrders.add(parser.parseLineToOrder(line));
        }
        return adaptedOrders;

    }

    

  
}
