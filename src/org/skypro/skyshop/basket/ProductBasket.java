package org.skypro.skyshop.basket;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.skypro.skyshop.product.Product;

public class ProductBasket implements Iterable<Product> {

    private List<Product> products;
    private final int MAX_SIZE = 5;

    public ProductBasket() {
        products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        System.out.println("ДОБАВЛЕНИЕ ПРОДУКТА В КОРЗИНУ");
        if (products.size() < MAX_SIZE) {
            products.add(product);
        }
    }

    public List<Product> removeProductsByName(String name) {
        System.out.println("УДАЛЕНИЕ ПРОДУКТА ПО ИМЕНИ");
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                removedProducts.add(product);
            }
        }
        return removedProducts;
    }

    @Override
    public Iterator<Product> iterator() {
        return new ProductIterator();
    }

    private class ProductIterator implements Iterator<Product> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < products.size();
        }

        @Override
        public Product next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return products.get(currentIndex++);
        }

        @Override
        public void remove() {
            if (currentIndex == 0) {
                throw new IllegalStateException();
            }
            products.remove(--currentIndex);
        }
    }


    public int getTotalCost() {
        System.out.println("ПОЛУЧЕНИЕ СТОИМОСТИ КОРЗИНЫ");
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        if (total == 0) {
            System.out.println("Корзина пуста, стоимость: 0");
        }
        return total;
    }

    public void printInfo() {
        System.out.println("ПЕЧАТЬ СОДЕРЖИМОГО КОРЗИНЫ");
        int total = 0;
        int specialProductsCount = 0;

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getFormattedInfo());
            total += product.getPrice();

            if (product.isSpecial()) {
                specialProductsCount++;
            }
        }
        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialProductsCount);
        System.out.println("Итого: " + getTotalCost());
    }


    public boolean containsProduct(String productName) {
        System.out.println("ПОИСК ТОВАРА В КОРЗИНЕ");
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.println("Продукт " + productName + " найден в корзине");
                return true;
            }
        }
        System.out.println("Продукта " + productName + " нет в корзине");
        return false;
    }

    public void clearBasket() {
        System.out.println("ОЧИСТКА КОРЗИНЫ");
        products.clear();
    }

    public void removeProduct(Product product) {
        System.out.println("УДАЛЕНИЕ ПРОДУКТА ИЗ КОРЗИНЫ");
        if (products.remove(product)) {
            System.out.println("Продукт успешно удален");
        } else {
            System.out.println("Продукт не найден в корзине");
        }
    }
}
















