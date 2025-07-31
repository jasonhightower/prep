package com.hightower.prep.mapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EqualRowAndColumnPairsTest {

    private EqualRowAndColumnPairs classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new EqualRowAndColumnPairs();
    }

    @Test
    public void testCase1() {
        int[][] grid = new int[][] {
                {3,2,1},
                {1,7,6},
                {2,7,7}
        };
        assertEquals(1, this.classUnderTest.count(grid));
    }


    @Test
    public void testCase2() {
        int[][] grid = new int[][] {
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
        };
        assertEquals(3, this.classUnderTest.count(grid));
    }

    @Test
    public void testCase3() {
        int[][] grid = new int[][] {
                {2,1},
                {3,32}
        };
        assertEquals(0, this.classUnderTest.count(grid));
    }

}
