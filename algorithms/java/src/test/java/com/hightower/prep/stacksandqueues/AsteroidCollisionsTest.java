package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AsteroidCollisionsTest {

    private AsteroidCollisions classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new AsteroidCollisions();
    }

    @Test
    public void testCase1() {
        int[] input = {5,10,-5};
        int[] expected = {5,10};
        assertArrayEquals(expected, this.classUnderTest.simulate(input));
    }

    @Test
    public void testCase2() {
        int[] input = {8, -8};
        int[] expected = {};
        assertArrayEquals(expected, this.classUnderTest.simulate(input));
    }

    @Test
    public void testCase3() {
        int[] input = {10,2,-5};
        int[] expected = {10};
        assertArrayEquals(expected, this.classUnderTest.simulate(input));
    }

    @Test
    public void testCase4() {
        int[] input = {-2,1,-2,-2};
        int[] expected = {-2,-2,-2};
        assertArrayEquals(expected, this.classUnderTest.simulate(input));
    }

    @Test
    public void testCase5() {
        int[] input = {-2,1,-2,-5};
        int[] expected = {-2,-2,-5};
        assertArrayEquals(expected, this.classUnderTest.simulate(input));
    }

    @Test
    public void testCase6() {
        int[] input = {-5,1,-2,-2};
        int[] expected = {-5,-2,-2};
        assertArrayEquals(expected, this.classUnderTest.simulate(input));
    }


}
