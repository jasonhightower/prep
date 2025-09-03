package com.hightower.prep.testcases.slidingwindow;

import com.hightower.prep.testcases.AbstractTestCase;
import com.hightower.prep.testcases.CodingProblem;
import com.hightower.prep.testcases.TestCase;

import java.util.stream.Stream;

public class BestTimeToBuySellStockProblem implements CodingProblem {

    @Override
    public Stream<AbstractTestCase> provideTestCases() {
        return Stream.of(
                new TestCase<>("BestTimeToBuySellStockProblem", "Case 1", new int[] {10,1,5,6,7,1}, 6),
                new TestCase<>("BestTimeToBuySellStockProblem", "Case 2", new int[] {10,8,7,5,2}, 0)
        );
    }

}
