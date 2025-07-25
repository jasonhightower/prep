package com.hightower.prep.twopointer;

import java.util.Optional;

/**
 * Solution using two pointers which requires the numbers to be sorted.
 */
public class TwoSumOrdered implements TwoSum {

    @Override
    public Optional<int[]> find(int[] numbers, Integer target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            final int result = numbers[l] + numbers[r] - target;
            if (result == 0) {
                return Optional.of(new int[]{l, r});
            } else if (result > 0) {
                r--;
            } else {
                l++;
            }
        }
        return Optional.empty();
    }
}
