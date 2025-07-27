package com.hightower.prep.graphs;

import java.util.*;

public class DepthFirstTraversalIterative {

    public int[] traverse(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Set<Integer> visited = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                results.add(current);
                visited.add(current);
                int[] neighbours = graph[current];
                for (int i = neighbours.length - 1; i >= 0; i--) {
                    int neighbour = neighbours[i];
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }
            }
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

}
