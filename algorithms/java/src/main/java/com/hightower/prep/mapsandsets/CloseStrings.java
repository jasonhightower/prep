package com.hightower.prep.mapsandsets;

import java.util.*;

// TODO JH revisit this
// First approach used maps and ordered lists to calculate the answer
// but was slow due to data structures involved
// faster solutions bypass maps and use arrays directly as
// characters are limited to lowercase alpha
public class CloseStrings {

    public boolean isClose(final String word1, final String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] counts1 = countChars(word1);
        int[] counts2 = countChars(word2);

        for (int i = 0; i < 26; i++) {
            if (counts1[i] != 0 && counts2[i] == 0 ||
                    counts1[i] == 0 && counts2[i] != 0) {
                return false;
            }
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        return Arrays.equals(counts1, counts2);
    }

    private int[] countChars(final String word) {
        int[] counts = new int[26];
        for (char c: word.toCharArray()) {
            counts[c-'a']++;
        }
        return counts;
    }

}
