package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeSubstringTest {

    private LongestPalindromicSubstring classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new LongestPalindromicSubstring();
    }

    @Test
    public void testLeetCode1() {
        assertEquals("bab", this.classUnderTest.find("babad"));
    }

    @Test
    public void testLeetCode2() {
        assertEquals("bb", this.classUnderTest.find("cbbd"));
    }
}
