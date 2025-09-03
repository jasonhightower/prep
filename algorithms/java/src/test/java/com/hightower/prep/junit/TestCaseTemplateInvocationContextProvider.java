package com.hightower.prep.junit;

import com.hightower.prep.testcases.CodingProblem;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.stream.Stream;

public class TestCaseTemplateInvocationContextProvider implements TestTemplateInvocationContextProvider {

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        Optional<AnnotatedElement> annotatedElement = context.getElement();
        if (annotatedElement.isPresent()) {
            final AnnotatedElement element = annotatedElement.get();
            return element.isAnnotationPresent(Solution.class);
        }
        return false;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        Solution solution = context.getElement().get().getDeclaredAnnotation(Solution.class);
        Class<? extends CodingProblem> providerClass = solution.value();
        try {
            Constructor<? extends CodingProblem> constructor = providerClass.getDeclaredConstructor();
            CodingProblem provider = constructor.newInstance();
            return provider.provideTestCases().map(TestCaseTestTemplateInvocationContext::contextOf);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
