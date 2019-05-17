package com.codecool.Iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class WordIteratorTest {

    @Test
    void testNextWordIterator() {
        CharIterator charIterator = new CharIterator("file_that_not_exist.txt");
        assertThrows(NoSuchElementException.class, charIterator::next);
    }
}