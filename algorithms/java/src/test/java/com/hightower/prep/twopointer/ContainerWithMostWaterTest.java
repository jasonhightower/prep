package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest {

    private ContainerWithMostWater classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ContainerWithMostWater();
    }

    @Test
    public void testCase1() {
        assertEquals(49, this.classUnderTest.calculate(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    @Test
    public void testCase2() {
        assertEquals(1, this.classUnderTest.calculate(new int[]{1,1}));
    }


}
