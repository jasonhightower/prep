package com.hightower.prep.arrays.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

// TODO JH simplify this
public class Maze {

    public int nearestExit(char[][] maze, int[] entrance) {
        maze[entrance[0]][entrance[1]] = 'e';
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(entrance);

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.remove();
                if (pos != entrance && isExit(maze, pos[0], pos[1])) {
                    return moves;
                }
                maze[pos[0]][pos[1]] = 'v';
                if (canMove(maze, pos[0] + 1, pos[1])) {
                    queue.add(new int[]{pos[0] +1, pos[1]});
                }
                if (canMove(maze, pos[0] - 1, pos[1])) {
                    queue.add(new int[]{pos[0] - 1, pos[1]});
                }
                if (canMove(maze, pos[0], pos[1] + 1)) {
                    queue.add(new int[]{pos[0], pos[1] + 1});
                }
                if (canMove(maze, pos[0], pos[1] - 1)) {
                    queue.add(new int[]{pos[0], pos[1] - 1});
                }
            }
            moves++;
        }
        return -1;
    }

    private boolean isExit(char[][] maze, int row, int col) {
        return row == 0 || col == 0 || row + 1 == maze.length || col + 1 == maze[0].length;
    }

    private boolean canMove(char[][] maze, int row, int col) {
        return row >= 0 && col >= 0 && row < maze.length && col < maze[0].length &&
                maze[row][col] == '.';
    }

    public static void main(String[] args) {
        char[][] maze = new char[][] {
                {'+','+','+'},
                {'.','.','.'},
                {'+','+','+'}
        };
        int[] entrance = new int[] {1,0};
        assertResult(2, maze, entrance);

        maze = new char[][] {
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        entrance = new int[] {1,2};
        assertResult(1, maze, entrance);

        maze = new char[][] {
                {'.','+'}
        };
        entrance = new int[] {0,0};
        assertResult(-1, maze, entrance);
    }

    private static void assertResult(int expected, char[][] maze, int[] entrance) {
        int result = new Maze().nearestExit(maze, entrance);
        if (result != expected) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, result));
        }
    }
}
