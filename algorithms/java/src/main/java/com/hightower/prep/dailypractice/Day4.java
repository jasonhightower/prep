package com.hightower.prep.dailypractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Day4 {

    // TODO JH revisit this one, fun problem
    public int carFleet(int[][] input, int end) {
        if (input == null || input.length == 0 || input[0].length == 0) {
            return 0;
        }
        int[][] cars = new int[input[0].length][2];
        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = input[0][i];
            cars[i][1] = input[1][i];
        }
        Arrays.sort(cars, (o1, o2) -> -Integer.compare(o1[0], o2[0]));
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push((end - cars[0][0])/cars[0][1]);
        for (int i = 1; i < cars.length; i++) {
            int timeToEnd = (end - cars[i][0])/cars[i][1];
            if (timeToEnd > stack.peek()) {
                stack.push(timeToEnd);
            }
        }
        return stack.size();
    }

    // TODO JH this is a fun one too, need to look at how the problem breaks down to a
    // pretty straightforward solution given only one of three possibilities
    public int largestRectangleInHistogram(int[] histogram) {
        if (histogram == null || histogram.length == 0) {
            return 0;
        }
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{histogram[0], 0});
        int max = 0;
        for (int i = 1; i < histogram.length; i++) {
            if (histogram[i] == stack.peek()[0]) continue;
            int start = i;
            while (!stack.isEmpty() && stack.peek()[0] > histogram[i]) {
                int[] bar = stack.pop();
                max = Math.max(max, (i - bar[1]) * bar[0]);
                start = bar[1];
            }
            stack.push(new int[] {histogram[i], start});
        }
        while (!stack.isEmpty()) {
            int[] bar = stack.pop();
            max = Math.max(max, (histogram.length - bar[1]) * bar[0]);
        }
        return max;
    }

}
