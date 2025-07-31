package com.hightower.prep.mapsandsets;

import java.util.*;

public class DifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = toSet(nums1);
        Set<Integer> set2 = toSet(nums2);

        // determine the smaller set to minimize iteration
        Set<Integer> small;
        Set<Integer> large;
        if (set1.size() < set2.size()) {
            small = set1;
            large = set2;
        } else {
            small = set2;
            large = set1;
        }

        // remove common items from both sets
        Iterator<Integer> iterator = small.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (large.contains(i)) {
                large.remove(i);
                iterator.remove();
            }
        }

        // create results
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>(set1));
        results.add(new ArrayList<>(set2));
        return results;
    }

    private Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num: nums) {
            set.add(num);
        }
        return set;
    }
}
