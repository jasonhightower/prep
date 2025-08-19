package com.hightower.prep.algomap.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindClosestToZeroTest {

    private FindClosestToZero classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new FindClosestToZero();
    }

    @Test
    public void testCase1() {
        assertResult(1, new int[] {-4,-2,1,4,8});
    }

    @Test
    public void testCase2() {
        assertResult(1, new int[] {2,-1,1});
    }

    private void assertResult(int expected, int[] nums) {
        int result = this.classUnderTest.findClosestNumber(nums);
        assertEquals(expected, result);
    }

}
