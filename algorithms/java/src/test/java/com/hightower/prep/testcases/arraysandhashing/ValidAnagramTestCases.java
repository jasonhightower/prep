package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class ValidAnagramTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("ValidAnagram", "Case 1", "anagram", "nagaram", true),
                new BiInputTestCase<>("ValidAnagram", "Case 2", "rat", "car", false)
        );
    }
}
