package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<Product, Integer> products = new HashMap<>();
    private int countProduct = 0;
    private int totalCost = 0;

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
        countProduct++;
        totalCost += product.getPrice();
    }

    public List<Product> remove(String name) {
        List<Product> result = products.keySet().stream()
                .filter(integer -> integer.getName().equals(name))
                .toList();
        result.forEach(product -> {
            int quantity = products.get(product);
            countProduct -= quantity;
            totalCost -= product.getPrice() * quantity;
            products.remove(product);
        });
        return result;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void print() {
        if (this.isEmpty()) {
            return;
        }
        products.forEach((product, quantity) -> System.out.print((product.toString() + "\n").repeat(quantity)));
        int countSpecialProduct = (int) products.keySet().stream().filter(Product::isSpecial).count();
        System.out.printf("Итого : %d\n", getTotalCost());
        System.out.printf("Специальных товаров : %d\n", countSpecialProduct);
    }

    public boolean isContains(String name) {
        return products.keySet().stream().anyMatch(product -> product.getName().equals(name));
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
