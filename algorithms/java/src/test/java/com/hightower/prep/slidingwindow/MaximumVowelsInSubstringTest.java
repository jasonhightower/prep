package com.hightower.prep.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumVowelsInSubstringTest {

    private MaximumVowelsInSubstring classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MaximumVowelsInSubstring();
    }

    @Test
    public void testCase1() {
        final String input = "abciiidef";
        final int length = 3;
        assertEquals(3, this.classUnderTest.findMax(input, length));
    }

    @Test
    public void testCase2() {
        final String input = "aeiou";
        final int length = 2;
        assertEquals(2, this.classUnderTest.findMax(input, length));
    }

    @Test
    public void testCase3() {
        final String input = "leetcode";
        final int length = 3;
        assertEquals(2, this.classUnderTest.findMax(input, length));
    }

}
