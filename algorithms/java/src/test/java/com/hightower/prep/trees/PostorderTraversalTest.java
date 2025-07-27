package com.hightower.prep.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PostorderTraversalTest {

    private static Stream<Arguments> provideTraversalImplementations() {
        return Stream.of(
                Arguments.of(new PostorderTraversalRecursive()),
                Arguments.of(new PostorderTraversalIterative())
        );
    }

    @ParameterizedTest
    @MethodSource("provideTraversalImplementations")
    void testPostorderTraversal(final Traversal classUnderTest)  {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> three = new TreeNode<>(3);
        root.setRight(two);
        two.setLeft(three);

        List<Integer> results = classUnderTest.traverse(root);
        assertArrayEquals(new Integer[] {3,2,1},
                results.toArray(new Integer[0]));
    }

    @ParameterizedTest
    @MethodSource("provideTraversalImplementations")
    void testPostorderTraversalComplex(final Traversal classUnderTest)  {
        List<TreeNode<Integer>> nodes = TreeHelper.createTreeNodes(9);
        nodes.get(0).setLeft(nodes.get(1));
        nodes.get(0).setRight(nodes.get(2));
        nodes.get(1).setLeft(nodes.get(3));
        nodes.get(1).setRight(nodes.get(4));
        nodes.get(4).setLeft(nodes.get(5));
        nodes.get(4).setRight(nodes.get(6));
        nodes.get(2).setRight(nodes.get(7));
        nodes.get(7).setLeft(nodes.get(8));
        List<Integer> results = classUnderTest.traverse(nodes.get(0));
        assertArrayEquals(new Integer[] {4,6,7,5,2,9,8,3,1},
                results.toArray(new Integer[0]));
    }

    @ParameterizedTest
    @MethodSource("provideTraversalImplementations")
    void testPostorderTraversalNull(final Traversal classUnderTest)  {
        List<Integer> results = classUnderTest.traverse(null);
        assertArrayEquals(new Integer[] {},
                results.toArray(new Integer[0]));
    }

}
