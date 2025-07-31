package com.hightower.prep.prefixsum;

public class FindPivotIndex {

    public int find(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        sumLeft[left] = nums[left++];
        sumRight[right] = nums[right--];
        while (right >= 0) {
            sumLeft[left] = sumLeft[left -1] + nums[left];
            sumRight[right] = sumRight[right+1] + nums[right];
            left++;
            right--;
        }
        left=0;
        while (left < nums.length) {
            if (sumLeft[left] == sumRight[left])  {
                return left;
            }
            left++;
        }
        return -1;
    }

}
