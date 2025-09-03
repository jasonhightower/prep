package com.hightower.prep.testcases.slidingwindow;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class LongestRepeatingCharacterReplacementProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("LongestRepeatingCharacterReplacement", "Case 1", "XYYX", 2, 4),
                new BiInputTestCase<>("LongestRepeatingCharacterReplacement", "Case 2", "AAABABB", 1, 5)
        );
    }

}
