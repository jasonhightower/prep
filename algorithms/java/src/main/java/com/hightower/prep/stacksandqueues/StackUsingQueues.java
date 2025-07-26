package com.hightower.prep.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>Stack implementation constructed using two queues.</p>
 *
 * When an element is pushed it is added to Queue #2. Then all elements from Queue #1 are moved into Queue #2 as well.
 * Queue #2 and Queue #1 are then swapped so elements remain in Queue #1.
 *
 * @param <T>
 */
public class StackUsingQueues<T> {

    private Queue<T> q1;
    private Queue<T> q2;

    public StackUsingQueues() {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }

    public void push(T element) {
        this.q2.add(element);
        while (!this.q1.isEmpty()) {
            this.q2.add(this.q1.remove());
        }
        final Queue<T> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
    }

    public T pop() {
        if (!this.q1.isEmpty()) {
            return this.q1.remove();
        }
        // TODO JH should probably throw an exception here
        return null;
    }

    public T peek() {
        return this.q1.peek();
    }

    public boolean isEmpty() {
        return this.q1.isEmpty();
    }

    public int size() {
        return this.q1.size();
    }

}
