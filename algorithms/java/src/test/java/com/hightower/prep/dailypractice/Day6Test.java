package com.hightower.prep.dailypractice;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.linkedlist.DetectCycleInLinkedListProblem;
import com.hightower.prep.testcases.linkedlist.MergeTwoSortedLinkedLists;
import com.hightower.prep.testcases.linkedlist.ReverseLinkedListProblem;
import com.hightower.prep.testcases.slidingwindow.*;
import org.junit.jupiter.api.BeforeEach;

public class Day6Test {

    private Day6 classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new Day6();
    }

    @Solution(BestTimeToBuySellStockProblem.class)
    public void bestTimeToBuySellStock(TestCase<int[], Integer> testCase) {
        testCase.run(this.classUnderTest::bestTimeToBuySellStock);
    }

    @Solution(LongestSubstringWithoutRepeatingProblem.class)
    public void longestSubstringWithoutRepeating(TestCase<String, Integer> testCase) {
        testCase.run(this.classUnderTest::longestSubstringWithoutRepeating);
    }

    @Solution(LongestRepeatingCharacterReplacementProblem.class)
    public void longestRepeatingCharacterReplacement(BiInputTestCase<String, Integer, Integer> testCase) {
        testCase.run(this.classUnderTest::longestRepeatingCharacterReplacement);
    }

    @Solution(PermutationInStringProblem.class)
    public void permutationInString(BiInputTestCase<String, String, Boolean> testCase) {
        testCase.run(this.classUnderTest::permutationInString);
    }

    @Solution(MinimumWindowSubstringProblem.class)
    public void minimumWindowSubstring(BiInputTestCase<String, String, String> testCase) {
        testCase.run(this.classUnderTest::minimumWindowSubstring);
    }

    @Solution(SlidingWindowMaximumProblem.class)
    public void slidingWindowMaximum(BiInputTestCase<int[], Integer, int[]> testCase) {
        testCase.run(this.classUnderTest::slidingWindowMaximum);
    }

    @Solution(ReverseLinkedListProblem.class)
    public void reverseLinkedList(TestCase<LinkedNode<Integer>, LinkedNode<Integer>> testCase) {
        testCase.run(this.classUnderTest::reverseLinkedList);
    }

    @Solution(MergeTwoSortedLinkedLists.class)
    public void mergeTwoSortedLinkedLists(BiInputTestCase<LinkedNode<Integer>, LinkedNode<Integer>, LinkedNode<Integer>> testCase) {
        testCase.run(this.classUnderTest::mergeTwoSortedLinkedLists);
    }

    @Solution(DetectCycleInLinkedListProblem.class)
    public void detectCycleInLinkedList(TestCase<LinkedNode<?>, Boolean> testCase) {
        testCase.run(this.classUnderTest::detectCycleInLinkedList);
    }

}
