package com.hightower.prep.dailypractice;

import com.hightower.prep.core.MinStack;

import java.sql.Array;
import java.util.*;

public class Day2 {

    public List<List<Integer>> threeSum(final int[] ints) {
        Arrays.sort(ints);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < ints.length - 2; i++) {
            int left = i + 1;
            int right = ints.length - 1;
            while (left < right) {
                int result = ints[i] + ints[left] + ints[right];
                if (result == 0) {
                    results.add(List.of(ints[i], ints[left], ints[right]));
                    left++;
                    right--;
                    while (left < right && ints[left] == ints[left-1]) left++;
                } else if (result < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i < ints.length - 2 && ints[i] == ints[i+1]) i++;
        }

        return results;
    }

    public int containerWithMostWater(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, area);
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // TODO JH revisit this
    public int trappingRainWater(int[] heights) {
        int l = 0, r = heights.length - 1;
        int leftMax = heights[l];
        int rightMax = heights[r];
        int area = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                area += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                area += rightMax - heights[r];
            }
        }
        return area;
    }

    public boolean validParenthesis(final String input) {
        final Map<Character, Character> open = Map.of('(', ')',
                                                      '[', ']',
                                                      '{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c :input.toCharArray()) {
            if (open.containsKey(c)) {
                stack.push(open.get(c));
            } else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public MinStack minStack() {
        return new MinStack() {

            private Deque<Entry> entries = new ArrayDeque<>();

            @Override
            public void push(int val) {
                int min = entries.isEmpty() ? val : Math.min(entries.peek().val, val);
                entries.push(new Entry(val, min));
            }

            @Override
            public void pop() {
                this.entries.pop();
            }

            @Override
            public int top() {
                return this.entries.peek().val;
            }

            @Override
            public int min() {
                return this.entries.peek().min;
            }

            private record Entry(int val, int min) { }
        };
    }

    public int reversePolishNotation(final String[] strings) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String c: strings) {
            switch (c) {
                case "-": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    break;
                }
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                case "+": {
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case "*": {
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                default:
                    stack.push(Integer.parseInt(c));
                    break;
            }
        }
        return stack.pop();
    }
}
