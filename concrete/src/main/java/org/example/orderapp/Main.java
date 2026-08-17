package org.example.orderapp;

import org.example.orderapp.service.OrderManager;
import org.example.orderapp.service.OrderPriceManager;
import org.example.orderapp.utils.FileManager;

public class Main {
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        OrderPriceManager pm = new OrderPriceManager();

        OrderManager orderManager = new OrderManager(fm, pm);

        orderManager.manageOrders(2.0, 50.0, 5.0,
                "concrete/src/main/resources/inbound_files/discount_day.txt",
                "concrete/src/main/resources/outbound_files/processed_orders_without_ext");

    }

}