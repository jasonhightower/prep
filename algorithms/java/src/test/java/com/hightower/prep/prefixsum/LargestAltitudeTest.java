package com.hightower.prep.prefixsum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestAltitudeTest {

    private LargestAltitude classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new LargestAltitude();
    }

    @Test
    public void testCase1() {
        assertEquals(1, this.classUnderTest.calculate(new int[] {-5, 1, 5,0,-7}));
    }

    @Test
    public void testCase2() {
        assertEquals(0, this.classUnderTest.calculate(new int[] {-4, -3, -2,-1,4,3,2}));
    }

}
