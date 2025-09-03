package com.hightower.prep.testcases.binarysearch;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class Search2DMatrixProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("Search2DMatrix", "Case 1", new int[][] {{1,2,4,8}, {10,11,12,13}, {14,20,30,40}}, 10, true),
                new BiInputTestCase<>("Search2DMatrix", "Case 2", new int[][] {{1,2,4,8}, {10,11,12,13}, {14,20,30,40}}, 15, false)
        );
    }

}
