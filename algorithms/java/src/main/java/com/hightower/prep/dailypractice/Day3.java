package com.hightower.prep.dailypractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Day3 {


    // TODO JH tried to use stack without recursion, should just reach for recursion in this case
    // also, use StringBuilder as the stack...
    public List<String> generateParenthesis(int n) {
        StringBuilder stack = new StringBuilder("(");
        List<String> results = new ArrayList<>();
        generateParenthesis(1, 0, n, stack, results);
        return results;
    }

    private void generateParenthesis(int nOpen, int nClosed, int n, StringBuilder stack, List<String> result) {
        if (nOpen == nClosed && nOpen == n) {
            result.add(stack.toString());
            return;
        }
        if (nOpen < n) {
            stack.append("(");
            generateParenthesis(nOpen + 1, nClosed, n, stack, result);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (nClosed < nOpen) {
            stack.append(")");
            generateParenthesis(nOpen, nClosed + 1, n, stack, result);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    // TODO JH need to revisit this one using dynamic programming is interesting
    public int[] dailyTemperatures_DynamicProgramming(final int[] temps) {
        int[] results = new int[temps.length];
        for (int left = results.length - 2; left >= 0; left--) {
            int right = left + 1;
            while (right < temps.length && temps[left] >= temps[right]) {
                if (results[right] == 0) {
                    right = temps.length;
                    break;
                }
                right++;
            }
            if (right < temps.length) {
                results[left] = right - left;
            }
        }
        return results;
    }

    // TODO JH need to revisit this approach, didn't jump out to me at first
    public int[] dailyTemperatures_Stack(int[] temps) {
        int[] results = new int[temps.length];
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[i] > stack.peek()[0]) {
                int[] pair = stack.pop();
                results[pair[1]] = i - pair[1];
            }
            stack.push(new int[] {temps[i], i});
        }
        return results;
    }
}
