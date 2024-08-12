package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    public int getPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return String.format("%s : %d (%d%%%%)\n", super.getName(), this.getPrice(), discount);
    }
}

