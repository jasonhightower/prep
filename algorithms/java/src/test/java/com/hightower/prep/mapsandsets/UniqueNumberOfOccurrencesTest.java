package com.hightower.prep.mapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueNumberOfOccurrencesTest {

    private UniqueNumberOfOccurrences classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new UniqueNumberOfOccurrences();
    }

    @Test
    public void testCase1() {
        assertTrue(this.classUnderTest.isUnique(new int[] {1,2,2,1,1,3}));
    }

    @Test
    public void testCase2() {
        assertFalse(this.classUnderTest.isUnique(new int[] {1, 2}));
    }

    @Test
    public void testCase3() {
        assertTrue(this.classUnderTest.isUnique(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));
    }

}
