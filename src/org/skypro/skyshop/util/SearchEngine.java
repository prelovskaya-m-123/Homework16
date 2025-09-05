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

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxOccurrences = -1;

        String lowerQuery = query.toLowerCase();

        for (int i = 0; i < currentSize; i++) {
            Searchable searchable = searchables[i];
            String searchTerm = searchable.getSearchTerm().toLowerCase();
            
            int occurrences = countSubstringOccurrences(searchTerm, lowerQuery);

            if (occurrences > 0 && occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(query);
        }

        return bestMatch;
    }


    private int countSubstringOccurrences(String str, String substring) {
        if (str == null || substring == null|| substring.isEmpty()) {
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
