package com.hightower.prep.mapsandsets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public boolean isUnique(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Set<Integer> existingCounts = new HashSet<>();
        for (int value: counts.values()) {
            if (existingCounts.contains(value)) {
                return false;
            }
            existingCounts.add(value);
        }
        return true;
    }

}
