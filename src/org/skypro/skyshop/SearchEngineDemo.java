package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.util.BestResultNotFound;
import org.skypro.skyshop.util.SearchEngine;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.util.Searchable;

import java.util.List;

public class SearchEngineDemo {

    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(20);

        engine.add(new SimpleProduct("Школьный рюкзак Brauberg Premium", 5200));
        engine.add(new SimpleProduct("Мешок для сменной обуви", 290));
        engine.add(new SimpleProduct("Смартфон Realme Note 50", 5320));
        engine.add(new SimpleProduct("Пауэрбанк Xiaomi Mi Power Bank 3", 2490));

        engine.add(new Article("Как выбрать рюкзак для школьника",
                "При выборе школьного рюкзака обратите внимание на вес, наличие ортопедической спинки с мягкой подкладкой, широкие лямки с возможностью регулировки"));

        engine.add(new Article("Пауэрбанк для школьника",
                "При выборе пауэрбанка обращайте внимание на ёмкость (10000-20000 мАч), разъёмы (наличие USB-A и USB-C), скорость зарядки"));

        engine.add(new Article("Как выбрать смартфон для первоклассника",
                "Рейтинг топ-15 недорогих и мощных телефонов для детей в 2025 году"));

        // Демонстрация поиска
        testSearch(engine, "Xiaomi");
        testSearch(engine, "пауэрбанк");
        testSearch(engine, "смартфон");
        testSearch(engine, "для школьника");
        testSearch(engine, "несуществующий запрос");
    }

    private static void testSearch(SearchEngine engine, String query) {
        System.out.println("\nПоиск по запросу: " + query);

        try {
            List<Searchable> results = engine.findAllMatches(query);

            if (results.isEmpty()) {
                System.out.println("По запросу не найдено результатов");
                return;
            }

            for (Searchable result : results) {

                System.out.println("Найден объект:");
                System.out.println("Название: " + result.getName());
                System.out.println("Тип: " + result.getContentType());
                System.out.println("Описание: " + result.getSearchTerm());
                System.out.println("------------------------");
            }
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
            }
        }
    }


