package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        try {
            basket.addProduct(new DiscountedProduct("Шампунь", 280, 10));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
        try {
            basket.addProduct(new DiscountedProduct("Стиральный порошок", 400, -1));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
        try {
            basket.addProduct(new DiscountedProduct(null, 150, 20));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
        try {
            basket.addProduct(new FixPriceProduct("Цветные карандаши"));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
        try {
            basket.addProduct(new SimpleProduct("Тетрадь", 0));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
        try {
            basket.addProduct(new SimpleProduct("Яблочный сок", 130));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
            basket.printInfo();

            System.out.println();
        try {
            basket.addProduct(new SimpleProduct("Зефир", 140));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }

            System.out.println();

            basket.containsProduct("Шампунь");
            System.out.println();

            basket.containsProduct("Печенье");
            System.out.println();

            basket.clearBasket();
            System.out.println();

            basket.printInfo();
            System.out.println();

            basket.getTotalCost();

            System.out.println();

            basket.containsProduct("Шампунь");

            basket.printInfo();

    }
}

