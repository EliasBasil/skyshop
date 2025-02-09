package org.skypro.skyshop.model.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBasket that)) return false;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(((UserBasket) o).list.get(i))) {
                return false;
            }
        }
        return Double.compare(total, that.total) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
