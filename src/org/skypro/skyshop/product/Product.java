package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Наименование продукта не может быть null или пустой строкой");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String searchArea() {
        return name;
    }

    public String getContentType() {
        return "PRODUCT";
    }

    public String getContentName() {
        return name;
    }

}

