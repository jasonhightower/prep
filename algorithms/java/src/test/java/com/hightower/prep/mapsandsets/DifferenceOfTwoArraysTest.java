package com.hightower.prep.mapsandsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferenceOfTwoArraysTest {

    private DifferenceOfTwoArrays classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new DifferenceOfTwoArrays();
    }

    @Test
    public void testCase1() {
        int[] input1 = new int[]{1,2,3};
        int[] input2 = new int[]{2,4,6};
        List<List<Integer>> results = this.classUnderTest.findDifference(input1, input2);
        int[] expected1 = new int[] {1,3};
        int[] expected2 = new int[] {4,6};
        assertEquals(2, results.size());
        assertArrayEquals(expected1, results.get(0).stream().mapToInt(Integer::intValue).toArray());
        assertArrayEquals(expected2, results.get(1).stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void testCase2() {
        int[] input1 = new int[]{1,2,3,3};
        int[] input2 = new int[]{1,1,2,2};
        List<List<Integer>> results = this.classUnderTest.findDifference(input1, input2);
        int[] expected1 = new int[] {3};
        int[] expected2 = new int[] {};
        assertEquals(2, results.size());
        assertArrayEquals(expected1, results.get(0).stream().mapToInt(Integer::intValue).toArray());
        assertArrayEquals(expected2, results.get(1).stream().mapToInt(Integer::intValue).toArray());
    }

}
