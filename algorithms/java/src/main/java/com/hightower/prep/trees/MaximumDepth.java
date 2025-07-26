package com.hightower.prep.trees;

public class MaximumDepth {

    public int calculate(TreeNode<?> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calculate(root.getLeft()), calculate(root.getRight()));
    }

}
