package com.hightower.prep.linkedlists;

public class MergeTwoSortedLists {

    public  Node<Integer> merge(Node<Integer> first, Node<Integer> second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        Node<Integer> head = new Node<>(0);
        Node<Integer> tail = head;
        while (first != null && second != null) {
            if (first.getVal() < second.getVal()) {
                tail.setNext(first);
                first = first.getNext();
            } else {
                tail.setNext(second);
                second = second.getNext();
            }
            tail = tail.getNext();
        }
        if (first != null) {
            tail.setNext(first);
        } else {
            tail.setNext(second);
        }
        return head.getNext();
    }
}
