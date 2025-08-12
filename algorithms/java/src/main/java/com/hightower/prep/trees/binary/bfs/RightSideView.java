package com.hightower.prep.trees.binary.bfs;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// TODO JH confirm this approach
public class RightSideView {

    public int[] calculate(TreeNode<Integer> root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode<Integer> last = null;
            for (int i = 0; i < size; i++) {
                last = queue.remove();
                if (last.hasLeft()) {
                    queue.add(last.getLeft());
                }
                if (last.hasRight()) {
                    queue.add(last.getRight());
                }
            }
            results.add(last.getValue());
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        assertResult(new int[] {1,3,4}, new Integer[] {1,2,3,null,5,null,4});
        assertResult(new int[] {1,3,4,5}, new Integer[] {1,2,3,4,null,null,null,5});
        assertResult(new int[] {1,3}, new Integer[] {1,null,3});
        assertResult(new int[] {}, new Integer[] {});
    }

    private static void assertResult(int[] expected, Integer[] input) {
        TreeNode<Integer> root = TreeNode.fromArray(input);
        int[] result = new RightSideView().calculate(root);
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
