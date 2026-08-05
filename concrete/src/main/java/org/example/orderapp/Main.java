package org.example.orderapp;

import org.example.orderapp.adapter.impl.OrderAdapter;
import org.example.orderapp.service.DataConfig;
import org.example.orderapp.service.OrderManager;
import org.example.orderapp.service.OrderPriceManager;
import org.example.orderapp.service.PricingConfig;
import org.example.orderapp.utils.FileManager;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        OrderPriceManager priceManager = new OrderPriceManager();
        OrderAdapter adapter = new OrderAdapter();
        PricingConfig pricingConfig = new PricingConfig(2.0, 50.0, 5.0);
        DataConfig dataConfig = new DataConfig("concrete/src/main/resources/inbound_files/discount_day_without_ext",
                "concrete/src/main/resources/outbound_files/processed_orders.txt");

        OrderManager orderManager = new OrderManager(
                fileManager,
                priceManager,
                adapter,
                pricingConfig,
                dataConfig);

        orderManager.manageOrder(fileManager, priceManager, adapter, dataConfig, pricingConfig);
    }
}