package leetcode.oj.bestTimeSellAndBuyTheStock;

//http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Solution {
	static int result = 0;

	public int maxProfit(int[] prices) {
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] >  prices[i]) {
					int gap = prices[j] - prices[i];
					if (gap > result)
						result = gap;
				}
			}
		}
		return result;
	}
}
