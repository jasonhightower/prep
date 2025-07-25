package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringTest {

    private LongestSubstring classUnderTest;

    @BeforeEach
    public void setUp() {
       this.classUnderTest = new LongestSubstring();
    }

    @Test
    public void testLongestAtStart() {
        String testString = "qwertyuwasdfret";
        int result = this.classUnderTest.find(testString);
        assertEquals(result, 7);
    }

    @Test
    public void testLongestInMiddle() {
        String testString = "abcrewqrtyuiop";
        int result = this.classUnderTest.find(testString);
        assertEquals(result, 10);
    }

    @Test
    public void testLongestAtEnd() {
        String testString = "aaaaabcrewqaaaa";
        int result = this.classUnderTest.find(testString);
        assertEquals(result, 7);
    }

    @Test
    public void testNonRepeatingString() {
        String testString = "asdfghjkl";
        int result = this.classUnderTest.find(testString);
        assertEquals(result, testString.length());
    }

    @Test
    public void testCompletelyRepeatingString() {
        String testString = "aaaaaaaaaaa";
        int result = this.classUnderTest.find(testString);
        assertEquals(result, 1);
    }

}
