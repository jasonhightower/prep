package com.hightower.prep.stacksandqueues;

import java.util.ArrayList;
import java.util.List;

public class ExpandOptionalRegexRecursive {

    public List<String> expand(final String input) {
        final List<String> results = new ArrayList<>();
        expandStrings(input, "", 0, results);
        return results;
    }

    public void expandStrings(final String input, final String prefix, int pos, List<String> results) {
        if (pos >= input.length()) {
            results.add(prefix);
            return;
        }
        char cur = input.charAt(pos);
        if (pos < input.length() - 1 && input.charAt(pos + 1) == '?') {
            expandStrings(input, prefix, pos + 2, results);
            expandStrings(input, prefix + cur, pos + 2, results);
        } else {
            expandStrings(input, prefix + cur, pos + 1, results);
        }
    }

}
