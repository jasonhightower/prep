package com.hightower.prep.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Given the head of a singly linked list, reverse the list and return the new head.
 *
 * TODO: JH need to revisit this to nail it down.
 */
public class ReverseLinkedListTest {

    private ReverseLinkedList classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ReverseLinkedList();
    }

    @Test
    public void testLeetCode1() {
        Node<Integer> head = Node.fromArray(new int[] {1,2,3,4,5});
        head = this.classUnderTest.reverse(head);

        Integer[] result = head.toArray();
        assertArrayEquals(new Integer[] {5,4,3,2,1}, result);
    }

    @Test
    public void testLeetCode2() {
        Node<Integer> head = Node.fromArray(new int[] {1, 2});
        head = this.classUnderTest.reverse(head);

        Integer[] result = head.toArray();
        assertArrayEquals(new Integer[] {2, 1}, result);
    }

    @Test
    public void testLeetCode3() {
        Node<Integer> head = Node.fromArray(new int[] {});
        head = this.classUnderTest.reverse(head);
        assertNull(head);
    }

}
