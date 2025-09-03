package com.hightower.prep.junit;

import com.hightower.prep.testcases.AbstractTestCase;
import org.junit.jupiter.api.extension.*;

import java.util.List;


public class TestCaseTestTemplateInvocationContext implements TestTemplateInvocationContext {

    public static TestCaseTestTemplateInvocationContext contextOf(AbstractTestCase testCase) {
        return new TestCaseTestTemplateInvocationContext(testCase);
    }

    public AbstractTestCase testCase;

    public TestCaseTestTemplateInvocationContext(final AbstractTestCase testCase) {
        this.testCase = testCase;
    }

    @Override
    public String getDisplayName(int invocationIndex) {
        return testCase.getDisplayName();
    }

    @Override
    public List<Extension> getAdditionalExtensions() {
        return List.of(
                new ParameterResolver() {
                    @Override
                    public boolean supportsParameter(final ParameterContext parameterContext,
                                                     final ExtensionContext extensionContext) throws ParameterResolutionException {
                        // TODO JH do better
                        return AbstractTestCase.class.isAssignableFrom(parameterContext.getParameter().getType());
                    }

                    @Override
                    public Object resolveParameter(final ParameterContext parameterContext,
                                                   final ExtensionContext extensionContext) throws ParameterResolutionException {
                        return testCase;
                    }
                }
        );
    }


}
