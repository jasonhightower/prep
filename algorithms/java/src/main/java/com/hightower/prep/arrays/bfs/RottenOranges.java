package com.hightower.prep.arrays.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

// TODO JH check approach
// really want to understand the minutes count and how I'm tackling that
public class RottenOranges {

    public int timeToRotten(int[][] oranges) {
        Deque<int[]> rottenOranges = new ArrayDeque<>();
        // preprocessing
        int ripeOrangeCount = 0;
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges.length; j++) {
                if (oranges[i][j] == 2) {
                    rottenOranges.add(new int[] {i, j});
                } else if (oranges[i][j] == 1) {
                    ripeOrangeCount++;
                }
            }
        }

        int minutes = 0;
        while (ripeOrangeCount > 0 && !rottenOranges.isEmpty()) {
            int size = rottenOranges.size();
            for (int i = 0; i < size; i++) {
                int[] orange = rottenOranges.remove();
                ripeOrangeCount -= makeRotten(oranges, orange[0], orange[1], rottenOranges);
            }
            minutes++;
        }

        return ripeOrangeCount <= 0 ? minutes : -1;
    }

    private int makeRotten(int[][] oranges, int row, int col, Deque<int[]> rotten) {
        int count = 0;
        if (isRipe(oranges, row + 1, col)) {
            oranges[row + 1][col] = 2;
            rotten.add(new int[] {row + 1, col});
            count++;
        }
        if (isRipe(oranges, row - 1, col)) {
            oranges[row - 1][col] = 2;
            rotten.add(new int[] {row - 1, col});
            count++;
        }
        if (isRipe(oranges, row, col + 1)) {
            oranges[row][col + 1] = 2;

            rotten.add(new int[] {row, col + 1});
            count++;
        }
        if (isRipe(oranges, row, col - 1)) {
            oranges[row][col - 1] = 2;
            rotten.add(new int[] {row, col - 1});
            count++;
        }
        return count;
    }

    private boolean isRipe(int[][] oranges, int row, int col) {
        if (row < 0 ||
            col < 0 ||
            row >= oranges.length ||
            col >= oranges[row].length) {
            return false;
        }
        return oranges[row][col] == 1;
    }

    public static void main(String[] args) {
        int[][] oranges = new int[][] {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        assertResult(4, oranges);

        oranges = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        assertResult(-1, oranges);

        oranges = new int[][] {
                {0,2}
        };
        assertResult(0, oranges);
    }

    private static void assertResult(int expected, int[][] input) {
        int result = new RottenOranges().timeToRotten(input);
        if (result != expected) {
            throw new RuntimeException(String.format("FAIL: expected %d, result %d", expected, result));
        }
    }

}
