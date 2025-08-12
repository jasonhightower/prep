package com.hightower.prep.trees.binary;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode #1448
 *
 * Given a binary tree {@code root}
 */
// TODO JH need to actually hook up proper unit tests for this.
public class CountGoodNodes {

    public int countDfs(TreeNode<Integer> root) {
        int count = 0;
        Deque<TreeNode<Integer>> nodes = new ArrayDeque<>();
        Deque<Integer> maximums = new ArrayDeque<>();
        nodes.push(root);
        maximums.push(root.getValue());
        while (!nodes.isEmpty()) {
            TreeNode<Integer> node = nodes.pop();
            int max = maximums.pop();
            if (node.getValue() >= max) {
                count++;
                max = node.getValue();
            }
            if (node.hasLeft()) {
                maximums.push(max);
                nodes.push(node.getLeft());
            }
            if (node.hasRight()) {
                maximums.push(max);
                nodes.push(node.getRight());
            }
        }
        return count;
    }

    public int countBfs(TreeNode<Integer> root) {
        int count = 0;
        Deque<TreeNode<Integer>> nodes = new ArrayDeque<>();
        Deque<Integer> maximums = new ArrayDeque<>();
        nodes.add(root);
        maximums.add(root.getValue());
        while (!nodes.isEmpty()) {
            TreeNode<Integer> node = nodes.remove();
            int max = maximums.remove();
            if (node.getValue() >= max) {
                count++;
                max = node.getValue();
            }
            if (node.hasLeft()) {
                maximums.add(max);
                nodes.add(node.getLeft());
            }
            if (node.hasRight()) {
                maximums.add(max);
                nodes.add(node.getRight());
            }
        }
        return count;
    }



    public int count(TreeNode<Integer> root) {
        return 1 + count(root.getLeft(), root.getValue()) + count(root.getRight(), root.getValue());
    }

    private int count(TreeNode<Integer> root, int max) {
        if (root == null) {
            return 0;
        }
        if (root.getValue() >= max) {
            return 1 + count(root.getLeft(), root.getValue()) + count(root.getRight(), root.getValue());
        } else {
            return count(root.getLeft(), max) + count(root.getRight(), max);
        }
    }

    public static void main(String[] args) {
        assertResult(4, new Integer[] {3,1,4,3,null,1,5});
        assertResult(3, new Integer[] {3,3,null,4,2, null, null});
        assertResult(1, new Integer[] {1});
    }

    private static void assertResult(int expected, Integer[] input) {
        TreeNode<Integer> root = TreeNode.fromArray(input);
        int count = new CountGoodNodes().count(root);
        if (expected != count) {
            throw new RuntimeException(String.format("Recursive FAILED got %d expected %d", count, expected));
        }
        count = new CountGoodNodes().countDfs(root);
        if (expected != count) {
            throw new RuntimeException(String.format("BFS FAILED got %d expected %d", count, expected));
        }
        count = new CountGoodNodes().countDfs(root);
        if (expected != count) {
            throw new RuntimeException(String.format("DFS FAILED got %d expected %d", count, expected));
        }
    }

}
