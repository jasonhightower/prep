package com.hightower.prep.strings;

public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int pos = 0;
        char cur;
        int start;
        int cursor = 0;
        while (pos < chars.length) {
            cur = chars[pos];
            start = pos;
            while (pos < chars.length && chars[pos] == cur) {
                pos++;
            }
            chars[cursor++] = cur;
            int num = pos - start;
            if (num > 1) {
                String numStr = Integer.toString(num);
                for (int i = 0; i < numStr.length(); i++) {
                    chars[cursor++] = numStr.charAt(i);
                }
            }
        }
        return cursor;
    }

}
