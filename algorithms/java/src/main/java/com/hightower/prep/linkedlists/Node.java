package com.hightower.prep.linkedlists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    public static Node<Integer> fromArray(int[] array) {
        if (array.length == 0) {
            return null;
        }
        Node<Integer> head = new Node<>(array[0]);
        Node<Integer> current = head;
        for (int i = 1; i < array.length; i++) {
            Node<Integer> next = new Node<>(array[i]);
            current.setNext(next);
            current = next;
        }
        return head;
    }

    private final T val;

    public Node(T val) {
        this.val = val;
    }

    public T getVal() {
        return this.val;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public int length() {
        return this.next == null ? 1 : 1 + this.next.length();
    }

    public T[] toArray() {
        List<T> values = new ArrayList<>();
        values.add(this.val);
        Node<T> current = getNext();
        while (current != null) {
            values.add(current.getVal());
            current = current.getNext();
        }
        T[] array = (T[]) Array.newInstance(this.val.getClass(), values.size());
        return values.toArray(array);
    }

    private Node<T> next;

}
