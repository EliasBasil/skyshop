package org.skypro.skyshop.model.basket;

import java.util.ArrayList;
import java.util.List;

public class UserBasket {
    private final List<BasketItem> list;
    private final double total;

    public UserBasket(List<BasketItem> list) {
        this.list = list;
        total = list.stream().mapToDouble(p -> p.getProduct().getProductPrice() * p.getQuantity()).sum();
    }

    public List<BasketItem> getList() {
        return list;
    }

    public double getTotal() {
        return total;
    }
}
