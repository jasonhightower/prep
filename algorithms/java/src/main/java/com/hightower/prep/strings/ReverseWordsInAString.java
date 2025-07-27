package com.hightower.prep.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInAString {

    public String reverseWords(String input) {
        List<String> words = Arrays.asList(input.split("\\s"));
        Collections.reverse(words);
        return words.stream()
                .map(String::strip)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
    }

    public String reverseWordsManually(String input) {
        StringBuilder builder = new StringBuilder();
        String[] words = input.split("\\s");
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i].strip();
            if (!word.isEmpty()) {
                if (builder.length() > 0) {
                    builder.append(" ");
                }
                builder.append(word);
            }
        }
        return builder.toString();
    }

}
