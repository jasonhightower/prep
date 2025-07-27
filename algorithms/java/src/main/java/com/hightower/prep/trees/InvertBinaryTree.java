package com.hightower.prep.trees;

public class InvertBinaryTree {

    public <T> TreeNode<T> invert(TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        TreeNode<T> temp = root.getLeft();
        root.setLeft(invert(root.getRight()));
        root.setRight(invert(temp));
        return root;
    }

}
