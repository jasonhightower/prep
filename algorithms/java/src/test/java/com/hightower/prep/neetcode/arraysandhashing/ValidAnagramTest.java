package com.hightower.prep.neetcode.arraysandhashing;

import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.arraysandhashing.ValidAnagramTestCases;

public class ValidAnagramTest {

    public boolean validAnagram(final String first, final String second) {
        return false;
    }


    @Solution(ValidAnagramTestCases.class)
    public void containsDuplicateTest(BiInputTestCase<String, String, Boolean> testCase) {
        testCase.run(this::validAnagram);
    }
}
