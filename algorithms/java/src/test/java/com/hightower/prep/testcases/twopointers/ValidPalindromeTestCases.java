package com.hightower.prep.testcases.twopointers;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class ValidPalindromeTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("ValidPalindrome", "Case 1", "A man, a plan, a canal: Panama", true),
                new TestCase<>("ValidPalindrome", "Case 2", "race a car", false),
                new TestCase<>("ValidPalindrome", "Case 3", " ", true)
        );
    }
}
