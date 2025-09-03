package com.hightower.prep.dailypractice;

import com.hightower.prep.core.TimeMap;
import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.ImplementationTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.binarysearch.*;
import org.junit.jupiter.api.BeforeEach;

public class Day5Test {

    private Day5 classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new Day5();
    }

    @Solution(BinarySearchProblem.class)
    public void binarySearch(final BiInputTestCase<int[], Integer, Integer> testCase) {
        testCase.run(this.classUnderTest::binarySearch);
    }

    @Solution(KokoEatingBananasProblem.class)
    public void kokoEatingBananas(final BiInputTestCase<int[], Integer, Integer> testCase) {
        testCase.run(this.classUnderTest::kokoEatingBananas);
    }

    @Solution(Search2DMatrixProblem.class)
    public void search2DMatrix(final BiInputTestCase<int[][], Integer, Boolean> testCase) {
        testCase.run(this.classUnderTest::search2DMatrix);
    }

    @Solution(FindMinimumInRotatedSortedArrayProblem.class)
    public void findMinimumInRotatedSortedArray(final TestCase<int[], Integer> testCase) {
        testCase.run(this.classUnderTest::findMinimumInRotatedSortedArray);
    }

    @Solution(SearchInRotatedSortedArrayProblem.class)
    public void searchInRotatedSortedArray(final BiInputTestCase<int[], Integer, Integer> testCase) {
        testCase.run(this.classUnderTest::searchInRotatedSortedArray);
    }

    @Solution(TimeBasedKeyValueStoreProblem.class)
    public void timeBasedKeyValueStore(final ImplementationTestCase<TimeMap> testCase) {
        testCase.run(this.classUnderTest::timeBasedKeyValueStore);
    }

    @Solution(MedianOfTwoSortedArraysProblem.class)
    public void medianTwoSortedArrays(final BiInputTestCase<int[], int[], Double> testCase) {
        testCase.run(this.classUnderTest::medianTwoSortedArrays);
    }

}
