package com.hightower.prep.slidingwindow;

// TODO JH revisit, rather than using the longest ones technique
// we can maintain counts of previous groups of ones and current groups of ones
// then add them both together when we encounter a zero
public class LongestSubarrayOfOnes {

    public int calculate(int[] nums) {
        int prevCount=0, curCount=0, left=0, max=0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                max = Math.max(max, prevCount+curCount);
                prevCount = curCount;
                curCount=0;
            } else {
                curCount++;
            }
        }
        return curCount == nums.length ? curCount - 1 : Math.max(max, prevCount+curCount);
    }

}
