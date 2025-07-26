package com.hightower.prep.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>BinarySearch implementation to find a target integer within a sorted array of integers.</p>
 *
 * <p>Time Complexity: O(log N)</p>
 */
public class BinarySearchTest {

    private BinarySearch classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new BinarySearch();
    }

    @Test
    public void testFound() {
        int[] numbers = new int[] {-1,0,3,5,9,12};
        Optional<Integer> result = this.classUnderTest.find(9, numbers);
        assertTrue(result.isPresent());
        assertEquals(4, result.get());
    }

    @Test
    public void testNotFound() {
        int[] numbers = new int[] {-1,0,3,5,9,12};
        Optional<Integer> result = this.classUnderTest.find(2, numbers);
        assertFalse(result.isPresent());
    }

}
