package com.hightower.prep.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTreeTraversal implements Traversal {

    @Override
    public <T> List<T> traverse(TreeNode<T> root) {
        if (root == null) {
            return List.of();
        }
        List<T> items = new ArrayList<>();
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.remove();
            items.add(current.getValue());
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return items;
    }

}
