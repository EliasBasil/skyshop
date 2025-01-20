package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket basket, StorageService storageService) {
        this.productBasket = basket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) {
        Optional<Product> optionalProduct = getProductById(id);
        if (optionalProduct.isPresent()) {
            productBasket.addProduct(id);
        } else {
            throw new IllegalArgumentException("Product doesn't exist");
        }
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basket = productBasket.getBasket();
        List<BasketItem> basketItems = basket.entrySet().stream()
                .map(p -> new BasketItem(storageService.getProductStorage().get(p.getKey()), p.getValue()))
                .collect(Collectors.toList());
        return new UserBasket(basketItems);
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(storageService.getProductStorage().get(id));
    }
}
