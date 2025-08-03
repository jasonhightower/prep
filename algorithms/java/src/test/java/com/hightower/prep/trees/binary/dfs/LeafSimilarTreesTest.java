package com.hightower.prep.trees.binary.dfs;

import com.hightower.prep.trees.TreeHelper;
import com.hightower.prep.trees.binary.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeafSimilarTreesTest {

    private LeafSimilarTrees classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new LeafSimilarTrees();
    }

    @Test
    public void testCase1() {
        List<TreeNode<Integer>> nodes = TreeHelper.createTreeNodes(9);
        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(0));
        nodes.get(4).setLeft(nodes.get(5));
        nodes.get(4).setRight(nodes.get(1));
        nodes.get(1).setLeft(nodes.get(6));
        nodes.get(1).setRight(nodes.get(3));
        nodes.get(0).setLeft(nodes.get(8));
        nodes.get(0).setRight(nodes.get(7));
        TreeNode<Integer> root1 = nodes.get(2);

        nodes = TreeHelper.createTreeNodes(9);
        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(0));
        nodes.get(4).setLeft(nodes.get(5));
        nodes.get(4).setRight(nodes.get(6));
        nodes.get(0).setLeft(nodes.get(3));
        nodes.get(0).setRight(nodes.get(1));
        nodes.get(1).setLeft(nodes.get(8));
        nodes.get(1).setRight(nodes.get(7));
        TreeNode<Integer> root2 = nodes.get(2);

        assertTrue(this.classUnderTest.isSimilar(root1, root2));
    }

}
