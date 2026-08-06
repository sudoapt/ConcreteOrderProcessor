package org.example.orderapp.service;

import java.util.ArrayList;
import java.util.List;

import org.example.orderapp.model.Order;
import org.example.orderapp.model.Receipt;

public class OrderPriceManager {

    // public List<Receipt> checkoutOrder(List<Order> orders, double productPrice,
    // double productPriceDiscount,
    // double discountStepdown) {

    // List<Receipt> noDiscountReceipts = new ArrayList<>();

    // for (Order order : orders) {

    // double orderCost = order.getProductAmount() * productPrice;

    // noDiscountReceipts.add(new Receipt(order.getOrderDateTime(),
    // order.getCustomerName(),
    // order.getProductAmount(),
    // orderCost));
    // }

    // double currentDiscount = productPriceDiscount / 100;
    // List<Receipt> receipts = new ArrayList<>();

    // for (int i = 0; i < noDiscountReceipts.size(); i++) {
    // Receipt receipt = noDiscountReceipts.get(i);

    // double orderCost = Math.round(receipt.getTotalCost() * (1 -
    // currentDiscount));

    // // stepdown
    // currentDiscount = Math.max(0, currentDiscount - discountStepdown / 100);

    // receipts.add(new Receipt(receipt.getReceiptDateTime(),
    // receipt.getCustomerName(),
    // receipt.getProductAmount(), orderCost));
    // }
    // return receipts;
    // }

    public List<Receipt> checkoutOrder(
            List<Order> orders,
            double productPrice,
            double productPriceDiscount,
            double discountStepdown) {

        List<Receipt> receipts = new ArrayList<>();
        double currentDiscount = productPriceDiscount / 100.0;

        for (Order order : orders) {
            double orderCost = order.getProductAmount() * productPrice;
            double discountedCost = Math.round(
                    orderCost * (1 - currentDiscount));

            receipts.add(new Receipt(
                    order.getOrderDateTime(),
                    order.getCustomerName(),
                    order.getProductAmount(),
                    discountedCost));

            currentDiscount = Math.max(
                    0,
                    currentDiscount - discountStepdown / 100.0);
        }
        
        return receipts;
    }

}
