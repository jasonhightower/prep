package com.hightower.prep.testcases;

import java.util.stream.Stream;

// TODO JH maybe instead this interface should be CodingProblem which contains test cases but may also contain
// things like hints, etc. then test case/problem execution can be decoupled and better support externally
// provided implementations
public interface CodingProblem {

    Stream<AbstractTestCase> provideTestCases();

}
