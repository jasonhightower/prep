package com.hightower.prep.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstSearchTest {

    private DepthFirstSearch classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new DepthFirstSearch();
    }

    @Test
    void testDepthFirstSearch()  {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> three = new TreeNode<>(3);
        root.setRight(two);
        two.setLeft(three);

        TreeNode<Integer> node = classUnderTest.find(2, root);
        assertEquals(two, node);
    }

    @Test
    void testDepthFirstSearchComplex()  {
        List<TreeNode<Integer>> nodes = TreeHelper.createTreeNodes(9);
        nodes.get(0).setLeft(nodes.get(1));
        nodes.get(0).setRight(nodes.get(2));
        nodes.get(1).setLeft(nodes.get(3));
        nodes.get(1).setRight(nodes.get(4));
        nodes.get(4).setLeft(nodes.get(5));
        nodes.get(4).setRight(nodes.get(6));
        nodes.get(2).setRight(nodes.get(7));
        nodes.get(7).setLeft(nodes.get(8));

        TreeNode<Integer> node = classUnderTest.find(7, nodes.get(0));
        assertEquals(nodes.get(6), node);
    }


}
