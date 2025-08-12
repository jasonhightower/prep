package com.hightower.prep.trees.binary;

import java.sql.Array;
import java.util.*;

public class LowestCommonAncestor {

    public Integer find(TreeNode<Integer> root, int first, int second) {
        List<Integer> firstAncestors = new ArrayList<>();
        if (!collectAncestors(root, first, firstAncestors)) {
            return null;
        }

        List<Integer> secondAncestors = new ArrayList<>();
        if (!collectAncestors(root, second, secondAncestors)) {
            return null;
        }

        int pos = Math.min(firstAncestors.size(), secondAncestors.size());
        for (int i = pos -1; i >= 0; i--) {
            if (firstAncestors.get(i).equals(secondAncestors.get(i))) {
                return firstAncestors.get(i);
            }
        }
        return null;
    }

    private boolean collectAncestors(TreeNode<Integer> node, int target, List<Integer> ancestors) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == target) {
            ancestors.add(0, node.getValue());
            return true;
        }
        if (collectAncestors(node.getLeft(), target, ancestors) ||
            collectAncestors(node.getRight(), target, ancestors)) {
            ancestors.add(0,node.getValue());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode<Integer> node = TreeNode.fromArray(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        int expected = 3;
        int val = new LowestCommonAncestor().find(node, 5, 1);
        if (expected != val) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, val));
        }

        node = TreeNode.fromArray(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        expected = 5;
        val = new LowestCommonAncestor().find(node, 5, 4);
        if (expected != val) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, val));
        }

        node = TreeNode.fromArray(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
        expected = 5;
        val = new LowestCommonAncestor().find(node, 6, 4);
        if (expected != val) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, val));
        }
     }

}
