package com.hightower.prep.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsTest {

    private NumberOfIslands classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new NumberOfIslands();
    }

    @Test
    public void testLeetCode1() {
        int[][] grid = new int[][] {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertEquals(1, this.classUnderTest.count(grid));
    }

    @Test
    public void testLeetCode2() {
        int[][] grid = new int[][] {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        assertEquals(3, this.classUnderTest.count(grid));
    }

}
