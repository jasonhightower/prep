package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class ProductExceptSelfTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("ProductExceptSelf", "Case 1", new int[] {1,2,3,4}, new int[] {24,12,8,6}),
                new TestCase<>("ProductExceptSelf", "Case 2", new int[] {-1,1,0,-3,3}, new int[] {0,0,9,0,0})
        );
    }
}
