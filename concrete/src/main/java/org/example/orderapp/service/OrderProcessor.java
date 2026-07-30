package org.example.orderapp.service;

import org.example.orderapp.adapter.impl.NoExtOrderAdapter;

public class OrderProcessor {
    // gets Order from Adapters and uses OrderPriceCalculator.calutaleOrderTotalCost on it
    // merges both Adapters data into single list of unique items == all three items of the line are the same

    private final NoExtOrderAdapter adapter1 = new NoExtOrderAdapter();
    private final OrderPriceCalculator calc = new OrderPriceCalculator();
    private final double productPrice = 10;

    

    // public HashMap<String, Double> getOrderTotalCost() throws IOException {
        
    //     HashMap<String, Double> ordersTotalCost = new HashMap<>();

    //     List<Order> ordersList1 = adapter1.read();
    //     for (Order order : ordersList1) {
    //         calc.calculateOrderTotalCost(order, productPrice);
    //     }

    //     ret
    // }

}
