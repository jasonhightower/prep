package com.hightower.prep.strings;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(final List<String> input) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : input) {
            String key = createKey(s);
            List<String> matches;
            if (!anagrams.containsKey(key)) {
                matches = new ArrayList<>();
                anagrams.put(key,matches);
            } else {
                matches = anagrams.get(key);
            }
            matches.add(s);
        }
        return new ArrayList<>(anagrams.values());
    }

    private String createKey(final String input) {
        char[] characters = input.strip().toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

}
