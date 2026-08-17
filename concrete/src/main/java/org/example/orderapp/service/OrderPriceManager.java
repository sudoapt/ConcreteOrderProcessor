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

    public Map<String, Double> checkoutOrder(
            List<Order> orders,
            double productPrice,
            double productPriceDiscount,
            double discountStepdown) {

        double currentDiscount = productPriceDiscount / 100.0;

        List<Order> sortedOrders = sortOrders(orders);

        List<Receipt> receipts = new ArrayList<>();

        for (Order order : sortedOrders) {
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

        return mergeSameClientOrders(receipts);

    }

    private List<Order> sortOrders(List<Order> orders) {

        List<Order> sortedOrders = orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDateTime))
                .collect(Collectors.toList());

        return sortedOrders;
    }

    private static Map<String, Double> mergeSameClientOrders(List<Receipt> receipts) {
        Map<String, Double> mergedMap = new HashMap<>();
        for (Receipt receipt : receipts) {
            mergedMap.merge(receipt.getCustomerName(), receipt.getTotalCost(), Double::sum);
        }

        // for (Receipt receipt : receipts) {
        // mergedMap.merge(order.getCustomerName(), order, (existing, inbound) -> {
        // existing.setProductAmount(existing.getProductAmount() +
        // inbound.getProductAmount());

        // return existing;
        // });

        return mergedMap;
    }

}
