package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.Objects;

public class BasketItem {
    private final Product product;
    private final int quantity;

    public BasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasketItem that)) return false;
        return quantity == that.quantity && Objects.equals(product.getProductName(), that.product.getProductName())
                && Objects.equals(product.getId(), that.product.getId())
                && product.getProductPrice() == that.product.getProductPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
