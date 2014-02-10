package leetcode.oj.bestTimeSellAndBuyTheStockII;

/**
 * Created by mark on 2/10/14.
 */

//http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class Solution {
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        int[][] data = new int[prices.length][prices.length];
//
//        for (int i = 0; i < prices.length; i++) {
//            int ci = i;
//            for (int duration = 1; duration < prices.length - 1; duration++) {
//                if (ci >= 2 && i == duration) {
//                    int tmp = data[0][duration];
//                    int value = prices[ci-1] - prices[0];
//                    tmp = tmp - value;
//
//                    if (tmp > max) {
//                        max = tmp;
//                    }
//
//                } else {
//                    int tmp = 0;
//                    int j = ci + duration;
//                    while (j < prices.length) {
//                        tmp += (prices[j] - prices[ci]);
//                        ci = ci + 1 + duration;
//                        j = ci + duration;
//                    }
//
//                    data[i][duration] = tmp;
//
//                    if (tmp > max) {
//                        max = tmp;
//                    }
//                }
//            }
//        }
//        return max;
//    }


    // the following calculation is under the assumption that we can do the transaction in the same day
    // for example , sell 12@TUE and buy 12@TUE
    // the above algorithm only support the sell 12@TUE/buy 12@TUE at one day

    public int maxProfit(int[] prices) {
        int p = 0;
        for (int i = 1; i < prices.length; ++i) {
            int delta = prices[i] - prices[i - 1];
            if (delta > 0) {
                p += delta;
            }
        }
        return p;
    }
}
