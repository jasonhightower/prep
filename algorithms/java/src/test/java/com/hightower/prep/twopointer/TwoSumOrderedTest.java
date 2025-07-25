package com.hightower.prep.twopointer;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumOrderedTest {

    @Test
    public void testTargetFound() {
        int[] numbers = {2,7,11,15};
        int target = 18;

        TwoSum twoSum = new TwoSumOrdered();
        Optional<int[]> result = twoSum.find(numbers, target);
        assertAll("result",
            () -> assertTrue(result.isPresent()),
            () -> assertEquals(result.get()[0], 1),
            () -> assertEquals(result.get()[1], 2));
    }

    @Test
    public void testTargetNotFound() {
        int[] numbers = {2,7,11,15};
        int target = 123;

        TwoSum twoSum = new TwoSumOrdered();
        Optional<int[]> resultOpt = twoSum.find(numbers, target);
        assertFalse(resultOpt.isPresent());
    }
}
