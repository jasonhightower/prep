package com.hightower.prep.linkedlists;

public class OddEven {

    public <T> Node<T> group(Node<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node<T> even = head.getNext();
        Node<T> oddTail = head;
        Node<T> evenTail = even;
        Node<T> current = evenTail.getNext();
        boolean isOdd = true;
        while (current != null) {
            if (isOdd) {
                oddTail.setNext(current);
                oddTail = current;
            } else {
                evenTail.setNext(current);
                evenTail = current;
            }
            current = current.getNext();
            isOdd = !isOdd;
        }
        oddTail.setNext(even);
        evenTail.setNext(null);
        return head;
    }

}
