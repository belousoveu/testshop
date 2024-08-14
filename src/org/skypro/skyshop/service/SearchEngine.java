package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.BestResultNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> elements;
    private int resultsSize = 5; // TODO: Оставлено для будущего постраничного вывода результата (нужно будет переименовать поле)
    private int searchAreaSize;

    public SearchEngine() {
        this.searchAreaSize = 0;
        this.elements = new ArrayList<>();
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

    public List<Searchable> search(String query) {
        if (query == null) {
            return new ArrayList<>();
        }
        List<Searchable> results = new ArrayList<>();
        for (Searchable element : this.elements) {
            if (element == null) {
                continue;
            }
            if (element.searchArea().contains(query)) {
                results.add(element);
            }
        }
        return results;
    }

    public Searchable getBestResult(String query) throws BestResultNotFoundException {
        if (query == null || query.isBlank()) {
            throw new NullPointerException("Не задан текст запроса");
        }
        Searchable bestResult = null;
        int bestCount = 0;
        for (Searchable element : this.elements) {
            if (element == null) {
                continue;
            }
            int count = element.getCountTerm(query);
            if (count > bestCount) {
                bestCount = count;
                bestResult = element;
            }
        }
        if (bestResult != null) {
            return bestResult;
        } else {
            throw new BestResultNotFoundException("Не найдены подходящие результаты для запроса: " + query);
        }
    }

}
