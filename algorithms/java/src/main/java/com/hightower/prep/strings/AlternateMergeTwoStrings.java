package com.hightower.prep.strings;

public class AlternateMergeTwoStrings {

    public String merge(String input1, String input2) {
        if (input1 == null && input2 == null) {
            return null;
        }
        if (input1 == null) {
            return input2;
        }
        if (input2 == null) {
            return input1;
        }
        char[] characters = new char[input1.length() + input2.length()];
        int pos = 0;
        int minLength = Math.min(input1.length(), input2.length());
        for (int i = 0; i < minLength; i++) {
            characters[pos++] = input1.charAt(i);
            characters[pos++] = input2.charAt(i);
        }
        if (input1.length() > minLength) {
            for (int i = minLength; i < input1.length(); i++) {
                characters[pos++] = input1.charAt(i);
            }
        } else {
            for (int i = minLength; i < input2.length(); i++) {
                characters[pos++] = input2.charAt(i);
            }
        }
        return new String(characters);
    }
}
