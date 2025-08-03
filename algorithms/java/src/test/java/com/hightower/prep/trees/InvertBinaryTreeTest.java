package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvertBinaryTreeTest {

    private InvertBinaryTree classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new InvertBinaryTree();
    }

    @Test
    public void testInvertTree() {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> n2 = TreeHelper.createLeft(root, 2);
        TreeNode<Integer> n7 = TreeHelper.createRight(root, 7);
        TreeHelper.createLeft(n2, 1);
        TreeHelper.createRight(n2, 3);
        TreeHelper.createLeft(n7, 6);
        TreeHelper.createRight(n7, 9);

        this.classUnderTest.invert(root);
        TreeNode<Integer> s7 = root.getLeft();
        assertEquals(7, s7.getValue());

        TreeNode<Integer> s2 = root.getRight();
        assertEquals(2, s2.getValue());

        TreeNode<Integer> s9 = s7.getLeft();
        assertEquals(9, s9.getValue());

        TreeNode<Integer> s6 = s7.getRight();
        assertEquals(6, s6.getValue());

        TreeNode<Integer> s3 = s2.getLeft();
        assertEquals(3, s3.getValue());

        TreeNode<Integer> s1 = s2.getRight();
        assertEquals(1, s1.getValue());
    }
}
