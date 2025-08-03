package com.hightower.prep.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OddEvenTest {

    private OddEven classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new OddEven();
    }

    @Test
    public void testCase1() {
        Node<Integer> head = Node.fromArray(new int[] {1,2,3,4,5});
        Integer[] expected = new Integer[]{1,3,5,2,4};
        assertArrayEquals(expected, this.classUnderTest.group(head).toArray());
    }

    @Test
    public void testCase2() {
        Node<Integer> head = Node.fromArray(new int[] {2,1,3,5,6,4,7});
        Integer[] expected = new Integer[]{2,3,6,7,1,5,4};
        assertArrayEquals(expected, this.classUnderTest.group(head).toArray());
    }
}
