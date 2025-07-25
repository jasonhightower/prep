package com.hightower.prep.twopointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Solution using HashMap to store indexes of visited numbers. Does not require
 * array of numbers to be sorted.
 */
public class TwoSumUnordered implements TwoSum {

    @Override
    public Optional<int[]> find(int[] numbers, final Integer target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            final int num = numbers[i];
            final int pair = target - num;
            if (indexes.containsKey(pair)) {
                return Optional.of(new int[]{indexes.get(pair), i});
            }
            indexes.put(num, i);
        }
        return Optional.empty();
    }
}
