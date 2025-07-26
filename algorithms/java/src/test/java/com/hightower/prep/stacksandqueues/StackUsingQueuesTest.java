package com.hightower.prep.stacksandqueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackUsingQueuesTest {

    private StackUsingQueues<Integer> classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new StackUsingQueues<>();
    }

    @Test
    public void testPushAndPop() {
        this.classUnderTest.push(1);
        this.classUnderTest.push(2);
        this.classUnderTest.push(3);
        this.classUnderTest.push(4);
        assertEquals(4, this.classUnderTest.size());
        assertEquals(4, this.classUnderTest.pop());
        assertEquals(3, this.classUnderTest.pop());
        assertEquals(2, this.classUnderTest.pop());
        assertEquals(1, this.classUnderTest.pop());
    }

    @Test
    public void testPushAndPopMixedCalls() {
        this.classUnderTest.push(1);
        this.classUnderTest.push(2);
        assertEquals(2, this.classUnderTest.pop());
        this.classUnderTest.push(3);
        this.classUnderTest.push(4);
        assertEquals(4, this.classUnderTest.pop());
        assertEquals(3, this.classUnderTest.pop());
        assertEquals(1, this.classUnderTest.pop());
    }


    @Test
    public void testPeek() {
        this.classUnderTest.push(1);
        assertEquals(1, this.classUnderTest.peek());
        this.classUnderTest.push(2);
        assertEquals(2, this.classUnderTest.peek());
        this.classUnderTest.pop();
        assertEquals(1, this.classUnderTest.peek());
        this.classUnderTest.push(3);
        assertEquals(3, this.classUnderTest.peek());
        this.classUnderTest.push(4);
        assertEquals(4, this.classUnderTest.peek());
    }



}
