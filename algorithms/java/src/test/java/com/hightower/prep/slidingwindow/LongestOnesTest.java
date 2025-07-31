package com.hightower.prep.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestOnesTest {

    private LongestOnes classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new LongestOnes();
    }

    @Test
    public void testCase1() {
        int[] input = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        assertEquals(6, this.classUnderTest.longestOnes(input, k));
    }

    @Test
    public void testCase2() {
        int[] input = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        assertEquals(10, this.classUnderTest.longestOnes(input, k));
    }

}
