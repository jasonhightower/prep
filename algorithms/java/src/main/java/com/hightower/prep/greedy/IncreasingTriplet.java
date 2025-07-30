package com.hightower.prep.greedy;

// TODO JH study this
public class IncreasingTriplet {

    public boolean find(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num: nums) {
           if (num < first) {
               first = num;
           } else if (num < second) {
               second = num;
           } else {
               return true;
           }
        }
        return false;
    }
}
