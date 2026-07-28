package org.example.orderapp.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    // public static void main(String[] args) {
    // FileReader fr = new FileReader();
    // try {
    // List<String> res =
    // readFileLineByLine("concrete/data/inbound_files/discount_day_without_ext");
    // System.out.println(res);
    // } catch (Exception e) {
    // }
    //
    public List<String> readFileLineByLine(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath));
    }

}
