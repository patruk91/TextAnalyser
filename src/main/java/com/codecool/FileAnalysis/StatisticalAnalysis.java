package com.codecool.FileAnalysis;

import java.util.*;

public class StatisticalAnalysis {
    private Iterator<String> iterator;
    private Map<String, Integer> elements = new HashMap<>();

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.iterator = iterator;
        createElements();
    }

    private void createElements() {
        while (iterator.hasNext()) {
            String key = iterator.next().toLowerCase();
            elements.put(key, !elements.containsKey(key.toLowerCase()) ? 1 : elements.get(key.toLowerCase()) + 1);
        }
    }

    public int countOf(String... data) {
        int occurrences = 0;
        for (String key : elements.keySet()) {
            if (Arrays.asList(data).contains(key.toLowerCase())) {
                occurrences+= elements.get(key);
            }
        }
        return occurrences;
    }

    public int dictionarySize() {
        return elements.size();
    }

    public int size() {
        int totalNumber = 0;
        for (String key : elements.keySet()) {
            totalNumber += elements.get(key);
        }
        return totalNumber;
    }

    public Set<String> occurMoreThan(int number) {
        Set<String> words = new TreeSet<>();
        for (Map.Entry<String, Integer> element : elements.entrySet()) {
            if (element.getValue() > number) {
                words.add(element.getKey().toLowerCase());
            }
        }
        return words;
    }
}
