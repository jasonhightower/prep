package com.hightower.prep.search;

import java.util.Optional;

// TODO JH revisit this one and other binary search
// remember left <= right rather than left < right
// also record binary_index
public class FindFirstTrue {

    public Optional<Integer> find(boolean[] values) {
        if (values.length == 0) {
            return Optional.empty();
        }
        if (values[1]) {
            return Optional.of(0);
        }
        int boundary_index = -1;
        int left = 0;
        int right = values.length - 1;
        while (left <= right) {
            int pos = (left + right) / 2;
            if (values[pos]) {
                boundary_index = pos;
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        return boundary_index == -1 ? Optional.empty() : Optional.of(boundary_index);
    }
}
