package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueUsingStacksTest {

    private QueueUsingStacks<Integer> classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new QueueUsingStacks<>();
    }

    @Test
    public void testQueueAndDequeu() {
        this.classUnderTest.enqueue(1);
        this.classUnderTest.enqueue(2);
        this.classUnderTest.enqueue(3);
        this.classUnderTest.enqueue(4);

        assertEquals(4, this.classUnderTest.size());
        assertEquals(1, this.classUnderTest.dequeue());
        assertEquals(2, this.classUnderTest.dequeue());
        assertEquals(3, this.classUnderTest.dequeue());
        assertEquals(4, this.classUnderTest.dequeue());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(this.classUnderTest.isEmpty());
        this.classUnderTest.enqueue(1);
        assertFalse(this.classUnderTest.isEmpty());
        this.classUnderTest.enqueue(2);
        assertFalse(this.classUnderTest.isEmpty());
        this.classUnderTest.dequeue();
        assertFalse(this.classUnderTest.isEmpty());
        this.classUnderTest.dequeue();
        assertTrue(this.classUnderTest.isEmpty());
    }

    @Test
    public void testEnqueueAndDequeueMixedCalls() {

        this.classUnderTest.enqueue(1);
        this.classUnderTest.enqueue(2);
        assertEquals(1, this.classUnderTest.dequeue());
        this.classUnderTest.enqueue(3);
        this.classUnderTest.enqueue(4);

        assertEquals(2, this.classUnderTest.dequeue());
        assertEquals(3, this.classUnderTest.dequeue());
        assertEquals(4, this.classUnderTest.dequeue());
    }


    @Test
    public void testPeek() {
        this.classUnderTest.enqueue(1);
        assertEquals(1, this.classUnderTest.peek());
        this.classUnderTest.enqueue(2);
        assertEquals(1, this.classUnderTest.peek());
        this.classUnderTest.dequeue();
        assertEquals(2, this.classUnderTest.peek());
        this.classUnderTest.enqueue(3);
        assertEquals(2, this.classUnderTest.peek());
        this.classUnderTest.enqueue(4);
        assertEquals(2, this.classUnderTest.peek());

        this.classUnderTest.dequeue();
        assertEquals(3, this.classUnderTest.peek());
        this.classUnderTest.dequeue();
        assertEquals(4, this.classUnderTest.peek());
        this.classUnderTest.dequeue();
        assertNull(this.classUnderTest.peek());
    }

}
