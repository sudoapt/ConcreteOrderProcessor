package org.example.orderapp.service;

public record PricingConfig(
        double productPrice,
        double productPriceDiscount,
        double discountStepdown) {
}
