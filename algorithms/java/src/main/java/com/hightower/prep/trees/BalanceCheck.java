package com.hightower.prep.trees;

import java.util.Optional;

public class BalanceCheck<T>  {

    public boolean isBalanced(final TreeNode<T> root) {
        return getBalancedHeight(root).isPresent();
    }

    private Optional<Integer> getBalancedHeight(final TreeNode<T> root) {
        if (root == null) {
            return Optional.of(0);
        }
        Optional<Integer> leftHeight = getBalancedHeight(root.getLeft());
        Optional<Integer> rightHeight = getBalancedHeight(root.getRight());
        if (leftHeight.isEmpty() || rightHeight.isEmpty()) {
            return Optional.empty();
        }
        int height_diff = Math.abs(leftHeight.get() - rightHeight.get());
        if (height_diff > 1) {
            return Optional.empty();
        }
        return Optional.of(1 + Math.max(leftHeight.get(), rightHeight.get()));
    }
}
