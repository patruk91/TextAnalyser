package com.codecool.FileAnalysis;

import com.codecool.FileHandler.FileContent;
import com.codecool.FileHandler.IterableText;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticalAnalysisTest {

    @BeforeClass
    IterableText setupFile() {
        return new FileContent("test.txt");
    }

    @BeforeClass
    StatisticalAnalysis setupCharacter() {
        IterableText iterableText = setupFile();
        return new StatisticalAnalysis(iterableText.charIterator());
    }

    @BeforeClass
    StatisticalAnalysis setupWord() {
        IterableText iterableText = setupFile();
        return new StatisticalAnalysis(iterableText.wordIterator());
    }

    @Test
    void testCountOfLove() {
        StatisticalAnalysis word = setupWord();
        assertEquals(1, word.countOf("love"), "Number of occurrences of the word: 'love': ");
    }

    @Test
    void testCountOfHate() {
        StatisticalAnalysis word = setupWord();
        assertEquals(0, word.countOf("hate"), "Number of occurrences of the word: 'hate': ");
    }

    @Test
    void testCountOfMusic() {
        StatisticalAnalysis word = setupWord();
        assertEquals(3, word.countOf("music"), "Number of occurrences of the word: 'music': ");
    }

    @Test
    void testIORatio() {
        StatisticalAnalysis character = setupCharacter();
        assertEquals(0.92, Math.round(
                (1.0 * character.countOf("i") / character.countOf("o")) * 100.0) / 100.0,
                "Ratio of occurrences of vowel: 'i' to 'o':");
    }

    @Test
    void dictionarySize() {
    }

    @Test
    void size() {
    }

    @Test
    void occurMoreThan() {
    }
}