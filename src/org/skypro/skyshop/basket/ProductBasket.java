package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Map<String, List<Product>> productsMap;
    private final int MAX_SIZE = 5;

    public ProductBasket() {
        productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        System.out.println("ДОБАВЛЕНИЕ ПРОДУКТА В КОРЗИНУ");
        int currentSize = getTotalProductCount();
        if (currentSize >= MAX_SIZE) {
            System.out.println("Превышена максимальная ёмкость корзины");
            return;
        }

        String productName = product.getName().toLowerCase();

        List<Product> productsList = productsMap.getOrDefault(productName, new ArrayList<>());
        productsList.add(product);
        productsMap.put(productName, productsList);
    }

    public List<Product> removeProductsByName(String name) {
        System.out.println("УДАЛЕНИЕ ПРОДУКТА ПО ИМЕНИ");
        String nameLowerCase = name.toLowerCase();
        List<Product> removedProducts = new LinkedList<>();

        List<Product> productsList = productsMap.get(nameLowerCase);

        if (productsList != null) {
            removedProducts.addAll(productsList);
            productsMap.remove(nameLowerCase);
        }

        return removedProducts;
    }

    private int getTotalProductCount() {
        return productsMap.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(product -> 1)
                .sum();
    }

    public int getTotalCost() {
        System.out.println("ПОЛУЧЕНИЕ СТОИМОСТИ КОРЗИНЫ");
        int total = productsMap.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();

        if (total == 0) {
            System.out.println("Корзина пуста, стоимость: 0");
        }
        return total;
    }

    private long getSpecialCount() {
        return productsMap.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printInfo() {
        System.out.println("ПЕЧАТЬ СОДЕРЖИМОГО КОРЗИНЫ");

        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        productsMap.values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(product -> {
                    System.out.println(product.getFormattedInfo());
                });

        System.out.println("Специальных товаров: " + getSpecialCount());
        System.out.println("Итого: " + getTotalCost());
    }


    public boolean containsProduct(String productName) {
        System.out.println("ПОИСК ТОВАРА В КОРЗИНЕ");
        productName = productName.toLowerCase();

        if (productsMap.containsKey(productName)) {
            System.out.println("Продукт " + productName + " найден в корзине");
            return true;
        }

        System.out.println("Продукта " + productName + " нет в корзине");
        return false;
    }

    public void clearBasket() {
        System.out.println("ОЧИСТКА КОРЗИНЫ");
        productsMap.clear();
    }

    public void removeProduct(Product product) {
        System.out.println("УДАЛЕНИЕ ПРОДУКТА ИЗ КОРЗИНЫ");
        String productName = product.getName().toLowerCase();

        List<Product> productsList = productsMap.get(productName);
        if (productsList != null && productsList.remove(product)) {
            if (productsList.isEmpty()) {
                productsMap.remove(productName);
            }
            System.out.println("Продукт успешно удален");
        } else {
            System.out.println("Продукт не найден в корзине");
        }
    }
}
















