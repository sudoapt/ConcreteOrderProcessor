package org.example.orderapp.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.example.orderapp.model.Order;


public class FileWriter {

    public void writeOdredToFile(List<Order> orders, String pathToFile) {
        try {
            for (Order order : orders) {
                String customerName = order.getCustomerName();
                double totalCost = order.getTotalCost();
                String resultingString = String.format("%s %.2f%n", customerName, totalCost);
                Path path = Paths.get(pathToFile);
                Files.writeString(path, resultingString, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (ClassCastException e) {
            System.err.println("Error: List element types do not match the expected format. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }



}
