package com.hightower.prep.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array return all the triplets (nums[i], nums[j] and nums[k]) such that
 * i != j, 1!= k and j != k and nums[i] + nums[j] + nums[k] = 0
 */
public class ThreeSum {

    public List<int[]> find(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
             int target = -nums[i];
             int j = i + 1;
             int k = nums.length - 1;
             while (j < k) {
                 int sum = nums[j] + nums[k];
                 if (sum == target) {
                    int[] found = new int[]{nums[i], nums[j], nums[k]};
                    results.add(found);
                    do {
                        j++;
                    } while (j < k && nums[j] != found[1]);
                 } else if (sum > target) {
                    k--;
                 } else {
                    j++;
                 }
             }
             while (i < nums.length - 2 && nums[i] == target) {
                 i++;
             }
        }
        return results;
    }
}
