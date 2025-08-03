package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

public class CountVisibleNodesRecursive<T extends Comparable<T>> implements Aggregator<T, Integer> {

    public Integer aggregate(final TreeNode<T> root) {
        return countVisible(root, null);
    }

    private int countVisible(final TreeNode<T> root, TreeNode<T> max) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (max == null || root.getValue().compareTo(max.getValue()) >= 0) {
            count++;
            max = root;
        }
        return count +
               countVisible(root.getLeft(), max) +
               countVisible(root.getRight(), max);
    }

}
