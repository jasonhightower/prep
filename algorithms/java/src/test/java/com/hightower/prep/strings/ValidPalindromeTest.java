package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindromeTest {

    private ValidPalindrome classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ValidPalindrome();
    }

    @Test
    public void testLeetCode1() {
        assertTrue(this.classUnderTest.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testLeetCode2() {
        assertFalse(this.classUnderTest.isPalindrome("race a car"));
    }

    @Test
    public void testLeetCode3() {
        assertTrue(this.classUnderTest.isPalindrome(" "));
    }

}
