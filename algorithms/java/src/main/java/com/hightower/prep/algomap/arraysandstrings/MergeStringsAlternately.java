package com.hightower.prep.algomap.arraysandstrings;

public class MergeStringsAlternately {

    public String merge(final String input1, final String input2) {
        if (input1 == null) {
            return input2;
        }
        if (input2 == null) {
            return input1;
        }
        char[] result = new char[input1.length() + input2.length()];
        int pos1 = 0;
        int pos2 = 0;
        int cursor = 0;
        while (pos1 < input1.length() && pos2 < input2.length()) {
            result[cursor++] = input1.charAt(pos1++);
            result[cursor++] = input2.charAt(pos2++);
        }
        while (pos1 < input1.length()) {
            result[cursor++] = input1.charAt(pos1++);
        }
        while (pos2 < input2.length()) {
            result[cursor++] = input2.charAt(pos2++);
        }
        return new String(result);
    }
}
