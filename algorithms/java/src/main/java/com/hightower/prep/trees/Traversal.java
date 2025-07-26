package com.hightower.prep.trees;

import java.util.List;

public interface Traversal {

    <T> List<T> traverse(TreeNode<T> root);

}
