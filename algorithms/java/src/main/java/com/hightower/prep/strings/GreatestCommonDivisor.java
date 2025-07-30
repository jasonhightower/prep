package com.hightower.prep.strings;

public class GreatestCommonDivisor {

    public String calculate(final String s, final String t) {
        if (!(s + t).equals(t + s)) {
            return null;
        }
        return s.substring(0, findGCD(s.length(), t.length()));
        
        // Lender wants fire insurance
        // 8 AM 12th
        //
    }
    
    private int findGCD(int s, int t) {
        if (t == 0) {
            return s;
        }
        return findGCD(t, s % t);
    }

}
