package com.hightower.prep.strings;

public class ReverseWordsInAString {

    public String reverseWords(String input) {
        int left = input.length();
        int right = left;
        StringBuilder builder = new StringBuilder();
        while (left >= 0) {
            while (right - 1 >= 0 && input.charAt(right - 1) == ' ') {
                right--;
            }
            if (right == 0) {
                break;
            }
            left = right;
            while (left - 1 >= 0 && input.charAt(left - 1) != ' ') {
                left--;
            }
            if (builder.length() != 0) {
                builder.append(' ');
            }
            builder.append(input, left, right);
            left--;
            right = left;
        }
        return builder.toString();
    }

}
