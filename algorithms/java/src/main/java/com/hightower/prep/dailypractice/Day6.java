package com.hightower.prep.dailypractice;

import com.hightower.prep.core.LinkedNode;

import java.util.*;

public class Day6 {

    public int bestTimeToBuySellStock(final int[] prices) {
        int buy = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[buy]) {
                buy = i;
            } else {
                max = Math.max(prices[i] - prices[buy], max);
            }
        }
        return Math.max(0, max);
    }

    public int longestSubstringWithoutRepeating(final String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        int slow = 0;
        int max = 0;
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            while (seen.contains(c)) seen.remove(text.charAt(slow++));
            seen.add(c);
            max = Math.max(max, seen.size());
        }
        return max;
    }

    public int longestRepeatingCharacterReplacement(final String text, final int replacements) {
        Map<Character, Integer> frequencies = new HashMap<>();
        char mostFrequent = text.charAt(0);
        int max = 0;
        for (char c : text.toCharArray()) {
            int freq = frequencies.compute(c, (k,v) -> v == null ? 0 : v + 1);
            if (freq > max) {
               mostFrequent = c;
               max = freq;
            }
        }

        int slow = 0;
        max = 0;
        int numReplaced = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != mostFrequent) {
                numReplaced++;
            }
            while (slow < text.length() && numReplaced > replacements) {
                if (text.charAt(slow) != mostFrequent) {
                   numReplaced--;
                }
                slow++;
            }
            max = Math.max(max, i + 1 - slow);
        }
        return max;
    }

    // TODO JH revisit this one, instead of storing counts in a map they can be stored in an array
    public boolean permutationInString(final String s1, final String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for (char c: s1.toCharArray()) {
            counts1[c-'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            counts2[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] == counts2[i]) {
                matches++;
            }
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); left++,right++) {
            if (matches == 26) {
                return true;
            }
            int leftChar = s2.charAt(left)-'a';
            int rightChar = s2.charAt(right)-'a';
            counts2[leftChar]--;
            counts2[rightChar]++;
            if (counts1[leftChar] == counts2[leftChar]) {
                matches++;
            } else if (counts1[leftChar] - 1 == counts2[leftChar]){
                matches--;
            }
            if (counts1[rightChar] == counts2[rightChar]) {
                matches++;
            } else if (counts1[rightChar] + 1 == counts2[rightChar]){
                matches--;
            }
        }
        return false;
    }

    public String minimumWindowSubstring(final String s, final String t) {
        Map<Character, Integer> tCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCounts.compute(c, (k,v) -> v == null ? 1 : v + 1);
        }

        Map<Character, Integer> sCounts = new HashMap<>();
        int matches = 0;
        int left = 0;
        int resultStart = -1;
        int resultLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sCounts.compute(c, (k,v) -> v == null ? 1 : v + 1);

            if (tCounts.containsKey(c) && tCounts.get(c).equals(sCounts.get(c))) {
                matches++;
            }

            if (matches == tCounts.size()) {
                while (matches == tCounts.size()) {
                    if (right - left < resultLength) {
                        resultStart = left;
                        resultLength = right - left + 1;
                    }
                    char pop = s.charAt(left);
                    int popCounts = sCounts.compute(pop, (k,v) -> v - 1);
                    if (tCounts.containsKey(pop) && popCounts < tCounts.get(pop)) {
                        matches--;
                    }
                    left++;
                }
            }
        }
        return resultStart == -1 ? "" : s.substring(resultStart, resultStart + resultLength);
    }

    // TODO revisit this one for sure
    public int[] slidingWindowMaximum(final int[] nums, final int k) {
        List<Integer> results = new ArrayList<>();
        PriorityQueue<int[]> maximums = new PriorityQueue<>(Comparator.comparingInt(o -> ((int[])o)[0]).reversed());

        for (int i = 0; i < k; i++) {
            maximums.add(new int[]{nums[i], i});
        }

        // use a max heap to maintain the maximum value in the window
        int left = 0;
        int right = k;
        while (right < nums.length) {
            int[] max = maximums.peek();
            if (max[1] < left) {
                maximums.remove();
                max = maximums.peek();
            }
            results.add(max[0]);
            maximums.add(new int[]{nums[right], right});
            left++;
            right++;
        }
        results.add(maximums.remove()[0]);
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    public LinkedNode<Integer> reverseLinkedList(final LinkedNode<Integer> head) {
        LinkedNode<Integer> cur = head;
        LinkedNode<Integer> prev = null;
        LinkedNode<Integer> temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public LinkedNode<Integer> mergeTwoSortedLinkedLists(
            final LinkedNode<Integer> l1,
            final LinkedNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.value < l2.value) {
            l1.next = mergeTwoSortedLinkedLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoSortedLinkedLists(l1, l2.next);
        return l2;
    }

    public boolean detectCycleInLinkedList(final LinkedNode<?> head) {
        if (head == null) {
            return false;
        }
        LinkedNode<?> slow = head;
        LinkedNode<?> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
