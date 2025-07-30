package com.hightower.prep.twopointer;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsInAString {

    private static Set<Character> VOWELS = new HashSet<>();
    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }

    public String reverseVowels(final String input) {
        if (input == null || "".equals(input)) {
            return input;
        }
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !VOWELS.contains(chars[left])) {
                left++;
            }
            while (left < right && !VOWELS.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
