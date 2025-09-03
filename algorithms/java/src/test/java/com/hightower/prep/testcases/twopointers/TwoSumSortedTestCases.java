package com.hightower.prep.testcases.twopointers;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class TwoSumSortedTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("TwoSumSorted", "Case 1", new int[] {2,7,11,15}, 9, new int[] {1, 2}),
                new BiInputTestCase<>("TwoSumSorted", "Case 2", new int[] {2,3,4}, 6, new int[] {1, 3}),
                new BiInputTestCase<>("TwoSumSorted", "Case 3", new int[] {-1,0}, -1, new int[] {1,2})
        );
    }
}
