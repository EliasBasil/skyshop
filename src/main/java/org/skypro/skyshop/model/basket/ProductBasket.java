package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> basket;

    public ProductBasket(Map<UUID, Integer> basket) {
        this.basket = basket;
    }

    public void addProduct(UUID id) {
        basket.merge(id, 1, Integer::sum);
    }

    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }
}
