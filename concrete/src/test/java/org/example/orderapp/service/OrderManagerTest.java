package org.example.orderapp.service;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.example.orderapp.model.Order;
import org.example.orderapp.utils.FileManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderManagerTest {

    @Mock
    private FileManager fileManager;

    @Mock
    private OrderPriceManager priceManager;

    @InjectMocks
    private OrderManager orderManager;

    @Test
    void testManageOrders() {
        double productPrice = 2.0;
        double productPriceDiscount = 50.0;
        double discountStepdown = 5.0;
        String inboundPath = "input.txt";
        String outboundPath = "output.txt";

        List<Order> mockOrders = new ArrayList<Order>();
        Order mockSingleOrder = mock(Order.class);
        mockOrders.add(mockSingleOrder);

        Map<String, Double> mockReceipts = new HashMap<>();
        mockReceipts.put("Order_001", 90.0);


        // defining dependencies
        when(fileManager.readFileLineByLine(inboundPath)).thenReturn(mockOrders);
        when(priceManager.checkoutOrder(mockOrders, productPrice, productPriceDiscount, discountStepdown))
                .thenReturn(mockReceipts);

        // run target method
        orderManager.manageOrders(productPrice, productPriceDiscount, discountStepdown, inboundPath, outboundPath);

        // actual mock run
        verify(fileManager, times(1)).readFileLineByLine(inboundPath);
        verify(priceManager, times(1)).checkoutOrder(mockOrders, productPrice,
                productPriceDiscount, discountStepdown);
        verify(fileManager, times(1)).writeReceiptsToFile(mockReceipts, outboundPath);

    }
}
