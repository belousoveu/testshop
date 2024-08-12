package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String toString() {
        return String.format("%s : %d\n", super.getName(), price);
    }

    public boolean isSpecial() {
        return false;
    }
}
