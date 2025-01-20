package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discount;

    public DiscountedProduct(UUID id, String productName, int basePrice, int discount) {
        super(id, productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Неверно введена цена продукта");
        }
        this.basePrice = basePrice;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Неверно введено значение скидки");
        }
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, discount);
    }

    @Override
    public double getProductPrice() {
        return basePrice * (1 - discount / 100.0d);
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + " (" + getDiscount() + "%)";
    }


}
