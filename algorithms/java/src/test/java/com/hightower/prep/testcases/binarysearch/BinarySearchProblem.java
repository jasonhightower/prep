package com.hightower.prep.testcases.binarysearch;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class BinarySearchProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("BinarySearch", "Case 1", new int[] {-1,0,2,4,6,8}, 4, 3),
                new BiInputTestCase<>("BinarySearch", "Case 2", new int[] {-1,0,2,4,6,8}, 3, -1)
        );
    }
}
