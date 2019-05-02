package com.codecool.Iterator;

import com.codecool.FileHandler.FileReader;

import java.util.*;

public class WordIterator extends FileReader implements Iterator<String> {
    private String fileContent;
    private int index = 0;
    private List<String> wordList = new ArrayList<>();

    public WordIterator(String fileContent){
        this.fileContent = fileContent;
        addWordsFromFile();
    }

    private void addWordsFromFile() {
        String content = getFileContent(fileContent);
        wordList = Arrays.asList(content.trim().split("\\s+"));
    }

    @Override
    public boolean hasNext() {
        return index < wordList.size();
    }

    @Override
    public String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return wordList.get(index++);    }
}
