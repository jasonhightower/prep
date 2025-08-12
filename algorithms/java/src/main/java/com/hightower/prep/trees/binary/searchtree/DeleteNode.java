package com.hightower.prep.trees.binary.searchtree;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.Arrays;

// TODO JH need to review/revisit this one to understand it better

// The key is to understand is understanding when the node being deleted has two children
// how the inorder traversal allows you to find the larges (or smallest) subnode
// to replace the node being removed
public class DeleteNode {

    public TreeNode<Integer> delete(TreeNode<Integer> root, int target) {
        if (root == null) {
            return null;
        }
        if (root.getValue() > target) {
            root.setLeft(delete(root.getLeft(), target));
        } else if (root.getValue() < target) {
            root.setRight(delete(root.getRight(), target));
        } else {
            if (!root.hasRight() && !root.hasLeft()) {
                return null;
            }
            if (!root.hasRight()) {
                return root.getLeft();
            }
            if (!root.hasLeft()) {
                return root.getRight();
            }
            TreeNode<Integer> successor = findInorderSuccessor(root.getRight());
            root.setValue(successor.getValue());
            root.setRight(delete(root.getRight(), successor.getValue()));
        }

        return root;
    }

    private TreeNode<Integer> findInorderSuccessor(TreeNode<Integer> root) {
        while (root.hasLeft()) {
            root = root.getLeft();
        }
        return root;
    }

    public static void main(String[] args) {
        assertResult(new Integer[] {5,4,6,2,null,null,7}, new Integer[] {5,3,6,2,4,null,7}, 3);
    }

    private static void assertResult(Integer[] expected, Integer[] input, Integer target) {
        TreeNode<Integer> root = TreeNode.fromArray(input);
        TreeNode<Integer> result = new DeleteNode().delete(root, target);

        TreeNode<Integer> expectedTree = TreeNode.fromArray(expected);
        if (!Arrays.equals(expectedTree.toArray(new Integer[0]), result.toArray(new Integer[0]))) {
            throw new RuntimeException("Expected tree did not match result");
        }
    }

}
