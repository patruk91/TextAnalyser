package com.codecool.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    protected String getFileContent(String fileName) {
        String data = "";
        try {
            data = Files.readString(Paths.get("src/main/resources/git sa" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

//        StringBuilder sb = new StringBuilder();
//        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                sb.append(line).append("\n");
//            }
//        }
//        return sb.toString();
    }
}
