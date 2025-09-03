package com.hightower.prep.dailypractice;

import com.hightower.prep.core.LinkedNode;
import com.hightower.prep.core.LinkedNodeWRandom;

import java.util.HashMap;
import java.util.Map;

public class Day7 {

    // JH revisit this one, need to remember that we can split up a linked list and reverse it
    public LinkedNode<Integer> reorderList(final LinkedNode<Integer> head) {
        // find the mid-point
        LinkedNode<Integer> slow = head;
        LinkedNode<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split into two linked lists and reverse the second one
        LinkedNode<Integer> second = slow.next;
        LinkedNode<Integer> prev = null;
        slow.next = null;
        while (second != null) {
            LinkedNode<Integer> tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // merge the two linked lists
        LinkedNode<Integer> first = head;
        second = prev;
        while (second != null) {
            LinkedNode<Integer> firstTmp = first.next;
            LinkedNode<Integer> secondTmp = second.next;
            first.next = second;
            second.next = firstTmp;
            first = firstTmp;
            second = secondTmp;
        }
        return head;
    }

    // JH revisit this, had the concept correct but using a dummy to store/manage the head reference
    //    simplified the implementation
    public LinkedNode<Integer> removeNthNode(final LinkedNode<Integer> head, final int n) {
        LinkedNode<Integer> dummy = new LinkedNode<>(0);
        dummy.next = head;

        LinkedNode<Integer> slow = dummy;
        LinkedNode<Integer> fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public LinkedNodeWRandom<Integer> copyListWithRandom(final LinkedNodeWRandom<Integer> head) {
        Map<Integer, LinkedNodeWRandom<Integer>> valueToNode = new HashMap<>();

        LinkedNodeWRandom<Integer> dummy = new LinkedNodeWRandom<>(0);
        LinkedNodeWRandom<Integer> prev = dummy;
        LinkedNodeWRandom<Integer> current = head;
        while (current != null) {
            LinkedNodeWRandom<Integer> copy = new LinkedNodeWRandom<>(current.value);
            valueToNode.put(copy.value, copy);
            prev.next = copy;
            prev = copy;
            current = (LinkedNodeWRandom<Integer>) current.next;
        }

        current = head;
        LinkedNodeWRandom<Integer> copy = (LinkedNodeWRandom<Integer>) dummy.next;
        while (current != null) {
            if (current.random != null) {
                copy.random = valueToNode.get(current.random.value);
            }
            current = (LinkedNodeWRandom<Integer>) current.next;
            copy = (LinkedNodeWRandom<Integer>) copy.next;
        }
        return (LinkedNodeWRandom<Integer>) dummy.next;
    }
}
