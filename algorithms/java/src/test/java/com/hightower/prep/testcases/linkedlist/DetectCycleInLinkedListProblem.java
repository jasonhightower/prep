package com.hightower.prep.testcases.linkedlist;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class DetectCycleInLinkedListProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        final LinkedNode<Integer> cyclicList = LinkedNode.of(1,2,3,4);
        final LinkedNode<Integer> n4 = cyclicList.find(4).get();
        n4.next = cyclicList.find(2).get();

        return Stream.of(
                new TestCase<>("DetectCycleInLinkedList", "Case 1", cyclicList, true),
                new TestCase<>("DetectCycleInLinkedList", "Case 2", LinkedNode.of(1,2), false)
        );
    }
}
