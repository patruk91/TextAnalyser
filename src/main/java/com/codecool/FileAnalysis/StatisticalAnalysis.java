package com.codecool.FileAnalysis;

import java.util.*;

public class StatisticalAnalysis {
    private Iterator<String> iterator;

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.iterator = iterator;
    }

    public int countOf(String... elements) {
        int occurrences = 0;
        while (iterator.hasNext()) {
            if (Arrays.asList(elements).contains(iterator.next())) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public int dictionarySize() {
        Set<String> uniqueElements = new HashSet<>();
        while (iterator.hasNext()) {
            uniqueElements.add(iterator.next());
        }
        return uniqueElements.size();
    }



}
