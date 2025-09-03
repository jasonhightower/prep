package com.hightower.prep.testcases.slidingwindow;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class MinimumWindowSubstringProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("MinimumWindowSubstring", "Case 1", "OUZODYXAZV", "XYZ", "YXAZ"),
                new BiInputTestCase<>("MinimumWindowSubstring", "Case 2", "xyz", "xyz", "xyz")
        );
    }

}
