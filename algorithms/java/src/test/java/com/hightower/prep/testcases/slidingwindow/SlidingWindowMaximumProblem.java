package com.hightower.prep.testcases.slidingwindow;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class SlidingWindowMaximumProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("SlidingWindowMaximum", "Case 1", new int[] {1,2,1,0,4,2,6}, 3, new int[] {2,2,4,4,6})
        );
    }

}
