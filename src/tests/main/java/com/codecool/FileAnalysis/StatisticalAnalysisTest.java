package com.codecool.FileAnalysis;

import com.codecool.FileHandler.FileContent;
import com.codecool.FileHandler.IterableText;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticalAnalysisTest {
    private IterableText iterableText = setupFile();
    private StatisticalAnalysis character = setupCharacter();
    private StatisticalAnalysis word = setupWord();


    @BeforeClass
    IterableText setupFile() {
        return new FileContent("test.txt");
    }

    @BeforeClass
    StatisticalAnalysis setupCharacter() {
        return new StatisticalAnalysis(iterableText.charIterator());
    }

    @BeforeClass
    StatisticalAnalysis setupWord() {
        return new StatisticalAnalysis(iterableText.wordIterator());
    }

    @Test
    void testCountOfLove() {
        assertEquals(1, word.countOf("love"), "Number of occurrences of the word: 'love': ");
    }

    @Test
    void testCountOfHate() {
        assertEquals(0, word.countOf("hate"), "Number of occurrences of the word: 'hate': ");
    }

    @Test
    void testCountOfMusic() {
        assertEquals(3, word.countOf("music"), "Number of occurrences of the word: 'music': ");
    }

    @Test
    void testIORatio() {
        assertEquals(0.92, Math.round(
                (1.0 * character.countOf("i") / character.countOf("o")) * 100.0) / 100.0,
                "Ratio of occurrences of vowel: 'i' to 'o':");
    }

    @Test
    void testVowelsInPercent() {
        assertEquals(38.99, (Math.round(
                (100.0 * character.countOf("a", "e", "i", "o", "u") / character.size()) * 100.0) / 100.0),
                "Percentage of occurrences of vowels: ");
    }

    @Test
    void testPercentageOfOccurrencesOneLetter() {
        assertEquals(7.95, (Math.round(
                (100.0 * character.countOf("a") / character.size()) * 100.0) / 100.0),
                "Percentage of occurrences of a letter: ");
    }

    @Test
    void testPercentageOfOccurrencesFewLetters() {
        assertEquals(22.99, (Math.round(
                (100.0 * character.countOf("c", "d", "e", "f") / character.size()) * 100.0) / 100.0),
                "Percentage of occurrences of 'c,d,e,f' letters: ");
    }

    @Test
    void testUniqueElements() {
        assertEquals(141, word.dictionarySize(),
                "Unique elements of data (different words in text");
    }

    @Test
    void testCountTotalWords() {
        assertEquals(268, word.size(), "Number of total words: ");
    }

    @Test
    void testCountTotalCharacters() {
        assertEquals(1031, character.size(), "Number of total characters: ");
    }

    @Test
    void testMostUsedWords() {
        Double onePercentWords = 0.01 * word.size();
        String[] arr = {"a", "and", "as", "been", "but", "figure", "had", "i", "in",
                "is", "it", "me", "music", "no", "not", "of", "old", "the", "to", "was", "where"};
        assertArrayEquals(arr, word.occurMoreThan(onePercentWords.intValue()).toArray());
    }
}