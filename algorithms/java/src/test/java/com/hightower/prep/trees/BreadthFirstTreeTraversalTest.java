package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BreadthFirstTreeTraversalTest {

    private BreadthFirstTreeTraversal classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new BreadthFirstTreeTraversal();
    }

    @Test
    public void testTreeTraversal() {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> n2 = TreeHelper.createLeft(root, 2);
        TreeNode<Integer> n7 = TreeHelper.createRight(root, 7);
        TreeHelper.createLeft(n2, 1);
        TreeHelper.createRight(n2, 3);
        TreeHelper.createLeft(n7, 6);
        TreeHelper.createRight(n7, 9);

        List<Integer> results = this.classUnderTest.traverse(root);
        assertArrayEquals(
                new int[] {4, 2, 7, 1, 3, 6, 9},
                results.stream().mapToInt(Integer::intValue).toArray());
    }

}
