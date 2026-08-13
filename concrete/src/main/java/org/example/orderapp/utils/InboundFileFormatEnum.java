package org.example.orderapp.utils;

import org.example.orderapp.parser.OrderProcessor;
import org.example.orderapp.parser.impl.OrderNoExtAdapter;
import org.example.orderapp.parser.impl.OrderTxtPipeParser;

public enum InboundFileFormatEnum {
    TXT {
        @Override
        public OrderProcessor create(OrderTxtPipeParser parser) {
            // return new OrderNoExtAdapter(parser);
            return parser;
        }
    },

    NOEXT {
        @Override
        public OrderProcessor create(OrderTxtPipeParser parser) {
            return new OrderNoExtAdapter(parser);
        }
    };

    // The abstract contract for enums to implement
    public abstract OrderProcessor create(OrderTxtPipeParser parser);
}
