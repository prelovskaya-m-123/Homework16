package org.skypro.skyshop.product;

import org.skypro.skyshop.util.Searchable;

public abstract class Product implements Searchable {

    private final String name;

    public Product(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название товара не может быть пустым");
        }
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract String getFormattedInfo();

    public abstract boolean isSpecial();

}


