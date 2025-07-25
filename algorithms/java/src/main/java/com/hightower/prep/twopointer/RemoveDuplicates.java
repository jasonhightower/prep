package com.hightower.prep.twopointer;

import java.util.Arrays;

/**
 * Left pointer maintains the position where non-duplicate values should be written.
 * Right pointer seeks forward to find the next non-duplicate value to write.
 */
public class RemoveDuplicates {

    public int[] apply(int[] numbers) {
        int left = 0;
        for (int right = 1; right < numbers.length; right++) {
            if (numbers[left] != numbers[right]) {
                left++;
                numbers[left] = numbers[right];
            }
        }
        return Arrays.copyOfRange(numbers, 0, left + 1);
    }

}
