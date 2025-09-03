package com.hightower.prep.testcases.linkedlist;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class ReorderListProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("ReorderList", "Case 1", LinkedNode.of(2,4,6,8), LinkedNode.of(2,8,4,6)),
                new TestCase<>("ReorderList", "Case 2", LinkedNode.of(2,4,6,8,10), LinkedNode.of(2,10,4,8,6)),
                new TestCase<>("ReorderList", "Case 3", LinkedNode.of(0,1,2,3,4,5,6), LinkedNode.of(0,6,1,5,2,4,3))
        );
    }

}
