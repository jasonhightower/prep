package com.hightower.prep.testcases.linkedlist;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class ReverseLinkedListProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("ReverseLinkedList", "Case 1", LinkedNode.of(0,1,2,3), LinkedNode.of(3,2,1,0)),
                new TestCase<>("ReverseLinkedList", "Case 2", LinkedNode.of(1), LinkedNode.of(1))
        );
    }

}
