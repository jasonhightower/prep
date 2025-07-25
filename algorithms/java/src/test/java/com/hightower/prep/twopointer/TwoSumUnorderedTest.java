package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumUnorderedTest {

    private TwoSum twoSum;

    @BeforeEach
    public void setUp() {
       this.twoSum = new TwoSumUnordered();
    }

    @Test
    public void testUnsorted() {
        int[] numbers = {11,7,2,15};
        int target = 17;
        
        Optional<int[]> resultOpt = this.twoSum.find(numbers, target);
        assertAll("result",
            () -> assertTrue(resultOpt.isPresent()),
            () -> assertEquals(resultOpt.get()[0], 2),
            () -> assertEquals(resultOpt.get()[1], 3));
    }


    @Test
    public void testUnsorted_NoResult() {
        int[] numbers = {11,7,2,15};
        int target = 123;
        
        Optional<int[]> resultOpt = this.twoSum.find(numbers, target);
        assertFalse(resultOpt.isPresent());
    }

}
