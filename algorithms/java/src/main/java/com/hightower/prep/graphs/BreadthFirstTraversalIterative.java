package com.hightower.prep.graphs;

import java.util.*;

public class BreadthFirstTraversalIterative {

    public int[] traverse(int[][] graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int current = queue.pop();
            if (!visited.contains(current)) {
                results.add(current);
                visited.add(current);
                for (int neighbour:graph[current]) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

}
