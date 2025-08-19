package com.hightower.prep.algomap.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summarize(int[] nums) {
        List<String> results = new ArrayList<>();
        int pos = 0;
        int start = nums[pos++];
        while (pos < nums.length) {
            if (nums[pos] -1 != nums[pos - 1]) {
               StringBuilder builder = new StringBuilder();
               builder.append(nums[start]);
               if (start + 1 != pos) {
                   builder.append("->");
                   builder.append(nums[pos - 1]);
               }
               start = pos;
               results.add(builder.toString());
            }
            pos++;
        }
        if (start < nums.length) {
            StringBuilder builder = new StringBuilder();
            builder.append(nums[start]);
            if (start + 1 < nums.length) {
                builder.append("->");
                builder.append(nums[nums.length - 1]);
            }
            results.add(builder.toString());
        }
        return results;
    }
}
