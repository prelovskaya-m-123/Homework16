package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] products;
    private int size = 0;
    private final int MAX_SIZE = 5;

    public ProductBasket() {
        products = new Product[MAX_SIZE];
    }

    public void addProduct(Product product) {
        System.out.println("ДОБАВЛЕНИЕ ПРОДУКТА В КОРЗИНУ");
            if (size == MAX_SIZE) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[size] = product;
        size++;
    }

    public int getTotalCost() {
        System.out.println("ПОЛУЧЕНИЕ СТОИМОСТИ КОРЗИНЫ");
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                total += products[i].getPrice();
            }
        }
        if (total == 0) {
            System.out.println("Корзина пуста, стоимость: 0");
        }
        return total;
    }

    public void printInfo() {
        System.out.println("ПЕЧАТЬ СОДЕРЖИМОГО КОРЗИНЫ");
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean containsProduct(String productName) {
        System.out.println("ПОИСК ТОВАРА В КОРЗИНЕ");
        for (int i = 0; i < size; i++) {
            if (products[i] != null && products[i].getName().equalsIgnoreCase(productName)) {
                System.out.println("Продукт " + productName + " найден в корзине");
                return true;
            }
        }
        System.out.println("Продукта " + productName + " нет в корзине");
        return false;
    }

    public void clearBasket() {
        System.out.println("ОЧИСТКА КОРЗИНЫ");
        for (int i = 0; i < MAX_SIZE; i++) {
            products[i] = null;
        }
        size = 0;
    }
}











