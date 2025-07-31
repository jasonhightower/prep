package com.hightower.prep.mapsandsets;

import java.util.*;

public class EqualRowAndColumnPairs {

    public int count(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return n;
        }
        Map<List<Integer>, Integer> foundPairs = new HashMap<>();
        for (int row = 0; row < n; row++) {
            List<Integer> key = new ArrayList<>();
            for (int col = 0; col < n; col++) {
                key.add(grid[row][col]);
            }
            foundPairs.put(key, foundPairs.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            List<Integer> key = new ArrayList<>();
            for (int[] row: grid) {
                key.add(row[col]);
            }
            count += foundPairs.getOrDefault(key, 0);
        }
        return count;
    }

}
