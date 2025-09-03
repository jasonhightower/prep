package com.hightower.prep.testcases.arraysandhashing;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.TestCase;
import com.hightower.prep.testcases.CodingProblem;

import java.util.stream.Stream;

public class ValidSudokuTestCases implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(new TestCase<Integer[][], Boolean>("ValidSudoku", "Case 1", new Integer[][] {
                    {   5,    3, null, null,    7, null, null, null, null},
                    {   6, null, null,    1,    9,    5, null, null, null},
                    {null,    9,    8, null, null, null, null,    6, null},
                    {   8, null, null, null,    6, null, null, null,    3},
                    {   4, null, null,    8, null,    3, null, null,    1},
                    {   7, null, null, null,    2, null, null, null,    6},
                    {null,    6, null, null, null, null,    2,    8, null},
                    {null, null, null,    4,    1,    9, null, null,    5},
                    {null, null, null, null,    8, null, null,    7,    9}
                },
                true));
    }
}
