package com.hightower.prep.stacksandqueues;

import java.util.Stack;

/**
 * <p>Implement a First-in-First-Out Queue using stacks (Last-In-First-Out).</p>
 *
 * <p>When elements are enqueued they are pushed onto stack #2. Stack #2 contains elements in LIFO ordering.
 * When peek or dequeue is called and there are no remaining elements in Stack #1 elements from Stack #2 are
 * moved into Stack #1. This re-orders elements into FIFO ordering where to support peek and pop of elements in the
 * correct order.</p>
 *
 * Operations to support:
 * - enqueue: Add an element to the end of the queue
 * - dequeue: Removes the front element of the queue
 * - peek: Returns the front element of the queue without removing it.
 * - isEmpty: Check if the queue is empty
 * - size: Return number of elements in the queue
 */
public class QueueUsingStacks<T> {

    private final Stack<T> s1;
    private final Stack<T> s2;

    public QueueUsingStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void enqueue(T element) {
        if (this.s1.isEmpty() && this.s2.isEmpty()) {
            this.s1.push(element);
        } else {
            this.s2.push(element);
        }
    }

    public T dequeue() {
        if (!this.s1.isEmpty()) {
            return this.s1.pop();
        }
        this.populateS1FromS2();
        return this.s1.isEmpty() ? null : this.s1.pop();
    }

    public T peek() {
        if (!this.s1.isEmpty()) {
            return this.s1.peek();
        }
        this.populateS1FromS2();
        return this.s1.isEmpty() ? null : this.s1.peek();
    }

    public boolean isEmpty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
    }

    public int size() {
        return this.s1.size() + this.s2.size();
    }

    private void populateS1FromS2() {
        while (!this.s2.isEmpty()) {
            this.s1.push(this.s2.pop());
        }
    }

}
