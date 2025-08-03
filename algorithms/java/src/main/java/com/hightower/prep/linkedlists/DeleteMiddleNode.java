package com.hightower.prep.linkedlists;

public class DeleteMiddleNode {

    public <T> Node<T> deleteMiddle(Node<T> head) {
        Node<T> prev = head;
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast.getNext() != null) {
            prev = slow;
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast.getNext() != null) {
                fast = fast.getNext();
            }
        }
        prev.setNext(slow.getNext());
        return head;
    }

}
