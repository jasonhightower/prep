package com.hightower.prep.algomap.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeStringsAlternatelyTest {

    private MergeStringsAlternately classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new MergeStringsAlternately();
    }

    @Test
    public void testCase1() {
        assertResult("apbqcr", "abc", "pqr");
    }

    @Test
    public void testCase2() {
        assertResult("apbqrs", "ab", "pqrs");
    }

    @Test
    public void testCase3() {
        assertResult("apbqcd", "abcd", "pq");
    }

    @Test
    public void testFirstNull() {
        assertResult("pqrs", null, "pqrs");
    }

    @Test
    public void testSecondNull() {
        assertResult("abcd", "abcd", null);
    }

    @Test
    public void testBothNull() {
        assertResult(null, null, null);
    }

    private void assertResult(final String expected, final String input1, final String input2) {
        final String result = this.classUnderTest.merge(input1, input2);
        assertEquals(expected, result);
    }

}
