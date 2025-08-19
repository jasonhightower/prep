package com.hightower.prep.algomap.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new LongestCommonPrefix();
    }

    @Test
    public void testCase1() {
        assertEquals("fl", classUnderTest.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }

    @Test
    public void testCase2() {
        assertEquals("", classUnderTest.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
    }
}
