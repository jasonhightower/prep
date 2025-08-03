package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubtreeCheckTest {

    private SubtreeCheck classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new SubtreeCheck();
    }

    @Test
    public void testSubtree() {
        TreeNode<Integer> root = new TreeNode<>(3);
        TreeNode<Integer> p4 = TreeHelper.createLeft(root, 4);
        TreeHelper.createLeft(p4, 1);
        TreeHelper.createRight(p4, 2);
        TreeNode<Integer> p5 = TreeHelper.createRight(root, 5);

        TreeNode<Integer> subtree = new TreeNode<>(4);
        TreeHelper.createLeft(subtree, 1);
        TreeHelper.createRight(subtree, 2);

        assertTrue(this.classUnderTest.isSubtree(root, subtree));
    }

    @Test
    public void testNonSubtree() {
        TreeNode<Integer> root = new TreeNode<>(3);
        TreeNode<Integer> p4 = TreeHelper.createLeft(root, 4);
        TreeHelper.createRight(root, 5);

        TreeHelper.createLeft(p4, 1);
        TreeNode<Integer> p2 = TreeHelper.createRight(p4, 2);
        TreeHelper.createRight(p2, 0);

        TreeNode<Integer> subtree = new TreeNode<>(4);
        TreeHelper.createLeft(subtree, 1);
        TreeHelper.createRight(subtree, 2);

        assertFalse(this.classUnderTest.isSubtree(root, subtree));
    }

}
