package com.hightower.prep.testcases.slidingwindow;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class LongestSubstringWithoutRepeatingProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("LongestSubstringWithoutRepeating", "Case 1", "zxyzxyz", 3),
                new TestCase<>("LongestSubstringWithoutRepeating", "Case 2", "xxxx", 1)
        );
    }

}
