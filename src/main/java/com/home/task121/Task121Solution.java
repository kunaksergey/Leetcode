package com.home.task121;
//121. Best Time to Buy and Sell Stock
public class Task121Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = prices.length-1 ; i >=1  ; i--) {
            int sell = prices[i];
            for (int j = i-1; j >=0 ; j--) {
                int buy = prices[j];
                if(sell>buy){
                    profit = Math.max(profit,sell-buy);
                }
            }
        }
        return profit;
    }
}
