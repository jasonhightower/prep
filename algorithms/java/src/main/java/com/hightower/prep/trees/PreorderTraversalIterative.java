package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversalIterative implements Traversal {

    @Override
    public <T> List<T> traverse(TreeNode<T> root) {
        if (root == null) {
            return List.of();
        }
        List<T> results = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            results.add(current.getValue());
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
        return results;
    }
}
