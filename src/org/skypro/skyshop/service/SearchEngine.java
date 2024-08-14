package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.BestResultNotFoundException;

public class SearchEngine {
    private final Searchable[] elements;
    private int resultsSize = 5;
    private int searchAreaSize;

    public SearchEngine(int size) {
        this.searchAreaSize = size;
        this.elements = new Searchable[size];
    }

    public void add(Searchable element) {
        if (this.searchAreaSize > 0) {
            this.elements[this.searchAreaSize - 1] = element;
            this.searchAreaSize--;
        }
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

    public Searchable[] search(String query) {
        if (query == null) {
            return new Searchable[0];
        }
        Searchable[] results = new Searchable[this.resultsSize];
        int i = 0;
        for (Searchable element : this.elements) {
            if (element == null) {
                continue;
            }
            if (element.searchArea().contains(query)) {
                results[i] = element;
                i++;
            }
            if (i == this.resultsSize) {
                break;
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
