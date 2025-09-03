package com.hightower.prep.testcases.binarysearch;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class FindMinimumInRotatedSortedArrayProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("FindMinimumInRotatedSortedArray", "Case 1", new int[]{3,4,5,6,1,2}, 1),
                new TestCase<>("FindMinimumInRotatedSortedArray", "Case 2", new int[]{4,5,0,1,2,3}, 0)
        );
    }

}
