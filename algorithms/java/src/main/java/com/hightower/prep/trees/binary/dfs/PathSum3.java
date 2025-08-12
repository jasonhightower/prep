package com.hightower.prep.trees.binary.dfs;

import com.hightower.prep.trees.binary.TreeNode;

public class PathSum3 {

    int count(TreeNode<Integer> root, int target) {
        if (root == null) {
            return 0;
        }
        return count(root, target, 0);
    }

    int count(TreeNode<Integer> root, int target, int currentSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.getValue() + currentSum == target) {
            count++;
        } else {
            count += count(root.getLeft(), target, currentSum + root.getValue());
            count += count(root.getRight(), target, currentSum + root.getValue());
        }
        count += count(root.getLeft(), target, 0);
        count += count(root.getRight(), target, 0);
        return count;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeNode.fromArray(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        int expected = 3;
        int count = new PathSum3().count(root, 8);
        if (expected != count) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, count));
        }

        root = TreeNode.fromArray(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1});
        expected = 3;
        count = new PathSum3().count(root, 22);
        if (expected != count) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, count));
        }
    }
}
