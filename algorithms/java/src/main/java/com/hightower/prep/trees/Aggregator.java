package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

public interface Aggregator<T, R> {

    R aggregate(TreeNode<T> root);

}
