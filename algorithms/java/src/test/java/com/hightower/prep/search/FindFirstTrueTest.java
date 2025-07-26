package com.hightower.prep.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class FindFirstTrueTest {

    private FindFirstTrue classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new FindFirstTrue();
    }

    @Test
    public void testBoundaryExists() {
        boolean[] values = new boolean[]{false, false, true, true, true};
        Optional<Integer> result = this.classUnderTest.find(values);
        assertTrue(result.isPresent());
        assertEquals(2, result.get());
    }

    @Test
    public void testLargerDataset() {
        boolean[] values = new boolean[] {false, false, false, false, false, false, false, false, false, false, true, true, true};
        Optional<Integer> result = this.classUnderTest.find(values);
        assertTrue(result.isPresent());
        assertEquals(10, result.get());
    }

    @Test
    public void testAllFalse() {
        boolean[] values = new boolean[] {false, false, false, false, false};
        Optional<Integer> result = this.classUnderTest.find(values);
        assertFalse(result.isPresent());
    }

}
