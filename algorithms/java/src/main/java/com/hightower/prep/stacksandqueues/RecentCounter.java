package com.hightower.prep.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {

    private Deque<Integer> timestamps;

    public RecentCounter() {
        this.timestamps = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!this.timestamps.isEmpty() && (t - this.timestamps.peek()) > 3000) {
            this.timestamps.remove();
        }
        this.timestamps.add(t);
        return this.timestamps.size();
    }
}
