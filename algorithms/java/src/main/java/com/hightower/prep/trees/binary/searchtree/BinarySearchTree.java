package com.hightower.prep.trees.binary.searchtree;

import com.hightower.prep.trees.binary.TreeNode;

public class BinarySearchTree {

    public <T extends Comparable<T>> TreeNode<T> find(TreeNode<T> root, T target) {
        if (root == null) {
            return null;
        }
        int result = root.getValue().compareTo(target);
        if (result == 0) {
            return root;
        } else if (result < 0) {
            return find(root.getRight(), target);
        } else {
            return find(root.getLeft(), target);
        }
    }

    public static void main(String[] args) {
        assertResult(new int[] {2,1,3}, new Integer[] {4,2,7,1,3}, 2);
        assertResult(new int[]{}, new Integer[]{4,2,7,1,3}, 5);
    }

    private static void assertResult(int[] expected, Integer[] input, Integer target) {
        TreeNode<Integer> root = TreeNode.fromArray(input);
        TreeNode<Integer> node = new BinarySearchTree().find(root, target);
        Integer[] result;
        if (node == null) {
            result = new Integer[0];
        } else {
            result = node.toArray(new Integer[0]);
        }
        if (result.length != expected.length) {
            throw new RuntimeException(String.format("FAIL: lengths differ. Expected %d, Got %d", expected.length, result.length));
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != result[i]) {
                throw new RuntimeException(String.format("FAIL: result %d, expected %d, got %d", i, expected[i], result[i]));
            }
        }
    }

}
