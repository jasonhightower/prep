package com.hightower.prep.algomap.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToIntegerTest {

    private RomanToInteger classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new RomanToInteger();
    }

    @Test
    public void testCase1() {
        assertEquals(3, this.classUnderTest.convert("III"));
    }

    @Test
    public void testCase2() {
        assertEquals(58, this.classUnderTest.convert("LVIII"));
    }

    @Test
    public void testCase3() {
        assertEquals(1994, this.classUnderTest.convert("MCMXCIV"));
    }

    @Test
    public void testCase4() {
        assertEquals(3999, this.classUnderTest.convert("MMMCMXCIX"));
    }

    @Test
    public void testCase5() {
        assertEquals(3888, this.classUnderTest.convert("MMMDCCCLXXXVIII"));
    }
}
