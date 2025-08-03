package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.List;

public interface Traversal {

    <T> List<T> traverse(TreeNode<T> root);

}
