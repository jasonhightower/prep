package com.hightower.prep.testcases.stack;

import com.hightower.prep.core.MinStack;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.ImplementationTestCase;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinStackProblem implements CodingProblem {

    // TODO JH will need to figure out how to externalize this
    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new ImplementationTestCase<>("MinStack",
                        (MinStack t) -> {
                            t.push(-2);
                            t.push(0);
                            t.push(-3);
                            assertEquals(-3, t.min());
                            t.pop();
                            assertEquals(0, t.top());
                            assertEquals(-2, t.min());
                        })
        );
    }
}
