package com.hightower.prep.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DeleteMiddleNodeTest {

    private DeleteMiddleNode classUnderTest;

    @BeforeEach
    public void setUp() {
       this.classUnderTest = new DeleteMiddleNode();
    }

    @Test
    public void testCase1() {
        Node<Integer> head = Node.fromArray(new int[] {1,3,4,7,1,2,6});
        Integer[] expected = new Integer[] {1,3,4,1,2,6};
        head = this.classUnderTest.deleteMiddle(head);
        assertArrayEquals(expected, head.toArray());
    }

    @Test
    public void testCase2() {
        Node<Integer> head = Node.fromArray(new int[] {1,2,3,4});
        Integer[] expected = new Integer[] {1,2,4};
        head = this.classUnderTest.deleteMiddle(head);
        assertArrayEquals(expected, head.toArray());
    }

    @Test
    public void testCase3() {
        Node<Integer> head = Node.fromArray(new int[] {2,1});
        Integer[] expected = new Integer[] {2};
        head = this.classUnderTest.deleteMiddle(head);
        assertArrayEquals(expected, head.toArray());
    }

}
