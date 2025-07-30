package com.hightower.prep.arrays;

public class KidsWithCandies {

    public boolean[] calculate(int[] numCandies, int extra) {
        int max = numCandies[0];
        for (int i = 1; i < numCandies.length; i++) {
            max = Math.max(numCandies[i], max);
        }
        boolean[] results = new boolean[numCandies.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = numCandies[i] + extra >= max;
        }
        return results;
    }
}
