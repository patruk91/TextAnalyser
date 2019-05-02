package com.codecool.Controller;

import com.codecool.FileAnalysis.StatisticalAnalysis;
import com.codecool.FileHandler.FileContent;
import com.codecool.FileHandler.IterableText;
import com.codecool.Viewer.View;

public class Controller {
    private String[] args;
    private View view = new View();

    public Controller(String[] args) {
        this.args = args;
    }

    public void start() {
        if (args.length == 0) {
            view.displayError("No file provided!");
        } else {
            for (String arg : args) {
                IterableText iterableText = new FileContent(arg);
                showResults(arg, iterableText);
            }
        }
    }

    private void showResults(String arg, IterableText iterableText) {
        view.displayFileName(arg);
    }


}
