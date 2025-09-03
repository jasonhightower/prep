package com.hightower.prep.testcases.stack;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class ValidParenthesisProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("ValidParenthesis", "Case 1", "()", true),
                new TestCase<>("ValidParenthesis", "Case 2", "()[]{}", true),
                new TestCase<>("ValidParenthesis", "Case 3", "(]", false),
                new TestCase<>("ValidParenthesis", "Case 4", "([])", true),
                new TestCase<>("ValidParenthesis", "Case 5", "([)]", false),
                new TestCase<>("ValidParenthesis", "Case 6", "((", false),
                new TestCase<>("ValidParenthesis", "Case 7", "()]", false)
        );
    }

}
