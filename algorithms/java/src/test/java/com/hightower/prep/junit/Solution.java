package com.hightower.prep.junit;

import com.hightower.prep.testcases.CodingProblem;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD} )
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(TestCaseTemplateInvocationContextProvider.class)
@TestTemplate
public @interface Solution {

    Class<? extends CodingProblem> value();

}
