package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final static int FIX_PRICE = 25;

    public FixPriceProduct(String name) {
        super(name);
    }

    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return String.format("%s : Фиксированная цена %d", super.getName(), FIX_PRICE);
    }
}
