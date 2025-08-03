package com.hightower.prep.stacksandqueues;

public class RemoveStarsFromString {

    public String remove(final String input) {
        char[] chars = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != '*') {
                chars[slow] = chars[fast];
                slow++;
            } else {
                slow--;
            }
        }
        return new String(chars, 0, slow);
    }
}
