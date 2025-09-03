package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.List;
import java.util.stream.Stream;

public class GroupAnagramsTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("GroupAnagrams", "Case 1",
                        new String[] {"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(List.of("bat"),
                                List.of("nat", "tan"),
                                List.of("ate", "eat", "tea")),
                        false),
                new TestCase<>("GroupAnagrams", "Case 2",
                        new String[] {""},
                        List.of(List.of("")),
                        false),
                new TestCase<>("GroupAnagrams", "Case 3",
                        new String[] {"a"},
                        List.of(List.of("a")),
                        false)
        );
    }
}
