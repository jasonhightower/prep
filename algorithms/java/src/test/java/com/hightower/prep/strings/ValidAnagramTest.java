package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidAnagramTest {

    private ValidAnagram classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ValidAnagram();
    }

    @Test
    public void testAnagram() {
        assertTrue(this.classUnderTest.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void testNonAnagram() {
        assertFalse(this.classUnderTest.isAnagram("rat", "car"));
    }

}
