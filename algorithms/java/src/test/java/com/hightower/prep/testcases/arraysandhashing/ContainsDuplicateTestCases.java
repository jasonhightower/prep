package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public final class ContainsDuplicateTestCases implements CodingProblem {

    private static final String CONTAINS_DUPLICATE = "ContainsDuplicate";

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>(CONTAINS_DUPLICATE, "Case 1", new int[] {1,2,3,1}, true),
                new TestCase<>(CONTAINS_DUPLICATE, "Case 2", new int[] {1,2,3,4}, false),
                new TestCase<>(CONTAINS_DUPLICATE, "Case 3", new int[] {1,1,1,3,3,4,3,2,4,2}, true)
        );
    }
}
