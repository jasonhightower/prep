package com.hightower.prep.trees.binary.dfs;

import com.hightower.prep.trees.binary.CountGoodNodes;
import com.hightower.prep.trees.binary.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGoodNodesTest {

    private CountGoodNodes classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new CountGoodNodes();
    }

    @Test
    public void testCase1() {
        TreeNode<Integer> root = TreeNode.fromArray(new Integer[] {3,1,3,4,3,null,1,5});
        int result = this.classUnderTest.count(root);
        assertEquals(4, result);
    }

}
