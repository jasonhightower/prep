package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalanceCheckTest {

    private BalanceCheck<Integer> classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new BalanceCheck<>();
    }

    @Test
    public void testBalancedTree() {
        TreeNode<Integer> root = new TreeNode<>(3);
        TreeHelper.createLeft(root, 9);
        TreeNode<Integer> twenty = TreeHelper.createRight(root, 20);
        TreeHelper.createLeft(twenty, 15);
        TreeHelper.createRight(twenty, 7);

        assertTrue(this.classUnderTest.isBalanced(root));
    }

    @Test
    public void testUnbalancedTree() {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> l2 = TreeHelper.createLeft(root, 2);
        TreeHelper.createRight(root, 2);
        TreeNode<Integer> l3 = TreeHelper.createLeft(l2, 3);
        TreeHelper.createRight(root, 3);
        TreeNode<Integer> l4 = TreeHelper.createLeft(l3, 4);
        TreeHelper.createRight(root, 4);

        assertFalse(this.classUnderTest.isBalanced(root));
    }

}
