package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxOperationsTest {

    private MaxOperations classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MaxOperations();
    }

    @Test
    public void testCase1() {
        assertEquals(2, this.classUnderTest.maxOperations(new int[]{1,2,3,4}, 5));
    }

    @Test
    public void testCase2() {
        assertEquals(1, this.classUnderTest.maxOperations(new int[]{3,1,3,4,3}, 6));
    }

}
