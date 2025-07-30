package com.hightower.prep.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KidsWithCandiesTest {

    private KidsWithCandies classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new KidsWithCandies();
    }

    @Test
    public void testLC1() {
        int[] candies = new int[] {2,3,5,1,3};
        int extra = 3;
        boolean[] expected = new boolean[] {true, true, true, false, true};
        assertArrayEquals(expected, this.classUnderTest.calculate(candies, extra));
    }

    @Test
    public void testLC2() {
        int[] candies = new int[] {4,2,1,1,2};
        int extra = 1;
        boolean[] expected = new boolean[] {true, false, false, false, false};
        assertArrayEquals(expected, this.classUnderTest.calculate(candies, extra));
    }

    @Test
    public void testLC3() {
        int[] candies = new int[] {12, 1, 12};
        int extra = 10;
        boolean[] expected = new boolean[] {true, false, true};
        assertArrayEquals(expected, this.classUnderTest.calculate(candies, extra));
    }

}
