package com.hightower.prep.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

// TOOD JH need to revisit this one
//
// Took a long time to find a recursive solution that would work
// Thought of the two stack solution but didn't figure out how to handle building up the string on the ]
// Using string directly works but StringBuilder is faster
public class DecodeString {

    public String decode(final String input) {
        if (input == null || input.length() < 4) {
            return input;
        }
        Deque<StringBuilder> stack = new ArrayDeque<>();
        Deque<Integer> repeat = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int repeatCount=0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c <= '9') {
                repeatCount = repeatCount*10+(c-'0');
            } else if (c == '[') {
                repeat.push(repeatCount);
                stack.push(cur);
                cur = new StringBuilder();
                repeatCount=0;
            } else if (c == ']') {
                StringBuilder prev = stack.pop();
                int count = repeat.pop();
                for (int j = 0; j < count; j++) {
                    prev.append(cur);
                }
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }

}
