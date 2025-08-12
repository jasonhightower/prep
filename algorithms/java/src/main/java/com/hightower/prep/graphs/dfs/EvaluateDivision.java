package com.hightower.prep.graphs.dfs;

import java.util.*;

// TODO JH need to study this
// It's effectively a directed weighted graph
// Where A -> B == X and B -> A is 1/X
//
// solved by first constructing a graph
// then traversing it until the end node is found and result of the calculation is returned.
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {
        // construct the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0/values[i]);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < results.length; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            visited.add(start);
            results[i] = traverse(graph, visited, start, end);
        }
        return results;
    }

    private double traverse(final Map<String, Map<String, Double>> graph,
                            final Set<String> visited,
                            final String cur,
                            final String end) {
        if (!graph.containsKey(cur) || !graph.containsKey(end)) {
            return -1;
        }
        if (cur.equals(end)) {
            return 1.0;
        }
        visited.add(cur);
        for (Map.Entry<String, Double> entry: graph.get(cur).entrySet()) {
            String next = entry.getKey();
            double weight = entry.getValue();
            if (!visited.contains(next)) {
                double result = traverse(graph, visited, next, end);
                if (result != -1.0) {
                    return weight * result;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<String>> equations = List.of(
                List.of("a", "b"),
                List.of("b", "c")
        );
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a","a"),
                List.of("x","x")
        );
        assertResult(new double[] {6.0, 0.5, -1.0, 1.0, -1.0}, equations, values, queries);

        equations = List.of(
                List.of("a", "b"),
                List.of("b", "c"),
                List.of("bc", "cd")
        );
        values = new double[] {1.5, 2.5, 5.0};
        queries = List.of(
                List.of("a", "c"),
                List.of("c", "b"),
                List.of("bc", "cd"),
                List.of("cd","bc")
        );
        assertResult(new double[] {3.75,0.4,5.0,0.2}, equations, values, queries);
    }

    private static void assertResult(double[] expected, List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new EvaluateDivision().calcEquation(equations, values, queries);
        if (!Arrays.equals(expected, result)) {
            throw new RuntimeException("FAIL: arrays mismatch");
        }
    }
}
