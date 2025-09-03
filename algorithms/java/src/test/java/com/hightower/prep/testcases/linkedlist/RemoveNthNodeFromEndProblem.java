package com.hightower.prep.testcases.linkedlist;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class RemoveNthNodeFromEndProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("Remove Nth Node From End", "Case 1", LinkedNode.of(1,2,3,4), 2, LinkedNode.of(1,2,4)),
                new BiInputTestCase<>("Remove Nth Node From End", "Case 2", LinkedNode.of(5), 1, LinkedNode.of()),
                new BiInputTestCase<>("Remove Nth Node From End", "Case 3", LinkedNode.of(1,2), 2, LinkedNode.of(2))
        );
    }
}
