package com.hightower.prep.testcases.twopointers;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.List;
import java.util.stream.Stream;

public class ThreeSumTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("3Sum", "Case 1", new int[] {-1,0,1,2,-1,4}, List.of(List.of(-1,-1,2), List.of(-1,0,1))),
                new TestCase<>("3Sum", "Case 2", new int[] {0,1,1}, List.of()),
                new TestCase<>("3Sum", "Case 3", new int[] {0,0,0}, List.of(List.of(0,0,0)))
        );
    }

}
