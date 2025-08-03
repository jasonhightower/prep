package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearchUsingQueue {

    public <T> TreeNode<T> find(T target, TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.remove();
            if (current.getValue() == target) {
                return current;
            }
            if (current.hasLeft()) {
                queue.add(current.getLeft());
            }
            if (current.hasRight()) {
                queue.add(current.getRight());
            }
        }
        return null;
    }
}
