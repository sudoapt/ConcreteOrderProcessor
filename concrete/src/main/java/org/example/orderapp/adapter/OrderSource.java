package org.example.orderapp.adapter;

import java.io.IOException;
import java.util.List;

import org.example.orderapp.model.Order;

public interface OrderSource {
    List<Order> read(String datapath) throws IOException;
}
