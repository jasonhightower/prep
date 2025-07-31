package com.hightower.prep.slidingwindow;

public class MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        int maxTotal = 0;
        for (int i = 0; i < k; i++) {
            maxTotal += nums[i];
        }
        int head = k;
        int tail = 0;
        int curTotal = maxTotal;
        while (head < nums.length) {
            curTotal = curTotal - nums[tail] + nums[head];
            if (curTotal > maxTotal) {
                maxTotal = curTotal;
            }
            head++;
            tail++;
        }
        return (double)maxTotal/(double)k;
    }

}
