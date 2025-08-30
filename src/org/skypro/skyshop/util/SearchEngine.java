package org.skypro.skyshop.util;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentSize;

    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительным числом");
        }
        this.searchables = new Searchable[capacity];
        this.currentSize = 0;
    }

    public void add(Searchable searchable) {
        if (currentSize >= searchables.length) {
            throw new IllegalStateException("Превышена максимальная емкость поискового движка");
        }
        if (searchable == null) {
            throw new NullPointerException("Объект для поиска не может быть null");
        }
        searchables[currentSize++] = searchable;
    }

    public Searchable[] search(String query) {
        if (query == null || query.isEmpty()) {
            return new Searchable[0];
        }

        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        String lowerQuery = query.toLowerCase();

        for (int i = 0; i < currentSize; i++) {
            Searchable searchable = searchables[i];
            String searchTerm = searchable.getSearchTerm().toLowerCase();

            if (searchTerm.contains(lowerQuery)) {
                results[resultIndex++] = searchable;
                
                if (resultIndex == 5) {
                    break;
                }
            }
        }

        return results;
    }
}
