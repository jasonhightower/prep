package com.hightower.prep.graphs.dfs;

import java.util.*;

public class NumberOfProvinces {

    private void visit(int[][] isConnected, int city, boolean[] visited) {
        for (int j = 0; j < isConnected.length; j++) {
            if (city != j && !visited[j] && isConnected[city][j] == 1) {
                visited[j] = true;
                visit(isConnected, j, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int circles = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                circles++;
                visit(isConnected, i, visited);
            }
        }
        return circles;
    }


    public static void main(String[] args) {
        assertResult(2, new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        });
        assertResult(3, new int[][] {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        });
    }

    private static void assertResult(int expected, int[][] input) {
        int result = new NumberOfProvinces().findCircleNum(input);
        if (expected != result) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, result));
        }
    }

}
