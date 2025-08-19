package com.hightower.prep.algomap.arraysandstrings;

public class IsSubsequence {

    public boolean check(final String s, final String t) {
        if (s == null || t == null) {
            return false;
        }
        int i = 0;
        for (char c: t.toCharArray()) {
            if (i < s.length() && c == s.charAt(i)) i++;
        }
        return i == s.length();
    }

}
