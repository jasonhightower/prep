package com.hightower.prep.testcases.linkedlist;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.core.LinkedNodeWRandom;
import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class CopyListWithRandomPointerProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("CopyListWithRandomPointerProblem", "Case 1",
                        LinkedNodeWRandom.of(
                                3, null,
                                7, 3,
                                4, 0,
                                5, 1
                        ),
                        LinkedNodeWRandom.of(
                                3, null,
                                7, 3,
                                4, 0,
                                5, 1
                        )),
                new TestCase<>("CopyListWithRandomPointerProblem", "Case 2",
                        LinkedNodeWRandom.of(
                                1, null,
                                2,2,
                                3,2
                        ),
                        LinkedNodeWRandom.of(
                                1, null,
                                2,2,
                                3,2
                        ))
        );
    }

}
