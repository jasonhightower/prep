package com.hightower.prep.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseNodesInKGroupTest {

    private ReverseNodesInKGroup classUnderTest;

    @BeforeEach
    public void setUp() {
       this.classUnderTest = new ReverseNodesInKGroup();
    }

    @Test
    public void testCase1() {
        Node<Integer> head = Node.fromArray(new int[] {1,2,3,4,5});
        Node<Integer> result = this.classUnderTest.reverseRecursive(head, 2);
        assertArrayEquals(new Integer[] {2, 1, 4, 3, 5}, result.toArray());
    }

    @Test
    public void testCase2() {
        Node<Integer> head = Node.fromArray(new int[] {1,2,3,4,5});
        Node<Integer> result = this.classUnderTest.reverseRecursive(head, 3);
        assertArrayEquals(new Integer[] {3,2,1,4,5}, result.toArray());
    }



}
