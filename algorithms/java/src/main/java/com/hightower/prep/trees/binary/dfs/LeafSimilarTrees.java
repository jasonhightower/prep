package com.hightower.prep.trees.binary.dfs;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public <T> boolean isSimilar(TreeNode<T> root1, TreeNode<T> root2) {
        List<T> sequence1 = new ArrayList<>();
        List<T> sequence2 = new ArrayList<>();
        calcSequence(root1, sequence1);
        calcSequence(root2, sequence2);
        return sequence1.equals(sequence2);
    }

    private <T> void calcSequence(TreeNode<T> node, List<T> sequence) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            sequence.add(node.getValue());
        } else {
            calcSequence(node.getLeft(), sequence);
            calcSequence(node.getRight(), sequence);
        }
    }


}
