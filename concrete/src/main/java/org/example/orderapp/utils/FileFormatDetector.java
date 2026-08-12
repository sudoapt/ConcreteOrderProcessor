package org.example.orderapp.utils;

import java.nio.file.Path;

public class FileFormatDetector {
    public static InboundFileFormatEnum detectByExtension(Path filePath) {
        String fileName = filePath.getFileName().toString().toLowerCase();

        if (fileName.endsWith(".txt")) {
            return InboundFileFormatEnum.TXT;
        }

        return InboundFileFormatEnum.NOEXT;
    }
}
