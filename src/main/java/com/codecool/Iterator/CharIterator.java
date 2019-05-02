package com.codecool.Iterator;

import com.codecool.FileHandler.FileReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CharIterator extends FileReader implements Iterator<String>{
    private String fileContent;
    private int index = 0;
    private List<String> charactersList = new ArrayList<>();

    public CharIterator(String fileContent){
        this.fileContent = fileContent;
        addCharsFromFile();
    }

    private void addCharsFromFile(){
        String content = getFileContent(fileContent);
        for (Character character : content.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                charactersList.add(character.toString().toLowerCase());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < charactersList.size();
    }

    @Override
    public String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return charactersList.get(index++);
    }

}
