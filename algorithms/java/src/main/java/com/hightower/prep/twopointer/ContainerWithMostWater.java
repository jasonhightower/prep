package com.hightower.prep.twopointer;

import java.util.Arrays;

// TODO JH remember that sorting is always an option
public class ContainerWithMostWater {

    public int calculate(int[] heights) {
        Arrays.sort(heights);
        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;
        while (left < right) {
           int curArea = (right - left) * Math.min(heights[left], heights[right]);
           if (curArea > maxArea) {
               maxArea = curArea;
           }
           if (heights[left] > heights[right]) {
               right--;
           } else {
               left++;
           }
        }
        return maxArea;
    }

}
