package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
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

