package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final double productPrice;

    public SimpleProduct(UUID id, String productName, int productPrice) {
        super(id, productName);
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Неверно введена цена продукта");
        }
        this.productPrice = productPrice;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice();
    }


}
