package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        productStorage = new TreeMap<>();
        articleStorage = new TreeMap<>();
        fillStorages();
    }

    public Map<UUID, Product> getProductStorage() {
        return productStorage;
    }

    public Map<UUID, Article> getArticleStorage() {
        return articleStorage;
    }

    public Map<UUID, Searchable> getAllSearchables() {
        Map<UUID, Searchable> allSearchables = new TreeMap<>();
        allSearchables.putAll(productStorage);
        allSearchables.putAll(articleStorage);
        return allSearchables;
    }

    private void fillStorages() {
        Product cheese = new SimpleProduct(UUID.randomUUID(), "сыр", 100);
        Product potatoes = new DiscountedProduct(UUID.randomUUID(), "картофель", 250, 20);
        Product eggs = new DiscountedProduct(UUID.randomUUID(), "яйца", 70, 50);
        Product milk = new FixPriceProduct(UUID.randomUUID(), "молоко");
        Product chicken = new SimpleProduct(UUID.randomUUID(), "курица", 300);
        Product tomatoes = new SimpleProduct(UUID.randomUUID(), "помидоры", 140);
        productStorage.put(cheese.getId(), cheese);
        productStorage.put(potatoes.getId(), potatoes);
        productStorage.put(eggs.getId(), eggs);
        productStorage.put(milk.getId(), milk);
        productStorage.put(chicken.getId(), chicken);
        productStorage.put(tomatoes.getId(), tomatoes);

        Article cheeseArticle = new Article(UUID.randomUUID(),
                "Статья про сыр", "Сыр - это очень вкусно");
        Article badCheeseArticle = new Article(UUID.randomUUID(),
                "Опровержение!", "Сыр - это ужасно");
        Article anotherCheeseArticle = new Article(UUID.randomUUID(),
                "Это - статья про сыр №2", "Больше сыра богу сыра");
        Article yetAnotherCheeseArticle = new Article(UUID.randomUUID(),
                "Еще одна статья про сыр", "Добавьте к нему помидоры");
        Article tomatoArticle = new Article(UUID.randomUUID(),
                "Статья про помидоры", "Они еще вкуснее, чем эти моцареллы и бри");
        Article milkArticle = new Article(UUID.randomUUID(),
                "Статья про молоко", "Я просто статья про молоко");
        articleStorage.put(cheeseArticle.getId(), cheeseArticle);
        articleStorage.put(badCheeseArticle.getId(), badCheeseArticle);
        articleStorage.put(anotherCheeseArticle.getId(), anotherCheeseArticle);
        articleStorage.put(yetAnotherCheeseArticle.getId(), yetAnotherCheeseArticle);
        articleStorage.put(tomatoArticle.getId(), tomatoArticle);
        articleStorage.put(milkArticle.getId(), milkArticle);
    }
}
