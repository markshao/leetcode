package leetcode.oj.bestTimeSellAndBuyTheStockIII;

/**
 * Created by mark on 2/10/14.
 */

//http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int res = 0;
        int[] data = new int[prices.length];

        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if ((prices[i] - min) > profit)
                profit = prices[i] - min;
            data[i] = profit;
            if (prices[i] < min)
                min = prices[i];
        }

        int max = prices[prices.length - 1];

        for (int j = prices.length - 1; j > -1; j--) {
            if ((max - prices[j] + data[j]) > res)
                res = (max - prices[j] + data[j]);
            if (prices[j] > max)
                max = prices[j];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] data = {1};
        new Solution().maxProfit(data);
    }
}
