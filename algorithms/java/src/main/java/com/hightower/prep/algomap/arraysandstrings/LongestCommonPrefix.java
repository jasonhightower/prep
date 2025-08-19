package com.hightower.prep.algomap.arraysandstrings;

// TODO JH review this, I overthought it and started considering trie as the solution
//  -- should also consider re-writing this to use a trie structure for better performance
public class LongestCommonPrefix {

    public String longestCommonPrefix(final String[] strs) {
        int minLength = this.minLength(strs);
        for (int pos = 0; pos < minLength; pos++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[0].charAt(pos) != strs[i].charAt(pos)) {
                    if (pos == 0) {
                        return "";
                    } else {
                        return strs[0].substring(0, pos);
                    }
                }
            }
        }
        return strs[0].substring(0, minLength);
    }

    private int minLength(final String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str: strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        return minLength;
    }

}
