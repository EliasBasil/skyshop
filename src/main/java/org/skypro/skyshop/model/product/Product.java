package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final String productName;
    private final UUID id;

    public Product(UUID id, String productName) {
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Неверно введено название продукта");
        }
        this.productName = productName;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public abstract double getProductPrice();

    public abstract boolean isSpecial();

    @JsonIgnore
    public String getSearchTerm() {
        return productName;
    }

    @JsonIgnore
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
