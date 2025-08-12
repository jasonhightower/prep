package com.hightower.prep.heap;

import java.util.PriorityQueue;

// TODO JH need to add better tests for this
public class MinBinarySet {

    private int cursor = 1;

    private PriorityQueue<Integer> queue;
    
    public MinBinarySet() {
        this.queue = new PriorityQueue<>((i,j) -> {
            if (i < j) return -1;
            else if (i.equals(j)) return 0;
            else return 1;
        });
    }

    public void addBack(Integer val) {
        if (val >= this.cursor) {
            return;
        }
        if (!this.queue.contains(val)) {
            this.queue.add(val);
        }
    }

    public Integer popSmallest() {
        if (this.queue.isEmpty()) {
            return this.cursor++;
        }
        return this.queue.poll();
    }

    public static void main(String[] args) {
        MinBinarySet set = new MinBinarySet();
        set.addBack(2);
        int x = set.popSmallest();
        x = set.popSmallest();
        x = set.popSmallest();
        set.addBack(1);
        set.addBack(2);
        x = set.popSmallest();
        x = set.popSmallest();
        x = set.popSmallest();
    }

}
