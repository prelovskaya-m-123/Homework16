package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product milk = new Product("Milk", 60);
        Product cheese = new Product("Cheese", 150);
        Product bread = new Product("Bread", 40);
        Product bananas = new Product("Bananas", 150);
        Product potatoes = new Product("Potatoes", 100);
        Product yogurt = new Product("Yogurt", 50);

        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(bread);
        basket.addProduct(bananas);
        basket.addProduct(potatoes);
        basket.printInfo();
        System.out.println();

        basket.addProduct(yogurt);
        System.out.println();

        basket.containsProduct("cheese");
        System.out.println();

        basket.containsProduct("lemon");
        System.out.println();

        basket.clearBasket();
        System.out.println();

        basket.printInfo();
        System.out.println();

        basket.getTotalCost();
        System.out.println();

        basket.containsProduct("bananas");









    }
}

