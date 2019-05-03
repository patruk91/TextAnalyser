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
