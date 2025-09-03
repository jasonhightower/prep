package com.hightower.prep.testcases;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ImplementationTestCase<T> extends AbstractTestCase {

    private Consumer<T> test;

    public ImplementationTestCase(final String displayName,
                                  final Consumer<T> test) {
        super(displayName);
        this.test = test;
    }

    public void run(Supplier<T> supplier) {
        this.test.accept(supplier.get());
    }
}
