package com.hightower.prep.linkedlists;

public class ReverseNodesInKGroup {

    public <T> Node<T> reverseRecursive(Node<T> head, int k) {
        if (head == null || !hasRemaining(head, k)) {
            return head;
        }

        Node<T> cur = head;
        Node<T> prev = null;
        Node<T> next = null;
        for (int i = 0; i < k; i++) {
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        if (cur != null) {
            head.setNext(reverseRecursive(cur, k));
        }
        return prev;
    }

    private boolean hasRemaining(Node<?> head, final int k) {
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }


}
