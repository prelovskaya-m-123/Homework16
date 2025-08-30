package org.skypro.skyshop.article;

import org.skypro.skyshop.util.Searchable;

public final class Article implements Searchable {

    private final String title;
    private final String articleText;

    public Article(String title, String articleText) {

        if (title == null || articleText == null) {
            throw new IllegalArgumentException("Название и текст не могут быть null");
        }

        this.title = title;
        this.articleText = articleText;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + articleText;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }


    public String getName() {
        return title;
    }


    @Override
    public String toString() {
        return  title + '\'' +
                articleText;
    }
}
