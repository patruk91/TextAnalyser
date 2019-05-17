package com.codecool.Iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class WordIteratorTest {

    @Test
    void testNextWordIterator() {
        WordIterator wordIterator = new WordIterator("file_that_not_exist^%#&*.txt");
        assertThrows(NoSuchElementException.class, wordIterator::next, "No elements in file");
    }
}