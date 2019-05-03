package com.codecool.Controller;

import com.codecool.FileAnalysis.StatisticalAnalysis;
import com.codecool.FileHandler.FileContent;
import com.codecool.FileHandler.IterableText;
import com.codecool.Viewer.View;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


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
                showResults(arg, iterableText);
            }
            long endTime = System.currentTimeMillis();
            showBenchmarkTime(startTime, endTime);
        }
    }

    private void showResults(String arg, IterableText iterableText) {
        showFileName(arg);
        showCountCharacters(iterableText);
        showCountWords(iterableText);
        showDictSize(iterableText);
        showMostUsedWords(iterableText);
        showCountLove(iterableText);
        showCountHate(iterableText);
        showCountMusic(iterableText);
        showVowelsInPercents(iterableText);
        showAToERation(iterableText);

    }

    private void showAToERation(IterableText iterableText) {
        double aVowelCount = new StatisticalAnalysis(iterableText.charIterator()).countOf("a");
        double eVowelCount = new StatisticalAnalysis(iterableText.charIterator()).countOf("e");
        String result = String.format("%.2f", aVowelCount / eVowelCount);
        view.displayMessage("'a:e' count ratio: " + result);
    }

    private void showVowelsInPercents(IterableText iterableText) {
        double totalNumberOfChars = new StatisticalAnalysis(iterableText.charIterator()).size();
        Double vowelsInPercent =  (new StatisticalAnalysis(iterableText.charIterator())
                .countOf("a", "e", "i", "o", "u") / totalNumberOfChars) * 100;
        view.displayMessage("vowels %: " +  vowelsInPercent.intValue());
    }

    private void showCountMusic(IterableText iterableText) {
        int musicCount = new StatisticalAnalysis(iterableText.wordIterator()).countOf("music");
        view.displayMessage("'music' count: " + musicCount);
    }

    private void showCountHate(IterableText iterableText) {
        int hateCount = new StatisticalAnalysis(iterableText.wordIterator()).countOf("hate");
        view.displayMessage("'hate' count: " + hateCount);
    }

    private void showCountLove(IterableText iterableText) {
        int loveCount = new StatisticalAnalysis(iterableText.wordIterator()).countOf("love");
        view.displayMessage("'love' count: " + loveCount);
    }

    private void showMostUsedWords(IterableText iterableText) {
        double onePercent = 0.01;
        Double onePercentWords = onePercent * new StatisticalAnalysis(iterableText.wordIterator()).size();
        Set<String> mostUsedWords = new StatisticalAnalysis(
                iterableText.wordIterator()).occurMoreThan(onePercentWords.intValue());
        view.displayMessage("Most used words (<1%): " + mostUsedWords);
    }

    private void showDictSize(IterableText iterableText) {
        int dictSize = new StatisticalAnalysis(iterableText.wordIterator()).dictionarySize();
        view.displayMessage("Dict size: " + dictSize);
    }

    private void showCountWords(IterableText iterableText) {
        int wordListSize = new StatisticalAnalysis(iterableText.wordIterator()).size();
        view.displayMessage("Word count: " + wordListSize);
    }

    private void showCountCharacters(IterableText iterableText) {
        int charListSize = new StatisticalAnalysis(iterableText.charIterator()).size();
        view.displayMessage("Char count: " + charListSize);
    }

    private void showFileName(String arg) {
        view.displayFileName(arg);
    }




}
