package com.hightower.prep.prefixsum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPivotIndexTest {

    private FindPivotIndex classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new FindPivotIndex();
    }

    @Test
    public void testCase1() {
        int[] input = new int[] {1,7,3,6,5,6};
        int expected = 3;
        assertEquals(expected, this.classUnderTest.find(input));
    }

    @Test
    public void testCase2() {
        int[] input = new int[] {1,2,3};
        int expected = -1;
        assertEquals(expected, this.classUnderTest.find(input));
    }

    @Test
    public void testCase3() {
        int[] input = new int[] {2,1,-1};
        int expected = 0;
        assertEquals(expected, this.classUnderTest.find(input));
    }
}
