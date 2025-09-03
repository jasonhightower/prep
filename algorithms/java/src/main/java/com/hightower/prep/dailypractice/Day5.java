package com.hightower.prep.dailypractice;

import com.hightower.prep.core.TimeMap;

import java.sql.Time;
import java.util.*;

public class Day5 {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public boolean search2DMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rowLength = matrix[0].length;
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            int midR = mid / rowLength;
            int midC = mid % rowLength;
            if (matrix[midR][midC] == target) {
                return true;
            } else if (matrix[midR][midC] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public int kokoEatingBananas(int[] piles, int hours) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int k = (left + right)/2;
            long totalTime = 0;
            for (int pile : piles) {
                 totalTime += Math.ceil((double) pile/k);
            }
            if (totalTime <= hours) {
                result = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return result;
    }

    // TODO JH revisit this, need to nail down setting left, mid and right
    // so that left ends up pointing at the solution when the loop ends
    public int findMinimumInRotatedSortedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right - 1 )/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int searchInRotatedSortedArray(int[] nums, int target) {
        // find the cut
        int left = 0;
        int right = nums.length - 1;
        int cut = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                cut = mid;
                break;
            }
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[0] >= target && nums[cut] <= target) {
            left = 0;
            right = cut;
        } else {
            left = cut + 1;
            right = nums.length - 1;
        }
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public TimeMap timeBasedKeyValueStore() {
        return new TimeMap() {
            private Map<String, List<Object[]>> map = new HashMap<>();

            @Override
            public void set(String key, String value, long timestamp) {
               final List<Object[]> values = this.map.computeIfAbsent(
                       key,
                       (k) -> new ArrayList<>());

               values.add(new Object[] {value, timestamp});
            }

            @Override
            public String get(String key, long timestamp) {
                List<Object[]> values = this.map.get(key);
                int left = 0;
                int right = values.size();
                String res = null;
                while (left < right) {
                    int mid  = (left + right - 1)/2;
                    Object[] val = values.get(mid);
                    if ((long)val[1] <= timestamp) {
                        res = (String)val[0];
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                return res;
            }
       };
    }

    // TODO JH this is a tricky one, definitely need to revisit and nail it down
    // I understood the basics but not exactly how to execute it
    public double medianTwoSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller, larger;
        if (nums1.length < nums2.length) {
            smaller = nums1;
            larger = nums2;
        } else {
            smaller = nums2;
            larger = nums1;
        }
        int total = smaller.length + larger.length;
        int half = (total + 1)/2;

        int left = 0;
        int right = smaller.length;
        while (left <= right) {
            int mid = (left + right)/2;
            int sLeft = mid > 0 ? smaller[mid - 1] : Integer.MIN_VALUE;
            int sRight = mid < smaller.length ? smaller[mid] : Integer.MAX_VALUE;

            int lMid = half - mid;
            int lLeft = lMid > 0 ? larger[lMid - 1] : Integer.MIN_VALUE;
            int lRight = lMid < larger.length ? larger[lMid] : Integer.MAX_VALUE;

            if (sLeft <= lRight && lLeft <= sRight) {
                // found the answer
                if (total % 2 != 0) {
                    return Math.max(sLeft, lLeft);
                }
                return (Math.max(sLeft, lLeft) + Math.min(sRight, lRight))/2.0;
            } else if (sLeft < sRight) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
