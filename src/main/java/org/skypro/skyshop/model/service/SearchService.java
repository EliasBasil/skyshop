package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<SearchResult> search(String searchQuery) {
        return storageService.getAllSearchables().values().stream()
                .filter(p -> p.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toSet());
    }
}
