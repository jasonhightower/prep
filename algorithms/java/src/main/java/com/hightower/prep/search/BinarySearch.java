package com.hightower.prep.search;

import java.util.Optional;

public class BinarySearch {

    public Optional<Integer> find(int target, int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int pos = (left + right)/2;
            if (target == numbers[pos]) {
                return Optional.of(pos);
            } else if (target < numbers[pos]) {
                right = pos-1;
            } else {
                left = pos+1;
            }
        }
        return Optional.empty();
    }

}
