package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesTest {

    private RemoveDuplicates classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new RemoveDuplicates();
    }

    @Test
    public void testNoDuplicates() {
        int[] testNumbers = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(testNumbers, this.classUnderTest.apply(testNumbers));
    }

    @Test
    public void testDuplicatesAtStart() {
        int[] testNumbers = new int[] {1, 1, 1, 2, 3, 4, 5};
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, this.classUnderTest.apply(testNumbers));
    }

    @Test
    public void testDuplicatesInMiddle() {
        int[] testNumbers = new int[] {1, 2, 3, 3, 3, 3, 4, 5};
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, this.classUnderTest.apply(testNumbers));
    }

    @Test
    public void testMultpleDuplicates() {
        int[] testNumbers = new int[] {1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5};
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, this.classUnderTest.apply(testNumbers));
    }

    @Test
    public void testDuplicatesAtEnd() {
        int[] testNumbers = new int[] {1, 2, 3, 4, 5, 5, 5, 5, 5};
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, this.classUnderTest.apply(testNumbers));
    }

}
