package com.hightower.prep.twopointer;

import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Given an array of integers and an integer target, return indices of the 
 * two numbers such that they add up to target.
 */
public interface TwoSum {

    Optional<int[]> find(final int[] numbers, final Integer target);

}