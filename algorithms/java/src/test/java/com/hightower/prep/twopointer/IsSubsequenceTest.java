package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsSubsequenceTest {

    private IsSubsequence classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new IsSubsequence();
    }

    @Test
    public void testCase1() {
        assertTrue(this.classUnderTest.check("abc", "ahbgdc"));
    }

    @Test
    public void testCase2() {
        assertFalse(this.classUnderTest.check("axc", "ahbgdc"));
    }

}
