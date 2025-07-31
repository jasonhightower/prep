package com.hightower.prep.slidingwindow;

import java.util.Set;

public class MaximumVowelsInSubstring {

    private Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int findMax(final String s, final int k) {
        char[] chars = s.toCharArray();
        if (s == null || "".equals(s)) {
            return 0;
        }
        int num = 0;
        int head = 0;
        int tail = 0;
        while (head < k) {
            if (isVowel(chars[head])) {
                num++;
            }
            head++;
        }
        int max = num;
        while (head < s.length()) {
            if (isVowel(chars[head])) {
                num++;
            }
            if (isVowel(chars[tail])) {
                num--;
            }
            if (num > max) {
                max = num;
            }
            head++;
            tail++;
        }
        return max;
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

}
