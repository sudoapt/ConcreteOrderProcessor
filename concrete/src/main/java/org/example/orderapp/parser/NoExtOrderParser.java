package org.example.orderapp.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NoExtOrderParser {

    public record DataLine(LocalDateTime timestamp, String customerName, double orderAmount) {}

    public static void main(String[] args) {
        try{

            List<DataLine> records = parseNoExtFile("concrete/data/inbound_files/discount_day_without_ext");
            records.forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println("Error reading the file: " + ex.getMessage());
        }
        
    }

    public static List<DataLine> parseNoExtFile(String filepath) throws IOException {

        
        try (Stream<String> lines = Files.lines(Paths.get(filepath))){
            return lines
            .filter(line -> !line.trim().isEmpty()) // use line if not empty (gotta be tested)
            .map(NoExtOrderParser::parseLine)
            .collect(Collectors.toList());
        }

    }

    // map textline into DataLine structure
    private static DataLine parseLine(String dataLine) {
        String[] entries = dataLine.split("#"); // 2021-02-09T16:00:22#Industrial#8800

        LocalDateTime timestamp = LocalDateTime.parse(entries[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String customerName = entries[1];
        double orderAmount = Double.parseDouble(entries[2]);

        return new DataLine(timestamp, customerName, orderAmount);

    }

  

}
