package com.hightower.prep.dailypractice;

import com.hightower.prep.core.MinStack;
import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.ImplementationTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.stack.EvaluateReversePolishNotation;
import com.hightower.prep.testcases.stack.MinStackProblem;
import com.hightower.prep.testcases.stack.ValidParenthesisProblem;
import com.hightower.prep.testcases.twopointers.ContainerWithMostWaterProblem;
import com.hightower.prep.testcases.twopointers.ThreeSumTestCases;
import com.hightower.prep.testcases.twopointers.TrappingRainWaterProblem;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class Day2Test {

    private Day2 classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new Day2();
    }

    @Solution(ThreeSumTestCases.class)
    public void threeSum(final TestCase<int[], List<List<Integer>>> testCase) {
        testCase.run(this.classUnderTest::threeSum);
    }

    @Solution(ContainerWithMostWaterProblem.class)
    public void containerWithMostWater(final TestCase<int[], Integer> testCase) {
        testCase.run(this.classUnderTest::containerWithMostWater);
    }

    @Solution(TrappingRainWaterProblem.class)
    public void trappingRainWater(final TestCase<int[], Integer> testCase) {
        testCase.run(this.classUnderTest::trappingRainWater);
    }

    @Solution(ValidParenthesisProblem.class)
    public void validParenthesis(final TestCase<String, Boolean> testCase) {
        testCase.run(this.classUnderTest::validParenthesis);
    }

    @Solution(MinStackProblem.class)
    public void minStack(final ImplementationTestCase<MinStack> testCase) {
        testCase.run(this.classUnderTest::minStack);
    }

    @Solution(EvaluateReversePolishNotation.class)
    public void reversePolishNotation(final TestCase<String[], Integer> testCase) {
        testCase.run(this.classUnderTest::reversePolishNotation);
    }

}
