package com.hightower.prep.linkedlists;

public class ReverseLinkedList {

    public <T> Node<T> reverse(final Node<T> head) {
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
