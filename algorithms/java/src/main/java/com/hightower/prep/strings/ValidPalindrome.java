package com.hightower.prep.strings;

/**
 * Confirm the given string is a valid palindrome ignoring non-alphanumeric characters.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            while (left < right && !Character.isAlphabetic(input.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isAlphabetic(input.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
