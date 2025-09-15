package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        try {
            basket.addProduct(new DiscountedProduct("Шампунь", 280, 10));
            basket.addProduct(new FixPriceProduct("Цветные карандаши"));
            basket.addProduct(new SimpleProduct("Тетрадь", 30));
            basket.addProduct(new SimpleProduct("Яблочный сок", 130));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
            System.out.println();

            basket.printInfo();
            System.out.println();

            try {
            basket.addProduct(new SimpleProduct("Зефир", 140));
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }

            System.out.println();

            basket.containsProduct("Зефир");
            System.out.println();

            basket.containsProduct("Печенье");
            System.out.println();


        // Удаляем существующий продукт (шампунь):
        List<Product> removedProducts = basket.removeProductsByName("Шампунь");

        System.out.println("УДАЛЕННЫЕ ПРОДУКТЫ: ");
        for (Product product : removedProducts) {
            System.out.println("- " + product.getFormattedInfo());
        }

        System.out.println();

        // Содержимое корзины после удаления:
        basket.printInfo();
        System.out.println();

        // Удаляем существующий продукт (шоколад):
        List<Product> removedNonExisting = basket.removeProductsByName("Шоколад");

        // Проверяем результат
        if (removedNonExisting.isEmpty()) {
            System.out.println("Список удаленных продуктов: Список пуст");
        } else {
            System.out.println("Удаленные продукты:");
            for (Product product : removedNonExisting) {
                System.out.println("- " + product.getFormattedInfo());
            }
        }

        System.out.println();

        // Итоговое состояние корзины:
        basket.printInfo();
    }
}


















