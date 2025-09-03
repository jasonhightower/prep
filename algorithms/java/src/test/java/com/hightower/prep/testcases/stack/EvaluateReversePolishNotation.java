package com.hightower.prep.testcases.stack;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class EvaluateReversePolishNotation implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("ReversePolishNotation", "Case 1", new String[]{"1", "2", "+", "3", "*", "4", "-"}, 5)
        );
    }
}
