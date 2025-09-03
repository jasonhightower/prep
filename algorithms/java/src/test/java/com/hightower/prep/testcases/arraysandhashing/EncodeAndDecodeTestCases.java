package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class EncodeAndDecodeTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("EncodeAndDecode", "Case 1",
                        new String[] {"neet", "code", "love", "you"},
                        new String[] {"neet", "code", "love", "you"}),
                new TestCase<>("EncodeAndDecode", "Case 2",
                        new String[] {"we", "say", ":", "yes"},
                        new String[] {"we", "say", ":", "yes"}),
                new TestCase<>("EncodeAndDecode", "Case 3",
                        new String[] {"abcdefghijklmno", "pqrstuv"},
                        new String[] {"abcdefghijklmno", "pqrstuv"})
        );
    }
}
