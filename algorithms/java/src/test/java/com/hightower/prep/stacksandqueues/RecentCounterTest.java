package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentCounterTest {

    private RecentCounter classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new RecentCounter();
    }

    @Test
    public void testCase1() {
        assertEquals(1, this.classUnderTest.ping(1));
        assertEquals(2, this.classUnderTest.ping(100));
        assertEquals(3, this.classUnderTest.ping(3001));
        assertEquals(3, this.classUnderTest.ping(3002));
    }
}
