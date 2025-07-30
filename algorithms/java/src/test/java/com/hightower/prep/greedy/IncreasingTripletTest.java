package com.hightower.prep.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncreasingTripletTest {

    private IncreasingTriplet classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new IncreasingTriplet();
    }

    @Test
    public void testLC3() {
        assertTrue(this.classUnderTest.find(new int[] {20, 100, 10, 12, 5, 13}));
    }

}
