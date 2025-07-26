package com.hightower.prep.stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a regular expression like "A?BC?D" where ? delineates 0 or 1
 * occurrence of the previous character return all the combinations of the string.
 */
public class ExpandOptionalRegex {

    public List<String> expand(String input) {
        Stack<Partial> partials = new Stack<>();
        partials.push(new Partial("", 0));

        List<String> results = new ArrayList<>();
        while (!partials.isEmpty()) {
            Partial partial = partials.pop();
            int pos = partial.getPos();
            if (pos >= input.length()) {
                results.add(partial.getValue());
                continue;
            }

            char c = input.charAt(pos);
            if (pos + 1 < input.length() &&
                input.charAt(pos + 1) == '?') {
                partials.push(new Partial(partial.getValue(), pos + 2));
                partials.push(new Partial(partial.getValue() + c, pos + 2));
            } else {
                partials.push(new Partial(partial.getValue() + c, pos + 1));
            }
        }
        return results;
    }

    private static class Partial {
        private final String value;
        private final int pos;

        public Partial(String value, int pos) {
            this.value = value;
            this.pos = pos;
        }

        public String getValue() {
            return value;
        }

        public int getPos() {
            return this.pos;
        }

    }


}
