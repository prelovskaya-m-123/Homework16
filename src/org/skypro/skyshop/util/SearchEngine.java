package org.skypro.skyshop.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;
    private final int capacity;

    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительным числом");
        }
        this.searchables = new ArrayList<>(capacity);
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

    public Map<String, Searchable> findAllMatches(String query) throws BestResultNotFound {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Map<String, Searchable> matchingResults = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        String lowerQuery = query.toLowerCase();

        for (Searchable searchable : searchables) {
            String searchTerm = searchable.getSearchTerm().toLowerCase();
            
            int occurrences = countSubstringOccurrences(searchTerm, lowerQuery);

            if (occurrences > 0) {
                String name = searchable.getName();
                matchingResults.put(name,searchable);
            }
        }

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
