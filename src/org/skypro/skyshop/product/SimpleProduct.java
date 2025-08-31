package org.skypro.skyshop.product;

import org.skypro.skyshop.util.Searchable;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0){
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getFormattedInfo() {
        return "<" + getName() + ">" + ":" + "<" + price + ">";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}






