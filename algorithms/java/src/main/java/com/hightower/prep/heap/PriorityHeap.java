package com.hightower.prep.heap;

import java.util.ArrayList;
import java.util.List;

// TODO JH - Need to practice creating a BinaryHeap (how it restructures itself, and how it is complete, etc.)
// TODO JH - Need to practice QuickSelect as a means of quickly finding an nth item based on dividing into
// left, mid and right groups then continuing to process based on that.
// effective searching within a non-sorted group
public class PriorityHeap {

    public int findLargestWithHeap(int[] input, int k) {
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<>(Integer.class);
        for (int in: input) {
            heap.add(in);
        }
        int val = -1;
        for (int i = 0; i < k; i++) {
            val = heap.get();
        }
        return val;
    }

    public int findLargestQuickSelect(int[] input, int k) {
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int pivot = input[0];
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            if (num == pivot) {
                mid.add(num);
            } else if (num > pivot) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        if (left.size() >= k) {
            return findLargestQuickSelect(left.stream().mapToInt(Integer::intValue).toArray(), k);
        } else if (left.size() + mid.size() < k) {
            return findLargestQuickSelect(right.stream().mapToInt(Integer::intValue).toArray(),
                    k - (left.size() + mid.size()));
        } else {
            return pivot;
        }
    }

    public static void main(String[] args) {
        //assertResult(5, new int[] {3,2,1,5,6,4}, 2);
        assertResult(4, new int[] {3,2,3,1,2,4,5,5,6}, 4);
    }

    private static void assertResult(int expected, int[] input, int k) {
        int result = new PriorityHeap().findLargestWithHeap(input, k);
        if (result != expected) {
            throw new RuntimeException(String.format("FAIL (heap): Expected %d, got %d", expected, result));
        }
        result = new PriorityHeap().findLargestQuickSelect(input, k);
        if (result != expected) {
            throw new RuntimeException(String.format("FAIL (qs): Expected %d, got %d", expected, result));
        }
    }

}
