package org.example.orderapp.service;

import org.example.orderapp.adapter.impl.NoExtOrderAdapter;

public class OrderProcessor {
    // gets Order from Adapters and uses OrderPriceCalculator.calutaleOrderTotalCost on it
    // merges both Adapters data into single list of unique items == all three items of the line are the same

    private final NoExtOrderAdapter adapter1 = new NoExtOrderAdapter();
    private final OrderPriceCalculator calc = new OrderPriceCalculator();
    private final double productPrice = 10;

    

    

}
