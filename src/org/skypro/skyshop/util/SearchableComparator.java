package org.skypro.skyshop.util;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());

        if (lengthCompare != 0) {
            return lengthCompare;
        }

        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}