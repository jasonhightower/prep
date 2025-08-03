package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVisibleNodesTest {

    private static Stream<Arguments> provideAggregators() {
        return Stream.of(
                Arguments.of(new CountVisibleNodesRecursive<Integer>()),
                Arguments.of(new CountVisibleNodesIterative<Integer>())
        );
    }

    @ParameterizedTest
    @MethodSource("provideAggregators")
    void testCountVisible(final Aggregator<Integer, Integer> aggregator)  {
        List<TreeNode<Integer>> nodes = TreeHelper.createTreeNodes(new Integer[] {5,3,10,20,21,1});
        nodes.get(0).setLeft(nodes.get(1));
        nodes.get(0).setRight(nodes.get(2));
        nodes.get(1).setLeft(nodes.get(3));
        nodes.get(1).setRight(nodes.get(4));
        nodes.get(2).setLeft(nodes.get(5));

        int count = aggregator.aggregate(nodes.get(0));
        assertEquals(4, count);
    }

    @ParameterizedTest
    @MethodSource("provideAggregators")
    void testCountVisibleWithNegatives(final Aggregator<Integer, Integer> aggregator) {
        List<TreeNode<Integer>> nodes = TreeHelper.createTreeNodes(new Integer[] {-1, -2, -3});
        nodes.get(0).setRight(nodes.get(1));
        nodes.get(1).setRight(nodes.get(2));

        int count = aggregator.aggregate(nodes.get(0));
        assertEquals(1, count);
    }

}
