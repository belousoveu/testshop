package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.service.SearchEngine;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            Product product1 = new SimpleProduct("Кабель КСРВнг(А)-FRLSLTx", 15);
            Product product2 = new SimpleProduct("Провод силовой ПуГВ 1х6", 20);
            Product product3 = new SimpleProduct("Кабель силовой ВВГнг(А)-LS 3х1.5", 50);
            Product product4 = new SimpleProduct("Провод СИП-4 4х16", 15);
            Product product5 = new SimpleProduct("Кабель-канал 25х16", 30);
            Product product6 = new SimpleProduct("Выключатель автоматический 2Р 16А х-ка C ВА-103 6кА", 10);
            Product product7 = new SimpleProduct("Выключатель дифференциального тока УЗО 03-6кА-2P-063А-030-A", 35);
            Product product8 = new DiscountedProduct("Avanti Выключатель одноклавишный", 60, 10);
            Product product9 = new DiscountedProduct("Выключатель одноклавишный, 16А 250В", 20, 20);
            Product product10 = new FixPriceProduct("Розетка силовая с заземлением красная РКС- 20-32-П-К");

            Article article1 = new Article("HFLTx - миф.txt");
            Article article2 = new Article("Выбираем УЗО для безопасного электрощита.txt");
            Article article3 = new Article("Знакомьтесь, Avanti!.txt");
            Article article4 = new Article("Тестовая статья", "Тест, УЗО выключатель автоматический, провод");

            System.out.println(article1);

            SearchEngine searchEngine = new SearchEngine();
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);
            searchEngine.add(article4);
            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(product3);
            searchEngine.add(product4);
            searchEngine.add(product5);
            searchEngine.add(product6);
            searchEngine.add(product7);
            searchEngine.add(product8);
            searchEngine.add(product9);
            searchEngine.add(product10);

            searchEngine.search("Avanti").forEach(System.out::println);
            searchEngine.search("сил").forEach(System.out::println);
            searchEngine.search("Кабель").forEach(System.out::println);
            searchEngine.search("ключ").forEach(System.out::println);

            System.out.println("searchEngine.getBestResult(\"Кабель\") = " + searchEngine.getBestResult("Кабель"));
            System.out.println("searchEngine.getBestResult(\"УЗО\") = " + searchEngine.getBestResult("УЗО"));
//            System.out.println("searchEngine.getBestResult(\"узор\") = " + searchEngine.getBestResult("узор"));


            ProductBasket basket1 = new ProductBasket();
            ProductBasket basket2 = new ProductBasket();

            basket1.addProduct(product1);
            basket1.addProduct(product1);
            basket1.addProduct(product4);
            basket1.addProduct(product5);
            basket1.addProduct(product6);
            basket1.addProduct(product7);

            basket2.addProduct(product2);
            basket2.addProduct(product4);
            basket2.addProduct(product8);
            basket2.addProduct(product10);

            basket1.print();
            List<Product> removed = basket1.remove("Кабель КСРВнг(А)-FRLSLTx");
            removed.forEach(System.out::println);
            removed = basket1.remove("Avanti Выключатель одноклавишный");
            basket1.print();
            if (!removed.isEmpty()) {
                removed.forEach(System.out::println);
            } else {
                System.out.println("Список пуст");
            }

            basket1.print();

            basket2.print();

            System.out.println("basket1.getCostProducts() = " + basket1.getTotalCost());
            System.out.println("basket2.getCostProducts() = " + basket2.getTotalCost());

            System.out.println("basket2.isContains(\"Product 1\") = " + basket2.isContains("Product 1"));
            System.out.println("basket2.isContains(\"Product 2\") = " + basket2.isContains("Product 2"));

            basket1.clear();

            basket1.print();
            System.out.println("basket1.getCostProducts() = " + basket1.getTotalCost());
            System.out.println("basket1.isContains(\"Product 3\") = " + basket1.isContains("Product 2"));

        } catch (IOException | IllegalArgumentException | BestResultNotFoundException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}