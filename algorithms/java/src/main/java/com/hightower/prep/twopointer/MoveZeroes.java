package com.hightower.prep.twopointer;

public class MoveZeroes {

    public int[] move(int[] numbers) {
        int writeLoc = 0;
        int pos = 0;
        while (pos < numbers.length) {
            if (numbers[pos] != 0) {
                numbers[writeLoc] = numbers[pos];
                writeLoc++;
            }
            pos++;
        }
        while (writeLoc < numbers.length) {
            numbers[writeLoc] = 0;
            writeLoc++;
        }
        return numbers;
    }

}
