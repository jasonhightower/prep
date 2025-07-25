package com.hightower.prep.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {

    private ProductOfArrayExceptSelf classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ProductOfArrayExceptSelf();
    }

    @Test
    public void testLeetCode1() {
        int[] input = new int[] {1,2,3,4};
        int[] expected = new int[] {24,12,8,6};
        assertArrayEquals(expected, this.classUnderTest.calculate(input));
    }

    @Test
    public void testLeetCode2() {
        int[] input = new int[] {-1,1,0,-3,3};
        int[] expected = new int[] {0,0,9,0,0};
        assertArrayEquals(expected, this.classUnderTest.calculate(input));
    }
}
