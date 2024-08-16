package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Стоимость продукта должна быть больше 0");
        }
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100");
        }
    }

    public int getPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return String.format("%s : %d (%d%%%%)", super.getName(), this.getPrice(), discount);
    }
}

