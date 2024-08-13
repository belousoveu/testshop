package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.service.SearchEngine;

import java.io.IOException;
import java.util.Arrays;

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

            System.out.println(article1.toString());

            SearchEngine searchEngine = new SearchEngine(15);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);
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

            System.out.println("searchEngine.search(\"Avanti\") = " + Arrays.toString(searchEngine.search("Avanti")));
            System.out.println("searchEngine.search(\"сил\") = " + Arrays.toString(searchEngine.search("сил")));
            System.out.println("searchEngine.search(\"Кабель\") = " + Arrays.toString(searchEngine.search("Кабель")));
            System.out.println("searchEngine.search(\"ключ\") = " + Arrays.toString(searchEngine.search("ключ")));


            ProductBasket basket1 = new ProductBasket();
            ProductBasket basket2 = new ProductBasket();

            basket1.addProduct(product1);
            basket1.addProduct(product2);
            basket1.addProduct(product4);
            basket1.addProduct(product5);
            basket1.addProduct(product6);
            basket1.addProduct(product7);

            basket2.addProduct(product2);
            basket2.addProduct(product4);
            basket2.addProduct(product8);
            basket2.addProduct(product10);

            basket1.print();
            basket2.print();

            System.out.println("basket1.getCostProducts() = " + basket1.getCostProducts());
            System.out.println("basket2.getCostProducts() = " + basket2.getCostProducts());

            System.out.println("basket2.isContains(\"Product 1\") = " + basket2.isContains("Product 1"));
            System.out.println("basket2.isContains(\"Product 2\") = " + basket2.isContains("Product 2"));

            basket1.clear();

            basket1.print();
            System.out.println("basket1.getCostProducts() = " + basket1.getCostProducts());
            System.out.println("basket1.isContains(\"Product 3\") = " + basket1.isContains("Product 2"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}