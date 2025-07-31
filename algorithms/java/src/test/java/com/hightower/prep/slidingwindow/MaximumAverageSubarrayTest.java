package com.hightower.prep.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumAverageSubarrayTest {

    private MaximumAverageSubarray classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MaximumAverageSubarray();
    }

    @Test
    public void testCase1() {
        assertEquals(12.75, this.classUnderTest.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }

    @Test
    public void testCase2() {
        assertEquals(5, this.classUnderTest.findMaxAverage(new int[]{5},1));
    }
}
