package com.hightower.prep.twopointer;

public class IsSubsequence {

    public boolean check(final String s, final String t) {
        if (t.startsWith(s)) {
            return true;
        }
        int slow=0;
        int fast=0;
        while (slow < s.length() && fast < t.length()) {
            if (s.charAt(slow) == t.charAt(fast)) {
                slow++;
            }
            fast++;
        }
        return slow >= s.length();
    }

}
