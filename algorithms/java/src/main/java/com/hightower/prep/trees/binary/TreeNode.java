package com.hightower.prep.trees.binary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeNode<T> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public static <T> TreeNode<T> fromArray(final T[] integers) {
        if (integers == null || integers.length == 0) {
            return null;
        }
        int offset=0;
        TreeNode<T> root = new TreeNode<>(integers[offset++]);
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.remove();
            if (offset >= integers.length) {
                return root;
            }
            if (integers[offset] != null) {
                TreeNode<T> left = new TreeNode<>(integers[offset]);
                node.setLeft(left);
                stack.add(left);
            }
            offset++;
            if (offset >= integers.length) {
                return root;
            }
            if (integers[offset] != null) {
                TreeNode<T> right = new TreeNode<>(integers[offset]);
                node.setRight(right);
                stack.add(right);
            }
            offset++;
        }
        return root;
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

    public T[] toArray(T[] array) {
        List<T> result = new ArrayList<>();
        Deque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.remove();
            result.add(node.getValue());
            if (node.hasLeft()) {
                queue.add(node.getLeft());
            }
            if (node.hasRight()) {
                queue.add(node.getRight());
            }
        }
        return result.toArray(array);
    }

    public void setValue(T value) {
        this.value = value;
    }
}
