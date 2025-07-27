package com.hightower.prep.strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String input, String target) {
        if (input.length() != target.length()) {
            return false;
        }
        return countChars(input).equals(countChars(target));
    }

    private Map<Character, Integer> countChars(String input) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : input.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

}
