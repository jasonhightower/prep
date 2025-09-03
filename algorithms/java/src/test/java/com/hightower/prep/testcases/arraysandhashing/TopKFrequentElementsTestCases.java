package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class TopKFrequentElementsTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>(
                        "TopKFrequentElements",
                        "Case 1",
                        new int[] {1,1,1,2,2,3},
                        2,
                        new int[]{1,2}),
                new BiInputTestCase<>(
                        "TopKFrequentElements",
                        "Case 2",
                        new int[] {1},
                        1,
                        new int[]{1}),
                new BiInputTestCase<>(
                        "TopKFrequentElements",
                        "Case 3",
                        new int[] {12,1,2,1,2,3,1,3,2},
                        2,
                        new int[]{1,2})
        );
    }

}
