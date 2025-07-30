package com.hightower.prep.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanPlaceFlowersTest {

    private CanPlaceFlowers classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new CanPlaceFlowers();
    }

    @Test
    public void testCanPlaceFlowers() {
        int[] flowerbed = new int[] {1,0,0,0,1};
        int n = 1;
        assertTrue(this.classUnderTest.calculateSimpleGreedy(flowerbed, n));
    }

    @Test
    public void testCannotPlaceFlowers() {
        int[] flowerbed = new int[] {1,0,0,0,1};
        int n = 2;
        assertFalse(this.classUnderTest.calculateSimpleGreedy(flowerbed, n));
    }

    @Test
    public void testCanPlace3Flowers() {
        int[] flowerbed = new int[] {1,0,0,0,0,0,0,0,1};
        int n = 3;
        assertTrue(this.classUnderTest.calculateSimpleGreedy(flowerbed, n));
    }

    @Test
    public void testCannotPlace2Flowers() {
        int[] flowerbed = new int[] {1,0,0,0,0,1};
        int n = 3;
        assertFalse(this.classUnderTest.calculateSimpleGreedy(flowerbed, n));
    }
}
