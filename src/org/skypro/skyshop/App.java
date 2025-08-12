package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct shampoo = new DiscountedProduct("Шампунь", 280, 30);
        DiscountedProduct washingPowder = new DiscountedProduct("Стиральный порошок", 400, 20);
        DiscountedProduct marshmallows = new DiscountedProduct("Зефир", 150, 20);
        FixPriceProduct coloredPencils = new FixPriceProduct("Цветные карандаши");
        SimpleProduct notebook = new SimpleProduct("Тетрадь", 40);
        SimpleProduct appleJuice = new SimpleProduct("Яблочный сок", 130);

        basket.addProduct(shampoo);
        basket.addProduct(washingPowder);
        basket.addProduct(marshmallows);
        basket.addProduct(coloredPencils);
        basket.addProduct(notebook);
        basket.printInfo();
        System.out.println();

        basket.addProduct(appleJuice);
        System.out.println();

        basket.containsProduct("Зефир");
        System.out.println();

        basket.containsProduct("Печенье");
        System.out.println();

        basket.clearBasket();
        System.out.println();

        basket.printInfo();
        System.out.println();

        basket.getTotalCost();
        System.out.println();

        basket.containsProduct("Стиральный порошок");

        basket.printInfo();









    }
}

