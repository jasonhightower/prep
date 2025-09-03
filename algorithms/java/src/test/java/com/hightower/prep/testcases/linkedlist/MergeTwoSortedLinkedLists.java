package com.hightower.prep.testcases.linkedlist;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class MergeTwoSortedLinkedLists implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase("MergeTwoSortedLinkedLists", "Case 1",
                        LinkedNode.of(1,2,4),
                        LinkedNode.of(1,3,5),
                        LinkedNode.of(1,1,2,3,4,5)),
                new BiInputTestCase("MergeTwoSortedLinkedLists", "Case 2",
                        LinkedNode.of(),
                        LinkedNode.of(1,2),
                        LinkedNode.of(1,2)),
                new BiInputTestCase("MergeTwoSortedLinkedLists", "Case 3",
                        LinkedNode.of(),
                        LinkedNode.of(),
                        LinkedNode.of())
        );
    }

}
