package org.skypro.skyshop.util;

public class BestResultNotFound extends Exception {

    private String query;

    public BestResultNotFound(String query) {
        super("Не найдено подходящих результатов для запроса: " + query);
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

