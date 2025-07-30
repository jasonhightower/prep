package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpandOptionalRegexRecursiveTest {

    private ExpandOptionalRegexRecursive classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ExpandOptionalRegexRecursive();
    }

    @Test
    public void testNoOptionalCharacters() {
        final String input = "ABCD";

        final List<String> results = this.classUnderTest.expand(input);
        assertEquals(1, results.size());
        assertEquals("ABCD", results.get(0));
    }

    @Test
    public void testOptionalCharacters() {
        final String input = "A?BC?D";

        final List<String> results = this.classUnderTest.expand(input);
        assertEquals(4, results.size());
        assertTrue(results.contains("ABCD"));
        assertTrue(results.contains("BCD"));
        assertTrue(results.contains("BD"));
        assertTrue(results.contains("ABD"));
    }

}
