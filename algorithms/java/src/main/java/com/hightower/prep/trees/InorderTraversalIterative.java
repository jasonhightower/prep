package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TODO JH need to revisit this. Study stack based vs recursive.
public class InorderTraversalIterative implements Traversal {

    @Override
    public <T> List<T> traverse(TreeNode<T> root) {
        List<T> results = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            results.add(current.getValue());
            current = current.getRight();
        }
        return results;
    }

}
