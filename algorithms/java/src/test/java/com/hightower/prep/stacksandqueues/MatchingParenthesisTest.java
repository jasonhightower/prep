package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatchingParenthesisTest {

    private MatchingParenthesis classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MatchingParenthesis();
    }

    @Test
    public void testLeetCode1() {
        assertTrue(this.classUnderTest.isValid("()"));
    }

    @Test
    public void testLeetCode2() {
        assertTrue(this.classUnderTest.isValid("()[]{}"));
    }

    @Test
    public void testLeetCode3() {
        assertTrue(this.classUnderTest.isValid("([])"));
    }

    @Test
    public void testLeetCode4() {
        assertFalse(this.classUnderTest.isValid("([)]"));
    }

    @Test
    public void testLeetCode5() {
        assertFalse(this.classUnderTest.isValid(")[]"));
    }

}
