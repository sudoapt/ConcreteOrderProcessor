package org.example.orderapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.orderapp.model.Order;
import org.example.orderapp.model.Receipt;

public class OrderPriceManager {
    // private final FileManager fileManager;
    // private final OrderAdapter adapter;

    // public OrderPriceManager(FileManager fileManager, OrderAdapter adapter) {
    // // this.fileManager = fileManager;
    // // this.adapter = adapter;
    // }

    public List<Receipt> checkoutOrder(
            List<Order> orders,
            double productPrice,
            double productPriceDiscount,
            double discountStepdown) {

        List<Receipt> receipts = new ArrayList<>();
        double currentDiscount = productPriceDiscount / 100.0;

        List<Order> sortedAndUniqueOrders = sortAndDeduplicateOrders(orders);

        for (Order order : sortedAndUniqueOrders) {
            double orderCost = order.getProductAmount() * productPrice;
            double discountedCost = Math.round(
                    orderCost * (1 - currentDiscount));

            receipts.add(new Receipt(
                    order.getCustomerName(),
                    discountedCost));

            currentDiscount = Math.max(
                    0,
                    currentDiscount - discountStepdown / 100.0);
        }
        receipts.forEach(System.out::println);
        return receipts;
    }

    private List<Order> sortAndDeduplicateOrders(List<Order> orders) {

        List<Order> sortedOrders = orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDateTime))
                .collect(Collectors.toList());

        return mergeSameClientOrders(sortedOrders);
    }

    private static List<Order> mergeSameClientOrders(List<Order> orders) {
        Map<String, Order> mergedMap = new HashMap<>();

        for (Order order : orders) {
            mergedMap.merge(order.getCustomerName(), order, (existing, inbound) -> {
                existing.setProductAmount(existing.getProductAmount() + inbound.getProductAmount());

                return existing;
            });

        }

        return new ArrayList<>(mergedMap.values());
    }
}
