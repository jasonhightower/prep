package com.hightower.prep.testcases.stack;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.List;
import java.util.stream.Stream;

public class GenerateParenthesisProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("GenerateParenthesis", "Case 1",
                        1,
                        List.of("()")),
                new TestCase<>("GenerateParenthesis", "Case 2",
                        3,
                        List.of("((()))", "(()())", "(())()", "()(())", "()()()"))
        );
    }

}
