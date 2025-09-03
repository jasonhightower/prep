package com.hightower.prep.dailypractice;

import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.stack.CarFleetProblem;
import com.hightower.prep.testcases.stack.LargestRectangleInHistogramProblem;
import org.junit.jupiter.api.BeforeEach;

public class Day4Test {

    private Day4 classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new Day4();
    }

    @Solution(CarFleetProblem.class)
    public void carFleet(BiInputTestCase<int[][], Integer, Integer> testCase) {
        testCase.run(this.classUnderTest::carFleet);
    }

    @Solution(LargestRectangleInHistogramProblem.class)
    public void largestRectangleInHistogram(TestCase<int[], Integer> testCase) {
       testCase.run(this.classUnderTest::largestRectangleInHistogram);
    }

}
