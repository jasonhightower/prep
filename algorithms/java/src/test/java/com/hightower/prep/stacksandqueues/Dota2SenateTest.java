package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dota2SenateTest {

    private Dota2Senate classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new Dota2Senate();
    }

    @Test
    public void testCase1() {
        String input = "RD";
        String expected = "Radiant";
        assertEquals(expected, this.classUnderTest.predictPartyVictory(input));
    }

    @Test
    public void testCase2() {
        String input = "RDD";
        String expected = "Dire";
        assertEquals(expected, this.classUnderTest.predictPartyVictory(input));
    }
}
