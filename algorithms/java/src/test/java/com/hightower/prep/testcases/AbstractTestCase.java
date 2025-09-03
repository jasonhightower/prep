package com.hightower.prep.testcases;

public abstract class AbstractTestCase {

    private final String displayName;

    public AbstractTestCase(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

}
