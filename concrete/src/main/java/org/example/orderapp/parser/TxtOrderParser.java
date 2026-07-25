package org.example.orderapp.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtOrderParser {
    public record DataLine(LocalDateTime timestamp, String customerName, double orderAmount) {}

        public static void main(String[] args) {
        try{

            ArrayList<DataLine> records = parseTxtOrderParser("concrete/data/inbound_files/discount_day.txt");
            records.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println("Error reading the file: " + ex.getMessage());
        }
        
    }

    public static ArrayList<DataLine> parseTxtOrderParser(String filepath) throws IOException {
        
        try (Stream<String> lines = Files.lines(Paths.get(filepath))) {
            return lines
            .filter(line -> !line.trim().isEmpty())
            .map(TxtOrderParser::parseLine)
            .collect(Collectors.toCollection(ArrayList::new));
        }
    }


    private static DataLine parseLine(String dataLine) {
        String[] entries = dataLine.split("\\|"); //2021-02-09T16:00:22|Industrial|8800

        LocalDateTime timestamp = LocalDateTime.parse(entries[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String customerName = entries[1];
        double orderAmount = Double.parseDouble(entries[2]);

        return new DataLine(timestamp, customerName, orderAmount);
    } 

}
