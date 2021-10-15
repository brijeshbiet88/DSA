package com.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuySellStockWithCoolDown {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1----------------");
        int prices [] = {1 , 2 , 3 , 0 ,2};
        System.out.println("Max Profit = "+maxProfit(prices));
        System.out.println();
    }

    public static int maxProfit(int[] prices) {
        Map<String , Integer> map = new HashMap<String,Integer>();
        boolean isBuyCall = true;
        return maxProfit(0 , isBuyCall , prices , map);
    }

    public static int maxProfit(int i , boolean isBuyCall , int [] prices , Map<String , Integer> map){

        if(i >= prices.length)
            return 0;

        int maxProfit = 0;
        String key = i+":"+isBuyCall;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(isBuyCall){
            int buy     = maxProfit(i + 1 , false , prices , map) - prices[i];
            int skipbuy = maxProfit(i + 1 , true , prices , map);
            maxProfit = Math.max(buy , skipbuy);
        }else{
            int sell     = maxProfit(i + 2 , true , prices , map) + prices[i];
            int skipsell = maxProfit(i + 1 , false , prices, map);
            maxProfit = Math.max(sell , skipsell);
        }
        map.put(key, maxProfit);
        return maxProfit;
    }
}
