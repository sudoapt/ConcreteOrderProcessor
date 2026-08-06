package org.example.orderapp;

import org.example.orderapp.adapter.impl.OrderAdapter;
import org.example.orderapp.service.OrderManager;
import org.example.orderapp.service.OrderPriceManager;
import org.example.orderapp.utils.FileManager;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        OrderPriceManager priceManager = new OrderPriceManager();
        OrderAdapter adapter = new OrderAdapter();

        OrderManager orderManager = new OrderManager(fileManager, priceManager, adapter);

        orderManager.manageOrder(2.0, 50.0, 5.0, "concrete/src/main/resources/inbound_files/discount_day_without_ext",
                "concrete/src/main/resources/outbound_files/processed_orders.txt");

    }

}