package com.codecool.Controller;

import com.codecool.FileAnalysis.StatisticalAnalysis;
import com.codecool.FileHandler.FileContent;
import com.codecool.FileHandler.IterableText;
import com.codecool.Viewer.View;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private String[] args;
    private View view = new View();

    public Controller(String[] args) {
        this.args = args;
    }

    public void start() {
        long startTime = System.currentTimeMillis();
        if (args.length == 0) {
            view.displayError("No file provided!");
        } else {
            for (String arg : args) {
                IterableText iterableText = new FileContent(arg);
                StatisticalAnalysis character = new StatisticalAnalysis(iterableText.charIterator());
                StatisticalAnalysis word = new StatisticalAnalysis(iterableText.wordIterator());

                showResults(arg, character, word);
            }
            long endTime = System.currentTimeMillis();
            showBenchmarkTime(startTime, endTime);
        }
    }

    private void showResults(String arg, StatisticalAnalysis character, StatisticalAnalysis word) {
        showFileName(arg);
        showCountCharacters(character);
        showCountWords(word);
        showDictSize(word);
        showMostUsedWords(word);
        showCountLove(word);
        showCountHate(word);
        showCountMusic(word);
        showVowelsInPercents(character);
        showAToERation(character);
        showPercentageOfAllLetters(character);
    }

    private void showBenchmarkTime(long startTime, long endTime) {
        view.displayMessage("Benchmark time: " + ((endTime - startTime) / 1000.0) + " secs");
    }

    private void showPercentageOfAllLetters(StatisticalAnalysis character) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<String, String> percentageLetters = new HashMap<>();

        for (char letter : alphabet) {
            percentageLetters
                    .put(letter + "", new DecimalFormat("#0.00")
                    .format((character.countOf(letter + "") / character.size()) * 100));
        }
        view.displayMessage("Letters in %: " + percentageLetters);
    }

    private void showAToERation(StatisticalAnalysis character) {
        double aVowelCount = character.countOf("a");
        double eVowelCount = character.countOf("e");
        String result = String.format("%.2f", aVowelCount / eVowelCount);
        view.displayMessage("'a:e' count ratio: " + result);
    }

    private void showVowelsInPercents(StatisticalAnalysis character) {
        double totalNumberOfChars = character.size();
        Double vowelsInPercent =  (character.countOf("a", "e", "i", "o", "u") / totalNumberOfChars) * 100;
        view.displayMessage("vowels %: " +  vowelsInPercent.intValue());
    }

    private void showCountMusic(StatisticalAnalysis word) {
        view.displayMessage("'music' count: " + word.countOf("music"));
    }

    private void showCountHate(StatisticalAnalysis word) {
        view.displayMessage("'hate' count: " + word.countOf("hate"));
    }

    private void showCountLove(StatisticalAnalysis word) {
        view.displayMessage("'love' count: " + word.countOf("love"));
    }

    private void showMostUsedWords(StatisticalAnalysis word) {
        double onePercent = 0.01;
        Double onePercentWords = onePercent * word.size();
        view.displayMessage("Most used words (<1%): " + word.occurMoreThan(onePercentWords.intValue()));
    }

    private void showDictSize(StatisticalAnalysis word) {
        view.displayMessage("Dict size: " + word.dictionarySize());
    }

    private void showCountWords(StatisticalAnalysis word) {
        view.displayMessage("Word count: " + word.size());
    }

    private void showCountCharacters(StatisticalAnalysis character) {
        view.displayMessage("Char count: " + character.size());
    }

    private void showFileName(String arg) {
        view.displayFileName(arg);
    }




}
