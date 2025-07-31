package com.hightower.prep.mapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloseStringsTest {

    private CloseStrings classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new CloseStrings();
    }

    @Test
    public void testCase1() {
        assertTrue(this.classUnderTest.isClose("abc", "bca"));
    }

    @Test
    public void testCase2() {
        assertFalse(this.classUnderTest.isClose("a", "aa"));
    }

    @Test
    public void testCase3() {
        assertTrue(this.classUnderTest.isClose("cabbba", "abbccc"));
    }

}
