package com.hightower.prep.graphs.dfs;

public class ReorderRoutes {

    private int visit(int[][] routes, int route, boolean[] connected) {
        if (route >= routes.length) {
            return 0;
        }
        int reversed = 0;
        int source = routes[route][0];
        int target = routes[route][1];
        if (connected[target]) {
            connected[source] = true;
        } else if (connected[source]) {
             reversed++;
             connected[target] = true;
        }
        return reversed + visit(routes, route + 1, connected);
    }

    public int reorder(int[][] routes) {
        boolean[] connected = new boolean[routes.length + 1];
        connected[0] = true;
        return visit(routes, 0, connected);
    }

    public static void main(String[] args) {
        assertResult(3, new int[][]{
                {0, 1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        });
        assertResult(2, new int[][]{
                {1,0},
                {1,2},
                {3,2},
                {3,4}
        });
        assertResult(0, new int[][]{
                {1,0},
                {2,0}
        });
    }

    private static void assertResult(int expected, int[][] input) {
        int result = new ReorderRoutes().reorder(input);
        if (result != expected) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, result));
        }
    }

}
