package org.example.orderapp.service;

import org.example.orderapp.model.Order;

public class OrderPriceCalculator {
    double productPrice;
    double productPriceDiscount;
    int discountStepdown;


    // public OrderPriceCalculator(double productPrice, double productPriceDiscount, int discountStepdown) {
    //     this.productPrice = productPrice;
    //     this.productPriceDiscount = productPriceDiscount;
    //     this.discountStepdown = discountStepdown;
    // }

    // public static void main(String[] args) {
    //     try {
    //         NoExtOrderAdapter adapter1 = new NoExtOrderAdapter();
    //         OrderPriceCalculator calc = new OrderPriceCalculator();
    //         OrderDiscounterPolicyManager discMan = new OrderDiscounterPolicyManager();
            
    //         ArrayList<Order> totalCostOrders = new ArrayList<>();
    //         String datapath = "concrete/data/inbound_files/discount_day_without_ext";
            
    //         List<Order> ordersList1 = adapter1.read(datapath);
    //         for (Order order : ordersList1) {
    //             totalCostOrders.add(calc.calculateOrderTotalCost(order, 2.0));
                
    //         }
    //         System.out.println(totalCostOrders);
            
    //         ArrayList<Order> dicsOrders = discMan.applyStepdownedDiscount(totalCostOrders, 0.50, 0.05);
    //         System.out.println(dicsOrders);
            
    //     } catch (IOException ex) {
    //         System.getLogger(OrderPriceCalculator.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    //     }

    // }


   public Order calculateOrderTotalCost(Order order, double productPrice) {
    double totalCost = order.getProductAmount() * productPrice;
    return new Order(
        order.getOrderDateTime(),
        order.getCustomerName(),
        order.getProductAmount(),
        totalCost
    );
}
   

}
