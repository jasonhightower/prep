package com.hightower.prep.testcases.twopointers;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class TrappingRainWaterProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("TrappingRainWater", "Case 1", new int[] {0,2,0,3,1,0,1,3,2,1}, 9)
        );
    }

}
