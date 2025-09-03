package com.hightower.prep.testcases;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class BiInputTestCase<T, U, R> extends AbstractTestCase {

    private final String type;
    private final T first;
    private final U second;
    private final R expected;
    private final boolean matchOrder;

    public BiInputTestCase(final String type,
                    final String testName,
                    final T first,
                    final U second,
                    final R expected) {
        this(type, testName, first, second, expected, true);
    }

    public BiInputTestCase(final String type,
                           final String testName,
                           final T first,
                           final U second,
                           final R expected,
                           final boolean matchOrder) {
        super(String.format("%s - %s", type, testName));
        this.type = type;
        this.first = first;
        this.second = second;
        this.expected = expected;
        this.matchOrder = matchOrder;
        if (!matchOrder) {
            throw new RuntimeException("Unordered matching is not supported yet");
        }
    }

    public String getType() {
        return this.type;
    }

    public void run(final BiFunction<T, U, R> algo) {
        R actual = algo.apply(this.first, this.second);
        if (this.expected == null) {
            assertNull(actual);
            return;
        }
        if (this.expected.getClass().isArray()) {
            // TODO JH need to move this to some sort of helper or find a library to handle it
            int expectedLength = Array.getLength(this.expected);
            int actualLength = Array.getLength(actual);
            assertEquals(expectedLength, actualLength);
            for (int i = 0; i < expectedLength; i++) {
                assertEquals(
                        Array.get(this.expected, i),
                        Array.get(actual, i),
                        String.format("Index %d is not correct", i)
                        );
            }
        } else {
            assertEquals(
                    expected,
                    actual,
                    String.format("Expected %s, got %s for input (%s, %s)",
                            expected,
                            actual,
                            this.first,
                            this.second));
        }
    }

}
