package com.hightower.prep.graphs.dfs;

import java.util.*;

public class KeysAndRooms {

    public boolean canVisitAllRooms(final List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int roomKey = stack.pop();
            if (!visited.contains(roomKey)) {
                visited.add(roomKey);

                // get keys from room
                List<Integer> keys = rooms.get(roomKey);
                for (Integer key : keys) {
                    stack.push(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );
        assertResult(true, rooms);

        rooms = List.of(
                List.of(1, 3),
                List.of(3,0,1),
                List.of(2),
                List.of(0)
        );
        assertResult(false, rooms);
    }

    private static void assertResult(boolean expected, List<List<Integer>> rooms) {
        if (expected != new KeysAndRooms().canVisitAllRooms(rooms)) {
            throw new RuntimeException("FAIL");
        }
    }

}
