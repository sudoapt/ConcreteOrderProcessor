package org.example.orderapp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.example.orderapp.model.Order;
import org.example.orderapp.parser.OrderProcessor;
import org.example.orderapp.parser.impl.OrderProcessorFactory;

public class FileManager {


    public List<Order> readFileLineByLine(String inboundFilePath) {
        Path path = Path.of(inboundFilePath);
        InboundFileFormatEnum fileFormat = FileFormatDetector.detectByExtension(path);
        OrderProcessor processor = OrderProcessorFactory.createOrderProcessor(fileFormat);

        List<Order> orders = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {

                orders.add(processor.parseLineToOrder(line));
            }
            System.out.println("ORDERS:\n" + orders + "\n===========");
            return orders;
        } catch (IOException e) {
            throw new UncheckedIOException(
                    "Failed to read file: " + inboundFilePath, e);
        }
    }

    public void writeReceiptsToFile(Map<String, Double> receipts, String outboundFilePath) {
        try {
            for (Map.Entry<String, Double> entry : receipts.entrySet()) {
                String customerName = entry.getKey();
                double totalCost = entry.getValue();
                String resultingString = String.format("%s - %.2f%n", customerName, totalCost);
                Path path = Paths.get(outboundFilePath);
                Files.writeString(path, resultingString, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (ClassCastException e) {
            System.err.println("Error: List element types do not match the expected format. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}
