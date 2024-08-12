package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Product 1", 15);
        Product product2 = new SimpleProduct("Product 2", 20);
        Product product3 = new SimpleProduct("Product 3", 50);
        Product product4 = new SimpleProduct("Product 4", 15);
        Product product5 = new SimpleProduct("Product 5", 30);
        Product product6 = new SimpleProduct("Product 6", 10);
        Product product7 = new SimpleProduct("Product 7", 35);
        Product product8 = new DiscountedProduct("Product 8", 60, 10);
        Product product9 = new DiscountedProduct("Product 9", 20, 20);
        Product product10 = new FixPriceProduct("Product 10");

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


    }
}