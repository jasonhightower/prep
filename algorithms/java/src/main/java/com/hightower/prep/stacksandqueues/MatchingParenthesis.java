package com.hightower.prep.stacksandqueues;

import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters (, ), [, ], {, and } determine if
 * the input string is valid.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class MatchingParenthesis {

    private static Map<Character, Character> BRACKET_MAP = Map.of('(', ')', '[', ']', '{', '}');

    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (BRACKET_MAP.containsKey(c)) {
                stack.push(BRACKET_MAP.get(c));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char expected = stack.pop();
                if (expected != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
