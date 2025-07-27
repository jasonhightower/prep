package com.hightower.prep.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BreadthFirstSeachUsingQueueTest {

    private BreadthFirstSearchUsingQueue classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new BreadthFirstSearchUsingQueue();
    }

    @Test
    public void testTargetExists() {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> n2 = TreeHelper.createLeft(root, 2);
        TreeNode<Integer> n7 = TreeHelper.createRight(root, 7);
        TreeHelper.createLeft(n2, 1);
        TreeHelper.createRight(n2, 3);
        TreeNode<Integer> n6 = TreeHelper.createLeft(n7, 6);
        TreeHelper.createRight(n7, 9);

        TreeNode<Integer> result = this.classUnderTest.find(6, root);
        assertEquals(result, n6);
    }

    @Test
    public void testTargetDoesNotExist() {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> n2 = TreeHelper.createLeft(root, 2);
        TreeNode<Integer> n7 = TreeHelper.createRight(root, 7);
        TreeHelper.createLeft(n2, 1);
        TreeHelper.createRight(n2, 3);
        TreeHelper.createLeft(n7, 6);
        TreeHelper.createRight(n7, 9);

        TreeNode<Integer> result = this.classUnderTest.find(5, root);
        assertNull(result);
    }

}
