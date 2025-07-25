package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumTest {

    private ThreeSum classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ThreeSum();
    }

    @Test
    public void leetCodeTest1() {
        int[] nums = new int[] {-1, 0, 1, 2, -1, 4};
        final List<int[]> result = this.classUnderTest.find(nums);
        final List<int[]> expected = Arrays.asList(new int[][] {
                {-1,-1,2},
                {-1,0,1}
        });
        assertEqual(expected, result);
    }

    @Test
    public void leetCodeTest2() {
        int[] nums = new int[] {0, 1, 1};
        final List<int[]> result = this.classUnderTest.find(nums);
        final List<int[]> expected = Collections.emptyList();
        assertEqual(expected, result);
    }

    @Test
    public void leetCodeTest3() {
        int[] nums = new int[] {0, 0, 0};
        final List<int[]> result = this.classUnderTest.find(nums);
        final List<int[]> expected = Arrays.asList(new int[][] {
                {0,0,0}
        });
        assertEqual(expected, result);
    }

    private void assertEqual(List<int[]> expected, List<int[]> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }
    }
}
