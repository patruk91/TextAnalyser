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
            String element = iterator.next().toLowerCase();
            if (Arrays.asList(elements).contains(element)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public int dictionarySize() {
        Set<String> uniqueElements = new HashSet<>();
        while (iterator.hasNext()) {
            String word = iterator.next().toLowerCase();
            uniqueElements.add(word);
        }
        return uniqueElements.size();
    }

    public int size() {
        int totalNumber = 0;
        while (iterator.hasNext()) {
            totalNumber++;
            iterator.next();
        }
        return totalNumber;
    }

    public Set<String> occurMoreThan(int number) {
        Map<String, Integer> elements = new HashMap<>();
        Set<String> words = new TreeSet<>();

        while (iterator.hasNext()) {
            String key = iterator.next();
            elements.put(key, !elements.containsKey(key) ? 1 : elements.get(key) + 1);
        }

        for (Map.Entry<String, Integer> element : elements.entrySet()) {
            if (element.getValue() > number) {
                words.add(element.getKey().toLowerCase());
            }
        }
        return words;
    }
}
