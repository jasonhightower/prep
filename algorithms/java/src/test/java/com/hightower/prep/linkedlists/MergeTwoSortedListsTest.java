package com.hightower.prep.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeTwoSortedListsTest {

    private MergeTwoSortedLists classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MergeTwoSortedLists();
    }

    @Test
    public void testLeetCode1() {
        Node<Integer> first = Node.fromArray(new int[] {1,2,4});
        Node<Integer> second = Node.fromArray(new int[] {1,3,4});

        Node<Integer> merged = this.classUnderTest.merge(first, second);
        Integer[] result = merged.toArray();
        assertArrayEquals(new Integer[] {1,1,2,3,4,4}, result);
    }

    @Test
    public void testLeetCode2() {
        Node<Integer> first = null;
        Node<Integer> second = null;

        Node<Integer> merged = this.classUnderTest.merge(null, null);
        assertNull(merged);
    }

    @Test
    public void testLeetCode3() {
        Node<Integer> second = Node.fromArray(new int[] {0});

        Node<Integer> merged = this.classUnderTest.merge(null, second);
        Integer[] result = merged.toArray();
        assertArrayEquals(new Integer[] {0}, result);
    }
}
