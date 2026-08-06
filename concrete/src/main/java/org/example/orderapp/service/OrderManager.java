package org.example.orderapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.orderapp.adapter.impl.OrderAdapter;
import org.example.orderapp.model.Order;
import org.example.orderapp.model.Receipt;
import org.example.orderapp.utils.FileManager;

public class OrderManager {
    private final FileManager fileManager;
    private final OrderPriceManager priceManager;
    private final OrderAdapter adapter;

    public OrderManager(FileManager fileManager, OrderPriceManager priceManager, OrderAdapter adapter) {
        this.fileManager = fileManager;
        this.priceManager = priceManager;
        this.adapter = adapter;

    }

    public List<Receipt> manageOrder(double productPrice, double productPriceDiscount, double discountStepdown,
            String inboundFilePath, String outboundFilePath) {

        List<Order> sortedOrders = adapter.read(fileManager.readFileLineByLine(inboundFilePath)).stream()
                .sorted(Comparator.comparing(Order::getOrderDateTime))
                .collect(Collectors.toList());

        List<Order> noDuplicateClients = mergeSameClientOrders(sortedOrders);

        List<Receipt> receipts = priceManager.checkoutOrder(noDuplicateClients, productPrice,
                productPriceDiscount, discountStepdown);

        fileManager.writeOdredToFile(receipts, outboundFilePath);

        return receipts;

    }

    private static List<Order> mergeSameClientOrders(List<Order> orders) {
        Map<String, Order> mergedMap = new HashMap<>();

        for (Order order : orders) {
            mergedMap.merge(order.getCustomerName(), order, (existing, inbound) -> {
                existing.setProductAmount(existing.getProductAmount() + inbound.getProductAmount());

                return existing;
            });

        }

        // for (Order currentOrder : orders) {
        // String customerName = currentOrder.getCustomerName();

        // if (mergredMap.containsKey(customerName)) {
        // Order existingOrder = mergredMap.get(customerName);
        // existingOrder.setProductAmount(existingOrder.getProductAmount() +
        // currentOrder.getProductAmount());
        // } else {
        // mergredMap.put(customerName, currentOrder);
        // }
        // }

        return new ArrayList<>(mergedMap.values());
    }

}
