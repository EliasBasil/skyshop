package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final double PRODUCT_PRICE = 50;

    public FixPriceProduct(UUID id, String productName) {
        super(id, productName);
    }

    @Override
    public double getProductPrice() {
        return PRODUCT_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + getProductPrice();
    }
}
