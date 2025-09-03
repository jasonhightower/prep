package com.hightower.prep.testcases.stack;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class CarFleetProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("Car Fleet Problem", "Case 1", new int[][] {{1,4}, {3,2}}, 10, 1),
                new BiInputTestCase<>("Car Fleet Problem", "Case 2", new int[][] {{4,1,0,7}, {2,2,1,1}}, 10, 3)
        );
    }
}
