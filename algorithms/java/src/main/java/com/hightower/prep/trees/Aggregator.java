package com.hightower.prep.trees;

public interface Aggregator<T, R> {

    R aggregate(TreeNode<T> root);

}
