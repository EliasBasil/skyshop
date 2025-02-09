package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.service.BasketService;
import org.skypro.skyshop.model.service.StorageService;
import org.skypro.skyshop.util.NoSuchProductException;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;
    @Mock
    private StorageService storageService;

    @InjectMocks
    BasketService basketService;

    @Test
    void whenAddingNonExistentProductToBasket_thenThrowsNoSuchProductException() {
        Mockito.when(storageService.getProductById(ArgumentMatchers.any(UUID.class))).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchProductException.class, () -> basketService.addProduct(UUID.randomUUID()));
    }

    @Test
    void whenAddingProductToBasket_thenInvokesMethodAddProductInProductBasketClass() {
        UUID uuid = UUID.randomUUID();
        Mockito.when(storageService.getProductById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.of(new SimpleProduct(uuid, "сыр", 100)));
        basketService.addProduct(uuid);
        Mockito.verify(productBasket).addProduct(uuid);
    }

    @Test
    void ifProductBasketIsEmpty_thenMethodGetUserBasketReturnsEmptyBasket() {
        Mockito.when(productBasket.getBasket()).thenReturn(Map.of());
        Assertions.assertTrue(basketService.getUserBasket().getList().isEmpty());
        Assertions.assertEquals(basketService.getUserBasket().getTotal(), 0);
    }

    @Test
    void ifProductBasketIsNotEmpty_thenMethodGetUserBasketReturnsTheSameBasket() {
        UUID uuid = UUID.randomUUID();
        Mockito.when(productBasket.getBasket()).thenReturn(Map.of(uuid, 1));
        Mockito.when(storageService.getProductStorage())
                .thenReturn(Map.of(uuid, new SimpleProduct(uuid, "сыр", 100)));
        ArrayList<BasketItem> basketItems = new ArrayList<>();
        basketItems.add(new BasketItem(new SimpleProduct(uuid, "сыр", 100), 1));
        UserBasket userBasket = new UserBasket(basketItems);

        Assertions.assertEquals(basketService.getUserBasket(), userBasket);
    }
}
