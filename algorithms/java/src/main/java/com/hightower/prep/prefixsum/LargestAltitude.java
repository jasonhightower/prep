package com.hightower.prep.prefixsum;

public class LargestAltitude {

    public int calculate(int[] gains) {
        int sum = 0, maxSum = 0;
        for (int i = 0; i < gains.length; i++) {
            sum += gains[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}
