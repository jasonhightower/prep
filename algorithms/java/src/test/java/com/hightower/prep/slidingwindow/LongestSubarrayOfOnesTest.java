package com.hightower.prep.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubarrayOfOnesTest {

    private LongestSubarrayOfOnes classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new LongestSubarrayOfOnes();
    }

    @Test
    public void testCaseOne() {
        int[] input = new int[] {1,1,0,1};
        int expected = 3;
        assertEquals(expected, this.classUnderTest.calculate(input));
    }

    @Test
    public void testCaseTwo() {
        int[] input = new int[] {0,1,1,1,0,1,1,0,1};
        int expected = 5;
        assertEquals(expected, this.classUnderTest.calculate(input));
    }

    @Test
    public void testCaseThree() {
        int[] input = new int[] {1,1,1};
        int expected = 2;
        assertEquals(expected, this.classUnderTest.calculate(input));
    }

}
