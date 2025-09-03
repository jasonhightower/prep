package com.hightower.prep.testcases.binarysearch;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.BiInputTestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class SearchInRotatedSortedArrayProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new BiInputTestCase<>("SearchInRotatedSortedArray", "Case 1", new int[] {3,4,5,6,1,2}, 1, 4),
                new BiInputTestCase<>("SearchInRotatedSortedArray", "Case 2", new int[] {3,5,6,0,1,2}, 4, -1),
                new BiInputTestCase<>("SearchInRotatedSortedArray", "Case 3", new int[] {6,1,2,3,4,5}, 5, 5),
                new BiInputTestCase<>("SearchInRotatedSortedArray", "Case 3", new int[] {6,1,2,3,4,5}, 6, 0)
        );
    }

}
