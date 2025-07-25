package com.hightower.prep.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Finds the length of the longest non-repeating substring in the given string.
 *
 * Time Complexity:
 * Space Complexity: O(N)
 */
public class LongestSubstring {

    public int find(final String str) {
        Map<Character, Integer> seen = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < str.length(); right++) {
            Character c = str.charAt(right);
            int lastSeen = seen.getOrDefault(c, -1);
            if (lastSeen >= left) {
                maxLen = Math.max(maxLen, right - left);
                left = lastSeen + 1;
            }
            seen.put(c, right);
        }
        return Math.max(str.length() - left, maxLen);
    }

}
