package com.hightower.prep.dailypractice;

import com.hightower.prep.junit.Solution;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.stack.DailyTemperaturesProblem;
import com.hightower.prep.testcases.stack.GenerateParenthesisProblem;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class Day3Test {

    private Day3 classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new Day3();
    }

    @Solution(GenerateParenthesisProblem.class)
    public void generateParenthesis(final TestCase<Integer, List<String>> testCase) {
        testCase.run(this.classUnderTest::generateParenthesis);
    }

    @Solution(DailyTemperaturesProblem.class)
    public void dailyTemperatures_Stack(final TestCase<int[], int[]> testCase) {
        testCase.run(this.classUnderTest::dailyTemperatures_Stack);
    }

    @Solution(DailyTemperaturesProblem.class)
    public void dailyTemperatures_DynamicProgramming(final TestCase<int[], int[]> testCase) {
        testCase.run(this.classUnderTest::dailyTemperatures_DynamicProgramming);
    }

}
