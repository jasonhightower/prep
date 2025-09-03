package com.hightower.prep.testcases.binarysearch;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class MedianOfTwoSortedArraysProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
            new BiInputTestCase<>("MedianOfTwoSortedArraysProblem", "Case 1", new int[] {1,2}, new int[] {3}, 2.0d),
            new BiInputTestCase<>("MedianOfTwoSortedArraysProblem", "Case 2", new int[] {1,3}, new int[] {2,4}, 2.5d)
        );
    }
}
