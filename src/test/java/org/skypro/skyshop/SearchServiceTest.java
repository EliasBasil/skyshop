package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;
    @InjectMocks
    private SearchService searchService;

    @Test
    public void whenProductExists_thenReturnProduct() {
        UUID uuid = UUID.randomUUID();
        Set<SearchResult> products = new HashSet<>();
        products.add(SearchResult.fromSearchable(new SimpleProduct(uuid, "сыр", 100)));
        Mockito.when(storageService.getAllSearchables())
                .thenReturn(Map.of(uuid, new SimpleProduct(uuid, "сыр", 100)));
        Assertions.assertEquals(products, searchService.search("сыр"));
    }

    @Test
    public void whenProductDoesNotExist_thenReturnEmptySet() {
        UUID uuid = UUID.randomUUID();
        Mockito.when(storageService.getAllSearchables())
                .thenReturn(Map.of(uuid, new SimpleProduct(uuid, "сыр", 100)));
        Set<SearchResult> set = searchService.search("маракуйя");
        Assertions.assertTrue(set.isEmpty());
    }

    @Test
    public void whenStorageIsEmpty_thenReturnEmptySet() {
        Mockito.when(storageService.getAllSearchables())
                .thenReturn(Map.of());
        Set<SearchResult> set = searchService.search("сыр");
        Assertions.assertTrue(set.isEmpty());
    }
}
