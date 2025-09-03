package com.hightower.prep.neetcode.arraysandhashing;

import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.arraysandhashing.ContainsDuplicateTestCases;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateTest  {

    protected boolean containsDuplicate(int[] input) {
        Set<Integer> seen = new HashSet<>();
        for (int num : input) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    @Solution(ContainsDuplicateTestCases.class)
    public void containsDuplicateTest(TestCase<int[], Boolean> testCase) {
        testCase.run(this::containsDuplicate);
    }

}
