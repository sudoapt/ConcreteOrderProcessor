package org.example.orderapp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.example.orderapp.model.Order;
import org.example.orderapp.parser.OrderProcessor;
import org.example.orderapp.parser.impl.OrderProcessorFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FileManagerTest {

    private final FileManager fileManager = new FileManager();

    @Test
    void testReadFileLineByLine() {
        String mockPathStr = "resources/mockPath.txt";
        String mockFileData = "mockLine1\nmockLine2";

        Path mockPath = mock(Path.class);
        OrderProcessor mockProcessor = mock(OrderProcessor.class);
        Order mockOrder1 = mock(Order.class); // line1
        Order mockOrder2 = mock(Order.class); // line2

        BufferedReader mockReader = new BufferedReader(new StringReader(mockFileData));

        when(mockProcessor.parseLineToOrder("mockLine1")).thenReturn(mockOrder1);
        when(mockProcessor.parseLineToOrder("mockLine2")).thenReturn(mockOrder2);

        try (MockedStatic<Path> mockedPath = mockStatic(Path.class);
                MockedStatic<FileFormatDetector> mockedDetector = mockStatic(FileFormatDetector.class);
                MockedStatic<OrderProcessorFactory> mockedFactory = mockStatic(OrderProcessorFactory.class);
                MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {

            mockedPath.when(() -> Path.of(mockPathStr)).thenReturn(mockPath);
            mockedDetector.when(() -> FileFormatDetector.detectByExtension(mockPath))
                    .thenReturn(InboundFileFormatEnum.TXT);
            mockedFactory.when(() -> OrderProcessorFactory.createOrderProcessor(InboundFileFormatEnum.TXT))
                    .thenReturn(mockProcessor);
            mockedFiles.when(() -> Files.newBufferedReader(mockPath)).thenReturn(mockReader);

            List<Order> result = fileManager.readFileLineByLine(mockPathStr);

            assertEquals(2, result.size()); // got 2 lines
            assertSame(mockOrder1, result.get(0));
            assertSame(mockOrder2, result.get(1));

        }
    }

    @Test
    void testWriteReceiptsToFile(@TempDir Path tempDir) throws IOException {

        Path tempFile = tempDir.resolve("output.txt");
        String filePath = tempFile.toAbsolutePath().toString();

        Map<String, Double> receipts = new LinkedHashMap<>();
        receipts.put("Firm1", 20.50);
        receipts.put("Firm2", 10.05);

    
        fileManager.writeReceiptsToFile(receipts, filePath);

      
        String expectedString = String.format("Firm1 20.50%nFirm2 10.05%n");
        String actualString = Files.readString(tempFile);
        assertEquals(expectedString, actualString);
    }
}
