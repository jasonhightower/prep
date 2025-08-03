package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversalRecursive implements Traversal {

    @Override
    public <T> List<T> traverse(TreeNode<T> root) {
        if (root == null) {
            return List.of();
        }
        List<T> results = new ArrayList<>();
        results.addAll(traverse(root.getLeft()));
        results.addAll(traverse(root.getRight()));
        results.add(root.getValue());
        return results;
    }

}
