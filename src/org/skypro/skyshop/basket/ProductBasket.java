package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int countProduct = 0;

    public void addProduct(Product product) {
        if (countProduct < products.length) {
            products[countProduct] = product;
            countProduct++;
        } else {
            System.out.println("Невозможно добавить больше товаров");
        }
    }

    public int getCostProducts() {
        int cost = 0;
        for (int i = 0; i < countProduct; i++) {
            cost += products[i].getPrice();
        }
        return cost;
    }

    public void print() {
        if (this.isEmpty()) {
            return;
        }
        int countSpecialProduct = 0;
        for (int i = 0; i < countProduct; i++) {
            System.out.printf(products[i].toString());
            countSpecialProduct += products[i].isSpecial() ? 1 : 0;
        }
        System.out.printf("Итого : %d\n", getCostProducts());
        System.out.printf("Специальных товаров : %d\n", countSpecialProduct);
    }

    public boolean isContains(String name) {
        for (int i = 0; i < countProduct; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return countProduct == 0;
    }

    public void clear() {
        for (int i = 0; i < countProduct; i++) {
            products[i] = null;
        }
        countProduct = 0;
    }
}
