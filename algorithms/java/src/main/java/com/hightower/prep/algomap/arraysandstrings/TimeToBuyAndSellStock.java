package com.hightower.prep.algomap.arraysandstrings;

// TODO JH revisit this one, it's straightforward but the solution didn't jump out
public class TimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price: prices) {
           if (price < minPrice) {
               minPrice = price;
           } else {
               int profit = price - minPrice;
               if (profit > maxProfit) {
                   maxProfit = profit;
               }
           }
        }
        return maxProfit;
    }
}
