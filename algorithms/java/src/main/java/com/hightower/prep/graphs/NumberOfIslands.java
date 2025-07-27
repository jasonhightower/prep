package com.hightower.prep.graphs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberOfIslands {

    public int count(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Set<Coord> visited = new HashSet<>();
        int count = 0;
        int cols = grid.length;
        int rows = grid[0].length;
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (grid[c][r] == 1) {
                    Coord coord = new Coord(c, r);
                    if (!visited.contains(coord)) {
                        count++;
                        dfs(coord, grid, visited);
                    }
                }
            }
        }
        return count;
    }

    private void dfs(Coord location, int[][] grid, Set<Coord> visited) {
       if (location.x < 0 ||
               location.x >= grid.length ||
               location.y < 0 ||
               location.y >= grid[location.x].length ||
               grid[location.x][location.y] == 0 ||
               visited.contains(location)) {
           return;
       }
       visited.add(location);
       dfs(location.getLeft(), grid, visited);
       dfs(location.getRight(), grid, visited);
       dfs(location.getUp(), grid, visited);
       dfs(location.getDown(), grid, visited);
    }

    private static class Coord {
        private int x;
        private int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Coord)) {
                return false;
            }
            Coord target = (Coord)obj;
            return target.x == this.x &&
                    target.y == this.y;
        }

        public Coord getLeft() {
            return new Coord(this.x + 1, this.y);
        }

        public Coord getRight() {
            return new Coord(this.x - 1, this.y);
        }

        public Coord getUp() {
            return new Coord(this.x, this.y - 1 );
        }

        public Coord getDown() {
            return new Coord(this.x, this.y + 1);
        }

    }

}
