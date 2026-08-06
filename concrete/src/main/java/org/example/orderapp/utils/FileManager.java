package org.example.orderapp.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.example.orderapp.model.Receipt;

public class FileManager {

    public List<String> readFileLineByLine(String inboundFilePath) {
        try {
            return Files.readAllLines(Path.of(inboundFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + inboundFilePath, e);
        }
    }

    public void writeOdredToFile(List<Receipt> receipts, String outboundFilePath) {
        try {
            for (Receipt receipt : receipts) {
                String customerName = receipt.getCustomerName();
                double totalCost = receipt.getTotalCost();
                String resultingString = String.format("%s %.2f%n", customerName, totalCost);
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
