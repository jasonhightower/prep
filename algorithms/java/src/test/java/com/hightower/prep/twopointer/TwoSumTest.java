package com.hightower.prep;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TwoSumTest {

    @Test
    public void testSorted() {
        int[] numbers = {2,7,11,15};
        int target = 18;
        
        Optional<int[]> resultOpt = TwoSum.find_target_sorted(numbers, target);
        assertAll("result",
            () -> assertTrue(resultOpt.isPresent()),
            () -> assertEquals(resultOpt.get()[0], 1),
            () -> assertEquals(resultOpt.get()[1], 2));
    }

    @Test
    public void testSorted_NoResult() {
        int[] numbers = {2,7,11,15};
        int target = 123;
        
        Optional<int[]> resultOpt = TwoSum.find_target_sorted(numbers, target);
        assertFalse(resultOpt.isPresent());
    }

    @Test
    public void testUnsorted() {
        int[] numbers = {11,7,2,15};
        int target = 17;
        
        Optional<int[]> resultOpt = TwoSum.find_target(numbers, target);
        assertAll("result",
            () -> assertTrue(resultOpt.isPresent()),
            () -> assertEquals(resultOpt.get()[0], 2),
            () -> assertEquals(resultOpt.get()[1], 3));
    }


    @Test
    public void testUnsorted_NoResult() {
        int[] numbers = {11,7,2,15};
        int target = 123;
        
        Optional<int[]> resultOpt = TwoSum.find_target(numbers, target);
        assertFalse(resultOpt.isPresent());
    }

}
