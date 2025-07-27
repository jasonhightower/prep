package com.hightower.prep.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BreadthFirstTraversalIterativeTest {

    private BreadthFirstTraversalIterative classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new BreadthFirstTraversalIterative();
    }

    @Test
    public void testTraversalNonCyclic() {
        int[][] graph = new int[][] {{2, 3, 1}, {0}, {0,4}, {0}, {2}};
        int[] results = this.classUnderTest.traverse(graph);
        assertArrayEquals(new int[] {0, 2, 3, 1, 4}, results);
    }

    @Test
    public void testTraversalCyclic() {
        int[][] graph = new int[][] {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        int[] results = this.classUnderTest.traverse(graph);
        assertArrayEquals(new int[] {0, 1, 2, 3, 4}, results);
    }

}
