package com.hightower.prep.trees.binary;

public class LongestZigZagPath {

    int calculate(TreeNode<?> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(calculate(node.getLeft(), false), calculate(node.getRight(), true));
    }

    int calculate(TreeNode<?> node, boolean goLeft) {
        if (node == null) {
            return 0;
        }
        if (goLeft) {
            return Math.max(1 + calculate(node.getLeft(), false),
                    calculate(node.getRight(), true));
        } else {
            return Math.max(1 + calculate(node.getRight(), true),
                    calculate(node.getLeft(), false));
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> node = TreeNode.fromArray(new Integer[] {1,null,1,1,1,null,null,1,1,null,1,null,null,null,1});
        int expected = 3;
        int result = new LongestZigZagPath().calculate(node);
        if (expected != result) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, result));
        }

        node = TreeNode.fromArray(new Integer[] {1, 1, 1, null, 1, null, null, 1,1,null, 1});
        expected = 4;
        result = new LongestZigZagPath().calculate(node);
        if (expected != result) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, result));
        }

        node = TreeNode.fromArray(new Integer[] {1});
        expected = 0;
        result = new LongestZigZagPath().calculate(node);
        if (expected != result) {
            throw new RuntimeException(String.format("FAIL: expected %d, got %d", expected, result));
        }



    }

}
