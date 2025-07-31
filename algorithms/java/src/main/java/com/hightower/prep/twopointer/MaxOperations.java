package com.hightower.prep.twopointer;

import java.util.Arrays;

public class MaxOperations {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int result = nums[left] + nums[right];
            if (result == k) {
                count++;
                left++;
                right--;
            } else if (result < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

}
