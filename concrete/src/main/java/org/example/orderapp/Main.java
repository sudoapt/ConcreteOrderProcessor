package org.example.orderapp;

import java.io.IOException;
import java.util.List;

import org.example.orderapp.service.OrderProcessor;

public class Main {
    public static void main(String[] args) {
        try {
            String datapath = "concrete/data/inbound_files/discount_day_without_ext";
            double price = 2.0;
            double discount = 50;
            double discountStepdown = 5;
            
            OrderProcessor op = new OrderProcessor(price, discount, discountStepdown, datapath);
            
            List<?> result = op.processOrder(price, discount, discountStepdown, datapath);
            result.forEach(System.out::println);

        } catch (IOException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}