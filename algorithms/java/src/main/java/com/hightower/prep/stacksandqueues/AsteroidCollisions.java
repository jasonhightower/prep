package com.hightower.prep.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

// TODO JH revisit this and implement with a for loop and single stack
// You iterate over all of the asteroids and only add them to the stack if they don't collide
// with most recent
// use Deque over Stack for better memory efficiency/speed
public class AsteroidCollisions {

    public int[] simulate(int[] asteroids) {
        if (asteroids.length <= 1) {
            return asteroids;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int cur :asteroids) {
            if (cur > 0) {
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -cur) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == -cur) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(cur);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}
