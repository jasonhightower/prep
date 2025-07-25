package com.hightower.prep.strings;

/**
 * Reverse a string in place.
 */
public class ReverseString {

    public String reverse(String input) {
        char[] characters = input.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        char temp;
        while (left < right) {
            temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;
            left++;
            right--;
        }
        return new String(characters);
    }

}
