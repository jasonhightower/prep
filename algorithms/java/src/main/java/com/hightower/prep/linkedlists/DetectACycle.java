package com.hightower.prep.linkedlists;

public class DetectACycle {

   public boolean isCyclic(final Node<?> head) {
       Node<?> slow = head;
       Node<?> fast = head;
       while (fast != null && slow != null) {
           fast = fast.getNext();
           if (fast == null) {
               return false;
           }
           fast = fast.getNext();
           slow = slow.getNext();
           if (fast == slow) {
               return true;
           }
       }
       return false;
   }

}
