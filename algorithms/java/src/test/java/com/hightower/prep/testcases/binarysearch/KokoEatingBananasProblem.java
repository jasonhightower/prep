package com.hightower.prep.testcases.binarysearch;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class KokoEatingBananasProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("KokoEatingBananas", "Case 1", new int[] {3,6,7,11}, 8, 4),
                new BiInputTestCase<>("KokoEatingBananas", "Case 2", new int[] {30,11,23,4,20}, 5, 30),
                new BiInputTestCase<>("KokoEatingBananas", "Case 3", new int[] {30,11,23,4,20}, 6, 23)
        );
    }

}
