package com.hightower.prep.strings;

import java.util.Optional;

public class LongestPalindromicSubstring {

    public String find(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            String tmp = expand(input, i, i);
            if (tmp.length() > result.length()) {
                result = tmp;
            }
            tmp = expand(input, i, i+1);
            if (tmp.length() > result.length()) {
                result = tmp;
            }
        }
        return result.isEmpty() ? null : result;
    }

    private String expand(String input, int left, int right) {
        while (left >= 0 &&
                right < input.length() &&
                input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return input.substring(left+1, right);
    }

}
