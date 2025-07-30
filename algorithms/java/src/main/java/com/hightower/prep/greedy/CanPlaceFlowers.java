package com.hightower.prep.greedy;

public class CanPlaceFlowers {

    public boolean calculateSimpleGreedy(int[] flowerbed, int num) {
        int spotsInARow = 1;
        int i = 0;
        int count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0) {
                spotsInARow++;
            } else {
                spotsInARow = 0;
            }
            if (spotsInARow == 3) {
                count++;
                spotsInARow = 1;
            }
            if (count == num) {
                return true;
            }
            i++;
        }
        spotsInARow++;
        if (spotsInARow >= 3) {
            return count + 1 == num;
        }
        return false;
    }

}
