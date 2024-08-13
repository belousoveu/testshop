package org.skypro.skyshop.service;

public interface Searchable {

    String searchArea();

    String getContentType();

    String getContentName();

    default String getContentDescription() {
        return String.format("%s - %s", getContentName(), getContentType());
    };

}
