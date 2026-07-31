package org.example.orderapp.adapter.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.orderapp.adapter.OrderSource;
import org.example.orderapp.model.Order;
import org.example.orderapp.parser.impl.OrderParserImpl;
import org.example.orderapp.utils.FileReader;

public class NoExtOrderAdapter implements OrderSource {
    private final OrderParserImpl parser = new OrderParserImpl();
    private final FileReader fileReader = new FileReader();

   
    @Override
    public List<Order> read(String datapath) throws IOException {
        /**
         * Reads the lines via FileReader.
         * @return ArrayList<Order> orders
         */
        List<Order> orders = new ArrayList<>();
        List<String> lines = fileReader.readFileLineByLine(datapath);

        for (String line : lines) {
            line = line.replace("#", ";");
            orders.add(parser.parseLinesToOrder(line));
        }

        return orders;
    
    }

    

  
}
