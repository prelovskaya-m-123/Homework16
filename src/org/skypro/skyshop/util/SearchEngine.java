package org.skypro.skyshop.util;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;
    private final int capacity;

    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительным числом");
        }
        this.searchables = new TreeSet<>(new SearchableComparator());
            this.capacity = capacity;
    }

    public void add(Searchable searchable) {
        if (searchables.size() >= capacity) {
            throw new IllegalStateException("Превышена максимальная емкость поискового движка");
        }
        if (searchable == null) {
            throw new NullPointerException("Объект для поиска не может быть null");
        }
        searchables.add(searchable);
    }

    public Set<Searchable> findAllMatches(String query) throws BestResultNotFound {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        String lowerQuery = query.toLowerCase();

        Set<Searchable> matchingResults = searchables.stream()
                .filter(searchable -> {
                    String searchTerm = searchable.getSearchTerm().toLowerCase();
                    return countSubstringOccurrences(searchTerm, lowerQuery) > 0;
                })
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));

        if (matchingResults.isEmpty()) {
            throw new BestResultNotFound(query);
        }
        return matchingResults;
    }

    private int countSubstringOccurrences(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        int substringIndex = str.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substringLength;
            substringIndex = str.indexOf(substring, index);
        }

        return count;
    }
}
