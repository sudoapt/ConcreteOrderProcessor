package org.example.orderapp;

import java.io.IOException;
import java.util.List;

import org.example.orderapp.model.Order;
import org.example.orderapp.service.OrderProcessor;
import org.example.orderapp.utils.FileWriter;

public class Main {
    public static void main(String[] args) {
        try {
            String datapath = "concrete/data/inbound_files/discount_day_without_ext";
            String outboundPath = "concrete/data/outbound_files/processed_orders.txt";
            double price = 2.0;
            double discount = 50;
            double discountStepdown = 5;
            
            OrderProcessor op = new OrderProcessor(price, discount, discountStepdown, datapath);
            
            List<Order> result = op.processOrder(price, discount, discountStepdown, datapath);
            result.forEach(System.out::println);

            FileWriter fw = new FileWriter();
            fw.writeOdredToFile(result, outboundPath);
            

        } catch (IOException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}