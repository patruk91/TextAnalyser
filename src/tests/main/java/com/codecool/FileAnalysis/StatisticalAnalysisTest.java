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
    void testVowelsInPercent() {
        StatisticalAnalysis character = setupCharacter();
        assertEquals(38.99, (Math.round(
                (100.0 * character.countOf("a", "e", "i", "o", "u") / character.size()) * 100.0) / 100.0),
                "Percentage of occurrences of vowels: ");
    }

    @Test
    void testPercentageOfOccurrencesOneLetter() {
        StatisticalAnalysis character = setupCharacter();
        assertEquals(7.95, (Math.round(
                (100.0 * character.countOf("a") / character.size()) * 100.0) / 100.0),
                "Percentage of occurrences of a letter: ");
    }

    @Test
    void testPercentageOfOccurrencesFewLetters() {
        StatisticalAnalysis character = setupCharacter();
        assertEquals(22.99, (Math.round(
                (100.0 * character.countOf("c", "d", "e", "f") / character.size()) * 100.0) / 100.0),
                "Percentage of occurrences of 'c,d,e,f' letters: ");
    }

    @Test
    void testUniqueElements() {
        StatisticalAnalysis word = setupWord();
        assertEquals(141, word.dictionarySize(),
                "Unique elements of data (different words in text");
    }

    @Test
    void testCountTotalWords() {
        StatisticalAnalysis word = setupWord();
        assertEquals(268, word.size(), "Number of total words: ");
    }

    @Test
    void testCountTotalCharacters() {
        StatisticalAnalysis character = setupCharacter();
        assertEquals(1031, character.size(), "Number of total characters: ");
    }

    @Test
    void testMostUsedWords() {
        StatisticalAnalysis word = setupWord();
        Double onePercentWords = 0.01 * word.size();
        String[] arr = {"a", "and", "as", "been", "but", "figure", "had", "i", "in",
                "is", "it", "me", "music", "no", "not", "of", "old", "the", "to", "was", "where"};
        assertArrayEquals(arr, word.occurMoreThan(onePercentWords.intValue()).toArray());
    }
}