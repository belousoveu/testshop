package org.skypro.skyshop.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Searchable {

    String searchArea();

    String getContentType();

    String getContentName();

    default String getContentDescription() {
        return String.format("%s - %s", getContentName(), getContentType());
    }

    default int getCountTerm(String query) {
        Pattern pattern = Pattern.compile(query);
        Matcher matcher = pattern.matcher(this.searchArea());
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
