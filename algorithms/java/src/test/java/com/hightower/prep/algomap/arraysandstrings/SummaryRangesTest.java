package com.hightower.prep.algomap.arraysandstrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryRangesTest {

    private SummaryRanges classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new SummaryRanges();
    }

    @Test
    public void testCase1() {
        assertEquals(
                List.of("0->2", "4->5", "7"),
                this.classUnderTest.summarize(new int[] {0,1,2,4,5,7})
        );
    }

    @Test
    public void testCase2() {
        assertEquals(
                List.of("0", "2->4", "6", "8->9"),
                this.classUnderTest.summarize(new int[] {0,2,3,4,6,8,9})
        );
    }
}
