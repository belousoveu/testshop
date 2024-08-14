package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();
    private int countProduct = 0;
    private int totalCost = 0;

    public void addProduct(Product product) {
        products.add(product);
        countProduct++;
        totalCost += product.getPrice();
    }

    public List<Product> remove(String name) {
        List<Product> result = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
                iterator.remove();
                countProduct--;
                totalCost -= product.getPrice();
            }
        }
        return result;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void print() {
        if (this.isEmpty()) {
            return;
        }
        int countSpecialProduct = 0;
        for (Product product : products) {
            System.out.printf(product.toString());
            countSpecialProduct += product.isSpecial() ? 1 : 0;
        }
        System.out.printf("Итого : %d\n", getTotalCost());
        System.out.printf("Специальных товаров : %d\n", countSpecialProduct);
    }

    public boolean isContains(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return countProduct == 0;
    }

    public void clear() {
        products.clear();
        countProduct = 0;
        totalCost = 0;
    }
}
