package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class LongestConsecutiveSequenceTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>(
                        "LongestConsecutiveSequence",
                        "Case 1",
                        new int[] {100,4,200,1,3,2},
                        4
                ),
                new TestCase<>(
                        "LongestConsecutiveSequence",
                        "Case 2",
                        new int[] {0,3,7,2,5,8,4,6,0,1},
                        9
                ),
                new TestCase<>(
                        "LongestConsecutiveSequence",
                        "Case 3",
                        new int[] {1,0,1,2},
                        3
                )
        );
    }
}
