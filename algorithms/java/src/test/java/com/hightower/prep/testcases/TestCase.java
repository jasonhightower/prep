package com.hightower.prep.testcases;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase<T, R> extends AbstractTestCase {

    private final String type;
    private final T input;
    private final R expected;
    private final boolean matchOrder;

    public TestCase(final String type,
                    final String testName,
                    final T input,
                    final R expected) {
        this(type, testName, input, expected, true);
    }

    public TestCase(final String type,
                    final String testName,
                    final T input,
                    final R expected,
                    final boolean matchOrder) {
       super(String.format("%s - %s", type, testName));
       this.type = type;
       this.input = input;
       this.expected = expected;
       this.matchOrder = matchOrder;
    }

    public String getType() {
        return this.type;
    }

    public void run(final Function<T, R> algo) {
        R actual = algo.apply(this.input);
        if (!this.matchOrder) {
            sort(actual);
        }
        if (this.expected.getClass().isArray()) {
            assertEquals(Array.getLength(this.expected), Array.getLength(actual));
            for (int i = 0; i < Array.getLength(this.expected); i++) {
                assertEquals(
                        Array.get(this.expected, i),
                        Array.get(actual, i),
                        String.format("Expected %s, got %s for input %s",
                                expected,
                                actual,
                                this.input.toString()));
            }
        } else {
            assertEquals(
                    this.expected,
                    actual,
                    // JH - using a supplier here is important because some values include cyclic
                    //      datastructures which break in a toString call (todo JH - fix LinkedNode to detect that)
                    () -> String.format("Expected %s, got %s for input %s",
                            expected,
                            actual,
                            this.input.toString()));
        }
    }

    // this is a bit hacky, need to figure out a better way to handle list comparison which does not take into account ordering
    private void sort(Object o) {
        if (o instanceof List) {
            List list = (List)o;
            list.sort((o1, o2) -> {
                if (o1 instanceof List) {
                    return Integer.compare(((List<?>) o1).size(), ((List<?>) o2).size());
                } else if (o1 instanceof Comparable) {
                    return ((Comparable)o1).compareTo(o2);
                } else {
                    return 0;
                }
            });
            for (Object obj : list) {
                sort(obj);
            }
        }
    }


}
