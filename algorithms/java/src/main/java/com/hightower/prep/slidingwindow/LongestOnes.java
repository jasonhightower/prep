package com.hightower.prep.slidingwindow;

// TODO JH study this one
// key is to count zeroes
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int slow = 0, max = 0, zeroCount = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[slow] == 0) {
                    zeroCount--;
                }
                slow++;
            }
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }

}
