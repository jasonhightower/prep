package com.hightower.prep.trees.binary.bfs;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumLevelSum {

    public int calculate(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        int result = 0;
        int max = Integer.MIN_VALUE;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.remove();
                sum += node.getValue();
                if (node.hasLeft()) {
                    queue.add(node.getLeft());
                }
                if (node.hasRight()) {
                    queue.add(node.getRight());
                }
            }
            if (sum > max) {
                max = sum;
                result = level;
            }
            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        assertResult(2, new Integer[] {1,7,0,7,-8,null,null});
        assertResult(2, new Integer[] {989,null,10250,98693,-89388,null,null,null,-32127});
    }

    private static void assertResult(int expected, Integer[] input) {
        TreeNode<Integer> root = TreeNode.fromArray(input);
        int result = new MaximumLevelSum().calculate(root);
        if (result != expected) {
            throw new RuntimeException(String.format("FAIL: Expected %d, Got %d", expected, result));
        }
    }

}
