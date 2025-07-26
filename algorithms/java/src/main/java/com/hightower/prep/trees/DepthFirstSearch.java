package com.hightower.prep.trees;

public class DepthFirstSearch {

    public <T> TreeNode<T> find(T target, TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        if (root.getValue().equals(target)) {
            return root;
        }
        TreeNode<T> result = find(target, root.getLeft());
        if (result != null) {
            return result;
        }
        return find(target, root.getRight());
    }

}
