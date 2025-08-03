package com.hightower.prep.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumTwinTwoSumTest {

    private MaximumTwinTwoSum classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MaximumTwinTwoSum();
    }

    @Test
    public void testCase1() {
        Node<Integer> head = Node.fromArray(new int[] {5,4,2,1}) ;
        assertEquals(6, this.classUnderTest.calculate(head));
    }

    @Test
    public void testCase2() {
        Node<Integer> head = Node.fromArray(new int[] {4,2,2,3}) ;
        assertEquals(7, this.classUnderTest.calculate(head));
    }

    @Test
    public void testCase3() {
        Node<Integer> head = Node.fromArray(new int[] {1, 100000}) ;
        assertEquals(100001, this.classUnderTest.calculate(head));
    }

}
