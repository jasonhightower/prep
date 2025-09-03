package com.hightower.prep.testcases.stack;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class LargestRectangleInHistogramProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("LargestRectangleInHistogram", "Case 1",
                        new int[] {7,1,7,2,2,4}, 8),
                new TestCase<>("LargestRectangleInHistogram", "Case 2",
                        new int[] {1,3,7}, 7)
        );
    }
}
