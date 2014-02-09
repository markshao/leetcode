package leetcode.oj.bestTimeSellAndBuyTheStock;

//http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Solution {

	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		return find(prices, prices.length - 1);
	}

	public int find(int[] arr, int maxIdx) {
		if (maxIdx < 1) {
			return 0;
		}
		int min = arr[0];
		int minIdx = 0;
		for (int i = 1; i <= maxIdx; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIdx = i;
			}
		}

		// Find right max
		int maxRight = 0;
		for (int i = minIdx + 1; i <= maxIdx; i++) {
			int tmp = arr[i] - min;
			if (tmp > maxRight) {
				maxRight = tmp;
			}
		}
		int maxLeft = 0;
		if (minIdx == 2) {
			maxLeft = arr[1] - arr[0];
		} else if (minIdx > 2) {
			maxLeft = find(arr, minIdx - 1);
		}

		if (maxRight > maxLeft) {
			return maxRight;
		} else {
			return maxLeft;
		}
	}
}
