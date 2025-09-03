package com.hightower.prep.dailypractice;

import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.arraysandhashing.*;
import com.hightower.prep.testcases.twopointers.TwoSumSortedTestCases;
import com.hightower.prep.testcases.twopointers.ValidPalindromeTestCases;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class Day1Test {

    private Day1 classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new Day1();
    }

    @Solution(ValidAnagramTestCases.class)
    public void validAnagramTest(BiInputTestCase<String, String, Boolean> testCase) {
        testCase.run(this.classUnderTest::validAnagram);
    }

    @Solution(ContainsDuplicateTestCases.class)
    public void containsDuplicateTest(TestCase<int[], Boolean> testCase) {
        testCase.run(this.classUnderTest::containsDuplicate);
    }

    @Solution(TwoSumTestCases.class)
    public void twoSumTest(BiInputTestCase<int[], Integer, int[]> testCase) {
        testCase.run(this.classUnderTest::twoSum);
    }

    @Solution(GroupAnagramsTestCases.class)
    public void groupAnagrams(TestCase<String[], List<List<String>>> testCase) {
        testCase.run(this.classUnderTest::groupAnagrams);
    }

    @Solution(TopKFrequentElementsTestCases.class)
    public void topKFrequentElements(BiInputTestCase<int[], Integer, int[]> testCase) {
        testCase.run(this.classUnderTest::topKFrequentElements);
    }

    @Solution(ProductExceptSelfTestCases.class)
    public void productExceptSelf(TestCase<int[], int[]> testCase) {
        testCase.run(this.classUnderTest::productExceptSelf);
    }

    @Solution(ValidSudokuTestCases.class)
    public void validSudoku(TestCase<Integer[][], Boolean> testCase) {
        testCase.run(this.classUnderTest::validSudoku);
    }

    @Solution(LongestConsecutiveSequenceTestCases.class)
    public void longestConsecutiveSequence(TestCase<int[], Integer> testCase) {
        testCase.run(this.classUnderTest::longestConsecutiveSequence);
    }

    @Solution(EncodeAndDecodeTestCases.class)
    public void encodeAndDecode(TestCase<String[], String[]> testCase) {
        testCase.run(this.classUnderTest::encodeAndDecode);
    }

    @Solution(ValidPalindromeTestCases.class)
    public void validPalindrome(TestCase<String, Boolean> testCase) {
        testCase.run(this.classUnderTest::validPalindrome);
    }

    @Solution(TwoSumSortedTestCases.class)
    public void twoSumSorted(BiInputTestCase<int[], Integer, int[]> testCase) {
        testCase.run(this.classUnderTest::twoSumSorted);
    }

}
