package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeStringTest {

    private DecodeString classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new DecodeString();
    }

    @Test
    public void testNoEncoding() {
        String input = "aaaaaa";
        String expected = "aaaaaa";
        assertEquals(expected, this.classUnderTest.decode(input));
    }

    @Test
    public void testCase1() {
        String input = "3[a]2[bc]";
        String expected = "aaabcbc";
        assertEquals(expected, this.classUnderTest.decode(input));
    }

    @Test
    public void testCase2() {
        String input = "3[a2[c]]";
        String expected = "accaccacc";
        assertEquals(expected, this.classUnderTest.decode(input));
    }

    @Test
    public void testCase3() {
        String input = "2[abc]3[cd]ef";
        String expected = "abcabccdcdcdef";
        assertEquals(expected, this.classUnderTest.decode(input));
    }

    @Test
    public void testCase4() {
        String input = "100[leetcode]";
        String expected = "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode";
        assertEquals(expected, this.classUnderTest.decode(input));
    }

}
