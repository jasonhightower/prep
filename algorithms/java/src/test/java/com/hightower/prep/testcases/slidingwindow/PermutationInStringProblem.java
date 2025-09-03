package com.hightower.prep.testcases.slidingwindow;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class PermutationInStringProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("PermutationInString", "Case 1", "abc", "lecabee", true),
                new BiInputTestCase<>("PermutationInString", "Case 2", "abc", "lecaabee", false)
        );
    }

}
