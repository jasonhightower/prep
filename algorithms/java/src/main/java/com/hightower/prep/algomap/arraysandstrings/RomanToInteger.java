package com.hightower.prep.algomap.arraysandstrings;

import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> N_TO_INT = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int convert(final String s) {
        int sum = 0;
        int pos = s.length() - 1;
        int lastVal = 0;
        while (pos >= 0) {
            int val = N_TO_INT.get(s.charAt(pos));
            if (val < lastVal) {
                sum -= val;
            } else {
                sum += val;
            }
            lastVal = val;
            pos--;
        }
        return sum;
    }

}
