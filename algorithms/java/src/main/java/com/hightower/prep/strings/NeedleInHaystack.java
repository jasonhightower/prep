package com.hightower.prep.strings;

import java.util.Optional;

public class NeedleInHaystack {

    public Optional<Integer> find(final String needle, final String haystack) {
        if (needle.isEmpty()) {
            throw new IllegalArgumentException("Needle cannot be an empty string");
        }
        if (needle.length() > haystack.length()) {
            return Optional.empty();
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (matches(haystack, i, needle)) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }

    private boolean matches(String haystack, int idx, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(idx + i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
