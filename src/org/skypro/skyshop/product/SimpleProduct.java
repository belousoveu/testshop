package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price)  {
        super(name);
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Стоимость продукта должна быть больше 0");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String toString() {
        return String.format("%s : %d", super.getName(), price);
    }

    public boolean isSpecial() {
        return false;
    }
}
