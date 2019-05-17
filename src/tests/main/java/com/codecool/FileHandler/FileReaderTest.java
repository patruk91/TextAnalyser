package com.codecool.FileHandler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void testGetFileContent() {
        FileReader fileReader = new FileReader();
        String data = fileReader.getFileContent("test.txt");
        assertTrue(data.length() > 0, "Empty file content or file not exists");
    }
}