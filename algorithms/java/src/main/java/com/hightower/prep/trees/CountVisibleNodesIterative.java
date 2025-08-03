package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.Stack;

public class CountVisibleNodesIterative<T extends Comparable<T>> implements Aggregator<T, Integer> {

    @Override
    public Integer aggregate(final TreeNode<T> root) {
        Stack<Pair<T>> stack = new Stack<>();
        int count = 0;
        stack.push(new Pair<>(root,null));
        Pair<T> current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            T maxVal = current.maxVal;
            if (maxVal == null || current.node.getValue().compareTo(maxVal) >= 0) {
                count++;
                maxVal = current.node.getValue();
            }
            if (current.node.getLeft() != null) {
                stack.push(new Pair<>(current.node.getLeft(), maxVal));
            }
            if (current.node.getRight() != null) {
                stack.push(new Pair<>(current.node.getRight(), maxVal));
            }
        }
        return count;
    }

    private static class Pair<T> {

        public TreeNode<T> node;
        public T maxVal;

        public Pair(TreeNode<T> node, T maxVal) {
           this.node = node;
           this.maxVal = maxVal;
        }
    }
}
