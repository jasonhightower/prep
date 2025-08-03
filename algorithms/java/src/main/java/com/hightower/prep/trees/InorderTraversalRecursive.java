package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalRecursive implements Traversal {

    @Override
    public <T> List<T> traverse(TreeNode<T> root) {
        if (root == null) {
            return List.of();
        }
        List<T> results = new ArrayList<>(traverse(root.getLeft()));
        results.add(root.getValue());
        results.addAll(traverse(root.getRight()));
        return results;
    }

}
