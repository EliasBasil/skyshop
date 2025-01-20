package org.skypro.skyshop.model.search;

import java.util.Objects;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId().toString(), searchable.getSearchTerm(), searchable.getContentType());
    }

    @Override
    public String toString() {
        return "<p>id = " + id + "</p>" +
                "<p>name = " + name + "</p>" +
                "<p>contentType = " + contentType + "</p>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchResult that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(contentType, that.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contentType);
    }
}
