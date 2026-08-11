package org.example.orderapp.parser.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.orderapp.model.Order;
import org.example.orderapp.parser.OrderProcessor;

public class OrderAdapter implements OrderProcessor {

    private final OrderParserImpl parser;

    private static final Pattern DELIMITER_PATTERN = Pattern
            .compile("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}([^a-zA-Z0-9])");

    public OrderAdapter(OrderParserImpl parser) {
        this.parser = parser;
    }

    @Override
    public Order parseLineToOrder(String dataline) {

        String convertedDataline = dataline;
        Matcher matcher = DELIMITER_PATTERN.matcher(dataline);

        if (matcher.find()) {
            String foundDelimeter = matcher.group(1);
            if (!"|".equals(foundDelimeter)) {
                convertedDataline = dataline.replaceAll(Pattern.quote(foundDelimeter), "|");
            }
        }

        return parser.parseLineToOrder(convertedDataline);

    }

}
