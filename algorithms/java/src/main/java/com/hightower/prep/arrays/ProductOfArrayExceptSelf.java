package com.hightower.prep.arrays;

import java.util.Arrays;

/**
 * <p>Given an integer array nums, return an array answer such that answer[i] is equal
 * to the product of all elements of nums except nums[i].</p>
 *
 * <p>Product is guaranteed to fit in a 32 bit integer.</p>
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ProductOfArrayExceptSelf {

    /**
     * This solution is based on calculating a running product from the left side (prefix) and
     * also from the right side (suffix). The final result is calculated by multiplying the
     * prefix and suffix together for all positions in the array.
     *
     * @param nums
     * @return
     */
    public int[] calculate(int[] nums) {
        int result[] = new int[nums.length];
        Arrays.fill(result, 1);
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >=0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }

}
