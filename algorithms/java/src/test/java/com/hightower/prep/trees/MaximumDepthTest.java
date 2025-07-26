package com.hightower.prep.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthTest {

    private MaximumDepth classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MaximumDepth();
    }

    @Test
    public void testMaxDepth() {
        final TreeNode<Integer> three = new TreeNode<>(3);
        final TreeNode<Integer> nine = new TreeNode<>(9);
        final TreeNode<Integer> twenty = new TreeNode<>(20);
        final TreeNode<Integer> fifteen = new TreeNode<>(15);
        final TreeNode<Integer> seven = new TreeNode<>(7);
        three.setLeft(nine);
        three.setRight(twenty);
        twenty.setLeft(fifteen);
        twenty.setRight(seven);

        int maxDepth = this.classUnderTest.calculate(three);
        assertEquals(3, maxDepth);
    }
}

