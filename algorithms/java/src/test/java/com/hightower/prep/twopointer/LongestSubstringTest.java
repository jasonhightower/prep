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
        String testString = "qwertyuwrasrdfretr";
        int result = this.classUnderTest.find(testString);
        assertEquals(7, result);
    }

    @Test
    public void testLongestInMiddle() {
        String testString = "abcrewqrtyuiop";
        int result = this.classUnderTest.find(testString);
        assertEquals(10, result);
    }

    @Test
    public void testLongestAtEnd() {
        String testString = "aaaaabcrewqaaaa";
        int result = this.classUnderTest.find(testString);
        assertEquals(7, result);
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
        assertEquals(1,result);
    }

    @Test
    public void testLeetCode1() {
        assertEquals(3, this.classUnderTest.find("abcabcbb"));
    }

    @Test
    public void testLeetCode2() {
        assertEquals(1, this.classUnderTest.find("bbbbbbbbb"));
    }

    @Test
    public void testLeetCode3() {
        assertEquals(3, this.classUnderTest.find("pwwkew"));
    }

}
