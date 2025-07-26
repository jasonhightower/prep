package com.hightower.prep.trees;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversalRecursive implements Traversal {

    @Override
    public <T> List<T> traverse(final TreeNode<T> root) {
        if (root == null) {
            return List.of();
        }
        List<T> results = new ArrayList<>();
        results.add(root.getValue());
        results.addAll(traverse(root.getLeft()));
        results.addAll(traverse(root.getRight()));
        return results;
    }
}
