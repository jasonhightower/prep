package com.hightower.prep.algomap.arraysandstrings;

/**
 * Given an array of numbers. Find the value closest to zero and return it.
 * If two numbers are the same distance from zero then return the larger integer.
 *
 * In order to solve this problem we need to iterate through the array, save the closest
 * value to zero that we've seen so far and compare it against each subsequent number. If
 * we find a number that is the same distance we keep the one that is larger, if we find
 * a number close to zero we replace it with that number. Once we've iterated through the
 * entire array we return the value of the closest number we've found.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FindClosestToZero {

    public int findClosestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int closest = Integer.MIN_VALUE;
        int distance = Integer.MAX_VALUE;
        int distI;
        for (int i = 0; i < nums.length; i++) {
            distI = Math.abs(nums[i]);
            if (distI < distance) {
                closest = nums[i];
                distance = distI;
            } else if (distI == distance) {
                if (closest < nums[i]) {
                    closest = nums[i];
                }
            }
        }
        return closest;
    }

}
