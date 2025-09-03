package com.hightower.prep.neetcode.arraysandhashing;

import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.arraysandhashing.TwoSumTestCases;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {

    public int[] twoSum(final int[] nums,
                          final int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (seen.containsKey(other)) {
                return new int[] {seen.get(other), i};
            }
            seen.put(nums[i], i);
        }
        return null;
    }

    @Solution(TwoSumTestCases.class)
    public void twoSumTest(BiInputTestCase<int[], Integer, int[]> testCase) {
        testCase.run(this::twoSum);
    }

}
