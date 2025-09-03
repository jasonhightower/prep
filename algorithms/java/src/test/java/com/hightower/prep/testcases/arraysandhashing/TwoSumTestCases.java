package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import java.util.stream.Stream;

import static com.hightower.prep.junit.TestCaseTestTemplateInvocationContext.contextOf;

public final class TwoSumTestCases implements CodingProblem, TestTemplateInvocationContextProvider {

    private static final String TWO_SUM = "TwoSum";

    @Override
    public boolean supportsTestTemplate(final ExtensionContext context) {
        return true;
    }

    // TODO JH separate junit infrastructure from test case generation/handling
    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        // TODO - externalize this somehow
        return Stream.of(
                contextOf(new BiInputTestCase<>(TWO_SUM, "Case 1", new int[] {2,7,11,15}, 9, new int[] {0,1})),
                contextOf(new BiInputTestCase<>(TWO_SUM, "Case 2", new int[] {3,2,4}, 6, new int[] {1,2})),
                contextOf(new BiInputTestCase<>(TWO_SUM, "Case 3", new int[] {3,3}, 6, new int[] {0,1}))
        );
    }

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>(TWO_SUM, "Case 1", new int[] {2,7,11,15}, 9, new int[] {0,1}),
                new BiInputTestCase<>(TWO_SUM, "Case 2", new int[] {3,2,4}, 6, new int[] {1,2}),
                new BiInputTestCase<>(TWO_SUM, "Case 3", new int[] {3,3}, 6, new int[] {0,1})
        );
    }
}
