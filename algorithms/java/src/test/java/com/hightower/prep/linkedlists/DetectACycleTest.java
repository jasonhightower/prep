package com.hightower.prep.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetectACycleTest {

    private DetectACycle classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new DetectACycle();
    }

    @Test
    public void testLeetCode1() {
        Node<Integer> first = new Node<>(3);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(0);
        Node<Integer> fourth = new Node<>(-4);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second);
        assertTrue(this.classUnderTest.isCyclic(first));
   }


    @Test
    public void testLeetCode2() {
        Node<Integer> first = new Node<>(3);
        Node<Integer> second = new Node<>(2);

        first.setNext(second);
        second.setNext(first);
        assertTrue(this.classUnderTest.isCyclic(first));
    }

    @Test
    public void testLeetCode3() {
        Node<Integer> first = new Node<>(3);
        assertFalse(this.classUnderTest.isCyclic(first));
    }

    @Test
    public void testNonCyclic() {
        Node<Integer> first = new Node<>(3);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(0);
        Node<Integer> fourth = new Node<>(-4);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        assertFalse(this.classUnderTest.isCyclic(first));
    }



}
