package org.example.orderapp.service;

import java.util.List;
import java.util.Map;

import org.example.orderapp.model.Order;
import org.example.orderapp.utils.FileManager;

public class OrderManager {
    private final FileManager fileManager;
    private final OrderPriceManager priceManager;

    public OrderManager(FileManager fileManager, OrderPriceManager priceManager) {
        this.fileManager = fileManager;
        this.priceManager = priceManager;

    }

    public void manageOrder(double productPrice, double productPriceDiscount, double discountStepdown,
            String inboundFilePath, String outboundFilePath) {

        List<Order> orders = fileManager.readFileLineByLine(inboundFilePath);

        Map<String, Double> receipts = priceManager.checkoutOrder(orders, productPrice,
                productPriceDiscount, discountStepdown);

        fileManager.writeReceiptsToFile(receipts, outboundFilePath);

    }

}
