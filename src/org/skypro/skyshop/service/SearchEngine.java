package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.BestResultNotFoundException;

import java.util.*;
import java.util.stream.Collectors;


public class SearchEngine {
    private final Set<Searchable> elements;
    private int resultsSize = 5; // TODO: Оставлено для будущего постраничного вывода результата (нужно будет переименовать поле)
    private int searchAreaSize;

    public SearchEngine() {
        this.searchAreaSize = 0;
        this.elements = new HashSet<>();
    }

    public void add(Searchable element) {
        this.elements.add(element);
        this.searchAreaSize++;
    }

    public int getResultsSize() {
        return resultsSize;
    }

    public int getSearchAreaSize() {
        return searchAreaSize;
    }

    public void setResultsSize(int resultsSize) {
        this.resultsSize = resultsSize;
    }

    public Set<Searchable> search(String query) {
        return this.elements.stream()
                .filter(element -> element != null && element.searchArea().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchComparator())));
    }

    public Searchable getBestResult(String query) throws BestResultNotFoundException {
        if (query == null || query.isBlank()) {
            throw new NullPointerException("Не задан текст запроса");
        }
        return this.elements.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(element -> element.getCountTerm(query)))
                .filter(element -> element.getCountTerm(query) > 0)
                .orElseThrow(() -> new BestResultNotFoundException("Не найдены подходящие результаты для запроса: " + query));
    }


    private static class SearchComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            if (o1.getContentName().length() == o2.getContentName().length()) {
                return o1.getContentName().compareTo(o2.getContentName());
            }
            return o2.getContentName().length() - o1.getContentName().length();
        }
    }
}
