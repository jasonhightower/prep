package com.hightower.prep.trees;

public class SubtreeCheck {

    public <T> boolean isSubtree(TreeNode<T> root, TreeNode<T> subtree) {
        return matches(root, subtree) ||
                matches(root.getLeft(), subtree) ||
                matches(root.getRight(), subtree);
    }

    private <T> boolean matches(TreeNode<T> first, TreeNode<T> second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (!first.getValue().equals(second.getValue())) {
            return false;
        }
        return matches(first.getLeft(), second.getLeft()) &&
                matches(first.getRight(), second.getRight());
    }
}
