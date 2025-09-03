package com.hightower.prep.testcases.binarysearch;

import com.hightower.prep.core.TimeMap;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.ImplementationTestCase;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeBasedKeyValueStoreProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
               new ImplementationTestCase<>("TimeBasedKeyValueStore",
                       (TimeMap m) -> {
                            m.set("alice", "happy", 1);
                            assertEquals("happy", m.get("alice", 1));
                            assertEquals("happy", m.get("alice", 2));
                            m.set("alice", "sad", 3);
                            assertEquals("sad", m.get("alice", 3));
                       })
        );
    }

}
