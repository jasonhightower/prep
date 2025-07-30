package com.hightower.prep.twopointer;

// TODO JH study this
public class MoveZeroes {

    public int[] move(int[] numbers) {
        int slow=0, fast=0;
        while (fast < numbers.length) {
            if (numbers[fast]!=0) {
                numbers[slow] = numbers[fast];
                slow++;
            }
            fast++;
        }
        while (slow < numbers.length) {
            numbers[slow++] = 0;
        }
        return numbers;
    }

}
