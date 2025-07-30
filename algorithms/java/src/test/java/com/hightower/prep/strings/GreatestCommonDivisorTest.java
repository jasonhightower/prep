package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GreatestCommonDivisorTest {

    private GreatestCommonDivisor classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new GreatestCommonDivisor();
    }

    @Test
    public void testDivisible() {
        final String str1 = "ABCABC";
        final String str2 = "ABC";
        assertEquals("ABC", this.classUnderTest.calculate(str1, str2));
    }

    @Test
    public void testDivisible2() {
        final String str1 = "ABABAB";
        final String str2 = "ABAB";
        assertEquals("AB", this.classUnderTest.calculate(str1, str2));
    }

    @Test
    public void testNotDivisible() {
        final String str1 = "LEET";
        final String str2 = "CODE";
        assertNull(this.classUnderTest.calculate(str1, str2));
    }

    @Test
    public void testDivisbleBy1() {
        final String str1 = "AA";
        final String str2 = "A";
        assertEquals("A", this.classUnderTest.calculate(str1, str2));
    }

    @Test
    public void testDivisbleByLarge() {
        final String str1 = "FBFKOXFBFKOXFBFKOXFBFKOXFBFKOX";
        final String str2 = "FBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOXFBFKOX";
        assertEquals("FBFKOX", this.classUnderTest.calculate(str1, str2));
    }

}
