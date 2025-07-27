package com.hightower.prep.trees;

public class TreeNode<T> {

    private final T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public void setLeft(final TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public void setRight(final TreeNode<T> right) {
        this.right = right;
    }


}
