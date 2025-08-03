package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveStarsFromStringTest {

    private RemoveStarsFromString classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new RemoveStarsFromString();
    }

    @Test
    public void testCase1() {
        assertEquals("lecoe", this.classUnderTest.remove("leet**cod*e"));
    }

    @Test
    public void testCase2() {
        assertEquals("", this.classUnderTest.remove("erase*****"));
    }

}
