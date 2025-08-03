package com.hightower.prep.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

// TODO JH revisit
// first attempt was good, using two queues to store R and D
// maintained remaining counts for both and also number of each that
// needed to be removed.

// The following is a better approach. Maintaining two queues containing
// the position of each senator and then comparing the index of R and D
// until one of the queues empties, after a senator is victorious their
// index needs to be updated by senators.length to put them at the back of the line
// otherwise senator.charAt(0) would always win
public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
           int radiantIndex = radiant.remove();
           int direIndex = dire.remove();
           if (radiantIndex < direIndex) {
               radiant.add(radiantIndex + senate.length());
           } else {
               dire.add(direIndex + senate.length());
           }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

}
