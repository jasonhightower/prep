package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTest {

    private MoveZeroes classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MoveZeroes();
    }

    @Test
    public void testLeetCode1() {
        int[] input = new int[] {0,1,0,3,12};
        int[] expected = new int[] {1,3,12,0,0};
        assertArrayEquals(expected, this.classUnderTest.move(input));
    }

    @Test
    public void testLeetCode2() {
        int[] input = new int[] {0};
        int[] expected = new int[] {0};
        assertArrayEquals(expected, this.classUnderTest.move(input));
    }
}
