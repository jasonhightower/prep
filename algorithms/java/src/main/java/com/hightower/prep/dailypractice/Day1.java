package com.hightower.prep.dailypractice;

import java.util.*;

public class Day1 {

    public boolean containsDuplicate(int[] input) {
        final Set<Integer> seen = new HashSet<>();
        for (int num: input) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean validAnagram(final String first,
                                final String second) {
        if (first.length() != second.length()) {
            return false;
        }
        int[] fCounts = new int[26];
        int[] sCounts = new int[26];
        for (Character c: first.toCharArray()) fCounts[c-'a']++;
        for (Character c: second.toCharArray()) sCounts[c-'a']++;
        return Arrays.equals(fCounts, sCounts);
    }

    public int[] twoSum(final int[] nums,
                          final int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (seen.containsKey(remaining)) {
                return new int[] {seen.get(remaining), i};
            }
            seen.put(nums[i], i);
        }
        return null;
    }

    public List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> groups = new LinkedHashMap<>();
        for (String in: input) {
            char[] chars = in.toCharArray();
            Arrays.sort(chars);
            groups.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(in);
        }
        return new ArrayList<>(groups.values());
    }

    public int[] topKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.compute(num, (key, v) -> v == null ? 1 : v + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();
            int num = entry.getKey();
            List<Integer> bucket = buckets[count];
            if (bucket == null) {
                bucket = new ArrayList<>();
                buckets[count] = bucket;
            }
            bucket.add(num);
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; index < k && i >= 0; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (int num : bucket) {
                    result[index] = num;
                    index++;
                    if (index >= k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public int[] productExceptSelf(final int[] nums) {
        int[] results = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            results[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] *= suffix;
            suffix *= nums[i];
        }
        return results;
    }


    public boolean validSudoku(final Integer[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> boxes = new HashMap<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                Integer val = board[row][col];
                if (val == null) {
                    continue;
                }
                Set<Integer> rowSet = rows.computeIfAbsent(row, key -> new HashSet<>());
                if (!rowSet.add(val)) {
                    return false;
                }
                Set<Integer> colSet = cols.computeIfAbsent(col, key -> new HashSet<>());
                if (!colSet.add(val)) {
                    return false;
                }

                int box = row / 3 + (3 * (col / 3));
                Set<Integer> boxSet = boxes.computeIfAbsent(box, key -> new HashSet<>());
                if (!boxSet.add(val)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String[] encodeAndDecode(final String[] input) {
        final Character SEPARATOR = '#';
        StringBuilder builder = new StringBuilder();
        for (String in : input) {
            builder.append(in.length());
            builder.append(SEPARATOR);
            builder.append(in);
        }
        final String encoded = builder.toString();

        List<String> decoded = new ArrayList<>();
        int cursor = 0;
        while (cursor < encoded.length()) {
            int separator = cursor;
            while (encoded.charAt(separator) != SEPARATOR) separator++;
            int length = Integer.parseInt(encoded.substring(cursor, separator));
            cursor = separator + 1;
            decoded.add(encoded.substring(cursor, cursor + length));
            cursor += length;
        }
        return decoded.toArray(new String[0]);
    }

    public int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) numSet.add(num);

        int max = 0;
        for (int num: nums) {
            if (!numSet.contains(num -1)) {
                // is start
                int cur = num + 1;
                while (numSet.contains(cur)) cur++;
                if (cur - num > max) {
                    max = cur - num;
                }
            }
        }
        return max;
    }

    public boolean validPalindrome(final String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            char leftC = input.charAt(left);
            while (left < right && !Character.isLetterOrDigit(leftC)) {
               left++;
               leftC = input.charAt(left);
            }
            leftC = Character.toLowerCase(leftC);

            char rightC = input.charAt(right);
            while (left < right && !Character.isLetterOrDigit(rightC)) {
                right--;
                rightC = input.charAt(right);
            }
            rightC = Character.toLowerCase(rightC);

            if (leftC != rightC) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int[] twoSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int result = nums[left] + nums[right];
            if (result == target) {
                return new int[] {left+1, right+1};
            } else if (result > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }

}
