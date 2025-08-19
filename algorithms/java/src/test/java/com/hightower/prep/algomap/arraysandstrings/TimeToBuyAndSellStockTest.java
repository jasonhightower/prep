package com.hightower.prep.algomap.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeToBuyAndSellStockTest {

    private TimeToBuyAndSellStock classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new TimeToBuyAndSellStock();
    }

    @Test
    public void testCase1() {
        assertEquals(5, this.classUnderTest.maxProfit(new int[] {7,1,5,3,6,4}));
    }

    @Test
    public void testCase2() {
        assertEquals(0, this.classUnderTest.maxProfit(new int[] {7,6,4,3,1}));
    }

}
