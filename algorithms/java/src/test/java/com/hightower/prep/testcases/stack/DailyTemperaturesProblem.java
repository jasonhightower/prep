package com.hightower.prep.testcases.stack;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class DailyTemperaturesProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("DailyTemperatures", "Case 1", new int[] {30,38,30,36,35,40,28}, new int[] {1,4,1,2,1,0,0}),
                new TestCase<>("DailyTemperatures", "Case 2", new int[] {22,21,20}, new int[] {0,0,0})
        );
    }
}
