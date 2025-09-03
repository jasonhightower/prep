package com.hightower.prep.dailypractice;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.core.LinkedNodeWRandom;
import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.linkedlist.CopyListWithRandomPointerProblem;
import com.hightower.prep.testcases.linkedlist.RemoveNthNodeFromEndProblem;
import com.hightower.prep.testcases.linkedlist.ReorderListProblem;
import org.junit.jupiter.api.BeforeEach;

public class Day7Test {

    private Day7 classUnderTest;

    @BeforeEach
    void setUp() {
       this.classUnderTest = new Day7();
    }

    @Solution(ReorderListProblem.class)
    public void reorderList(TestCase<LinkedNode<Integer>, LinkedNode<Integer>> testCase) {
        testCase.run(this.classUnderTest::reorderList);
    }

    @Solution(RemoveNthNodeFromEndProblem.class)
    public void removeNthNode(BiInputTestCase<LinkedNode<Integer>, Integer, LinkedNode<Integer>> testCase) {
        testCase.run(this.classUnderTest::removeNthNode);
    }

    @Solution(CopyListWithRandomPointerProblem.class)
    public void copyListWithRandom(TestCase<LinkedNodeWRandom<Integer>, LinkedNodeWRandom<Integer>> testCase) {
        testCase.run(this.classUnderTest::copyListWithRandom);
    }

}
