package com.codecool.FileHandler;

import com.codecool.Iterator.CharIterator;
import com.codecool.Iterator.WordIterator;

import java.util.Iterator;

public class FileContent implements IterableText {

    private String fileName;

    public FileContent(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Iterator<String> charIterator() {
        return new CharIterator(fileName);
    }

    @Override
    public Iterator<String> wordIterator() {
        return new WordIterator(fileName);
    }

}
