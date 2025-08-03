package com.hightower.prep.linkedlists;

public class MaximumTwinTwoSum {

    public int calculate(final Node<Integer> head) {
        if (head.getNext().getNext() == null) {
            return head.getVal() + head.getNext().getVal();
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        Node<Integer> prev = null;
        Node<Integer> current = slow;
        while (fast != null) {
            fast = fast.getNext();
            if (fast != null) {
                fast = fast.getNext();
            }
            slow = slow.getNext();
            current.setNext(prev);
            prev = current;
            current = slow;
        }
        int max = Integer.MIN_VALUE;
        while (prev != null && slow != null) {
            max = Math.max(max, prev.getVal() + slow.getVal());
            prev = prev.getNext();
            slow = slow.getNext();
        }
        return max;
    }

}
