package com.hightower.prep;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

/**
 * Given an array of integers and an integer target, return indices of the 
 * two numbers such that they add up to target.
 */
public class TwoSum {

    /**
     * Solution using two pointers which requires the numbers to be sorted.
     */
    public static Optional<int[]> find_target_sorted(final int[] numbers, final int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            final int result = numbers[l] + numbers[r] - target;
            if (result == 0) {
                return Optional.of(new int[] {l, r});
            } else if (result > 0) {
                r--;
            } else {
                l++;
            }
        }
        return Optional.empty();
    }

    /**
     * Solution using HashMap to store indexes of visited numbers. Does not require
     * array of numbers to be sorted.
     */
    public static Optional<int[]> find_target(final int[] numbers, final int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            final int num = numbers[i];
            final int pair = target - num;
            if (indexes.containsKey(pair)) {
                return Optional.of(new int[] {i, indexes.get(pair)});
            }
            indexes.put(num, i);
        }
        return Optional.empty();
    }

    private TwoSum() {}

}
