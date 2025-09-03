package com.hightower.prep.testcases.twopointers;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class ContainerWithMostWaterProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<int[], Integer>("ContainerWithMostWater", "Case 1", new int[] {1,7,2,5,4,7,3,6}, 36),
                new TestCase<int[], Integer>("ContainerWithMostWater", "Case 2", new int[] {2,2,2}, 4)
        );
    }
}
